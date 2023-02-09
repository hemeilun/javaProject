package com.meiluna.rabbitmq.four;

import com.meiluna.rabbitmq.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;

import java.util.UUID;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 确认发布模式
 * 1、单个确认
 * 2、批量确认
 * 3、异步批量确认
 */
public class ConfirmMessage {

    //批量发消息的数量
    public static final int MESSAGE_COUNT = 1000;

    public static void main(String[] args) throws Exception {
        //1、单个确认
//        ConfirmMessage.publishMessageIndividually();

        //2、批量确认
//        ConfirmMessage.publishMessageBatch();
        //3、异步批量确认

        ConfirmMessage.publishMessageAsync();
    }

    //单个确认
    public static void publishMessageIndividually() throws Exception{
        Channel channel = RabbitMQUtils.getChannel();

        //队列声明
        String squeueName = UUID.randomUUID().toString();
        channel.queueDeclare(squeueName,true,false,false,null);

        //开启确认发布
        channel.confirmSelect();

        //开始时间
        long begin = System.currentTimeMillis();

        //批量发消息
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = i+"";
            channel.basicPublish("",squeueName,null,message.getBytes());

            //单个消息就马上确认
            boolean flag = channel.waitForConfirms();
//            if (flag){
//                System.out.println("发送成功");
//            }

        }

        long end = System.currentTimeMillis();
        System.out.println("发布"+MESSAGE_COUNT+"条单个确认消息耗时："+(end-begin)+"ms");

    }

    //批量确认
    public static void publishMessageBatch() throws Exception{
        Channel channel = RabbitMQUtils.getChannel();

        //队列声明
        String squeueName = UUID.randomUUID().toString();
        channel.queueDeclare(squeueName,true,false,false,null);

        //开启确认发布
        channel.confirmSelect();

        //开始时间
        long begin = System.currentTimeMillis();

        //批量确认消息的大小
        int batchSize = 100;

        //批量发消息
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = i+"";
            channel.basicPublish("",squeueName,null,message.getBytes());

            //100条确认一次
            if((i+1)%batchSize == 0){
                channel.waitForConfirms();
            }

        }

        long end = System.currentTimeMillis();
        System.out.println("发布"+MESSAGE_COUNT+"条批量确认消息耗时："+(end-begin)+"ms");

    }


    //异步发布确认
    public static void publishMessageAsync() throws Exception{
        Channel channel = RabbitMQUtils.getChannel();

        //队列声明
        String squeueName = UUID.randomUUID().toString();
        channel.queueDeclare(squeueName,true,false,false,null);

        //开启确认发布
        channel.confirmSelect();

        /**
         * 线程安全有序的一个哈希表 适用于高并发的情况下
         * 1、轻松的将序号与消息进行关联
         * 2、轻松的批量删除条目 只要给到序号
         * 3、支持高并发
         */
        ConcurrentSkipListMap<Long,String> outstandingConfirms = new ConcurrentSkipListMap<>();


        /**
         * 1、消息的标记
         * 2、是否为批量确认
         */
        //消息确认失败 回调函数
        ConfirmCallback ackCallback = (deliveryTag,multiple)->{
            if(multiple){
                //2、删除已经确认的消息，剩下的就是未确认的
                ConcurrentNavigableMap<Long, String> confirmed = outstandingConfirms.headMap(deliveryTag);
                confirmed.clear();
            }else {
                outstandingConfirms.remove(deliveryTag);
            }
            System.out.println("确认的消息："+deliveryTag);
        };

        //消息确认成功 回调函数
        ConfirmCallback nackCallback = (deliveryTag,multiple)->{
            //3、打印未确认的消息
            String s = outstandingConfirms.get(deliveryTag);
            System.out.println("未确认的消息："+deliveryTag+",内容是："+s);
        };

        //准备消息的监听器，监听哪些消息成功了，哪些失败了
        channel.addConfirmListener(ackCallback,nackCallback);

        //开始时间
        long begin = System.currentTimeMillis();


        //批量发消息
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = i+"";
            channel.basicPublish("",squeueName,null,message.getBytes());

            //1、此处记录下所有要发送的消息，消息的总和
            outstandingConfirms.put(channel.getNextPublishSeqNo(),message);
        }

        long end = System.currentTimeMillis();
        System.out.println("发布"+MESSAGE_COUNT+"条异步确认消息耗时："+(end-begin)+"ms");

    }
}
