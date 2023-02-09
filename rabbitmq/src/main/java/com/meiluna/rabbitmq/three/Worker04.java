package com.meiluna.rabbitmq.three;

import com.meiluna.rabbitmq.utils.RabbitMQUtils;
import com.meiluna.rabbitmq.utils.SleepUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;

public class Worker04 {

    public static final String TASK_QUEUE_NAME = "ack_queue";

    //接收消息
    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMQUtils.getChannel();
        System.out.println("C2等待消息处理，处理时间较长");

        //声明 接收消息
        DeliverCallback deliverCallback = (consumerTag, message)->{
            //要求沉睡1s
            SleepUtils.sleep(15);
            System.out.println("C2号接收到的消息："+new String(message.getBody()));

            /**
             * 1、消息标记，表示自己应答的是哪个消息
             * 2、是否批量应答
             */
            channel.basicAck(message.getEnvelope().getDeliveryTag(),false);
        };

        //取消消息时的回调
        CancelCallback cancelCallback = consumerTag ->{
            System.out.println("消费被中断");
        };

        //采用手动应答
        boolean autoAck = false;
        channel.basicConsume(TASK_QUEUE_NAME,autoAck,deliverCallback,cancelCallback);
    }

}
