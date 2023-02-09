package com.meiluna.rabbitmq.two;

import com.meiluna.rabbitmq.utils.RabbitMQUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;

/**
 * 这是一个工作线程，相当于之前的工作线程
 */
public class Worker01 {

    //队列名称
    public static final  String QUEUE_NAME = "hello";

    //接收消息
    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMQUtils.getChannel();

        //声明 接收消息
        DeliverCallback deliverCallback = (consumerTag, message)->{
            System.out.println("1号接收到的消息："+new String(message.getBody()));
        };

        //取消消息时的回调
        CancelCallback cancelCallback = consumerTag ->{
            System.out.println("消费被中断");
        };

        //消息的接收
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback);
    }
}
