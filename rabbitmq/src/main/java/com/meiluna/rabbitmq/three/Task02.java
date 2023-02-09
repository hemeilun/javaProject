package com.meiluna.rabbitmq.three;

import com.meiluna.rabbitmq.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 * 消息在手动应答中不丢失，放回队列中重新消费
 */
public class Task02 {

    public static final String TASK_QUEUE_NAME = "ack_queue";

    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMQUtils.getChannel();

        //开启发布确认


        //声明队列
        channel.queueDeclare(TASK_QUEUE_NAME,true,false,false,null);

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String message = scanner.next();
            channel.basicPublish("",TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes("utf-8"));
            System.out.println(message);
        }

    }
}
