package com.meiluna.rabbitmq.one;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.concurrent.TimeoutException;

public class Consumer {
    //队列名称
    public static final  String QUEUE_NAME = "hello";
    //接收消息
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建一个工厂
        ConnectionFactory factory = new ConnectionFactory();
        //工厂IP，连接RabbitMQ队列
        factory.setHost("192.168.217.128");
        //用户名和密码
        factory.setUsername("guest");
        factory.setPassword("guest");

        //创建连接
        Connection connection = factory.newConnection();
        //获取信道
        Channel channel = connection.createChannel();

        //声明 接收消息
        DeliverCallback deliverCallback = (consumerTag,message)->{
            System.out.println(new String(message.getBody()));
        };

        //取消消息时的回调
        CancelCallback cancelCallback = consumerTag ->{
            System.out.println("消费被中断");
        };

        /**
         * 消费者接收消息
         * 1、消费哪个队列
         * 2、消费成功之后是否要自动应答 true 代表的自动应答 false 代表手动应答
         * 3、消费者未成功消费的回调
         * 4、消费者取消消费回调
         */
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback);
    }
}
