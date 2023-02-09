package com.meiluna.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMQUtils {

    static Connection connection = null;
    static {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.217.128");
        factory.setUsername("guest");
        factory.setPassword("guest");

        try {
            connection = factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static Channel getChannel() throws IOException {
            return connection.createChannel();
    }
}
