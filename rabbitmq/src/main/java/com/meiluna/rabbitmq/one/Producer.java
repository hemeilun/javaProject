package com.meiluna.rabbitmq.one;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    public static final String QUEUE_NAME = "hello";

    //发消息
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建一个工厂
        ConnectionFactory factory = new ConnectionFactory();
        //工厂IP，连接RabbitMQ队列
        factory.setHost("192.168.217.128");
//        factory.setPort(5672);
        //用户名和密码
        factory.setUsername("guest");
        factory.setPassword("guest");

        //创建连接
        Connection connection = factory.newConnection();
        //获取信道
        Channel channel = connection.createChannel();

        /**
         * 生成一个队列
         * 1、队列名称
         * 2、队列里面的消息是否持久化，默认是存储在内存中
         * 3、该队列是否只供一个消费者进行消费，是否进行消息共享，true可以多个消费消费
         * 4、是否自动删除。最后一个消费者开连接以后，该队列是否自动删除，true自动删除
         * 5、其他参数
         */
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //发消息
        String message = "hello world";

        /**
         * 发送一个消息
         * 1、发送到那个交换机
         * 2、路由的key值是哪个，本次是队列的名称
         * 3、其他参数
         */
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println("消息发送");
    }
}
