package com.bunny.catcher;

import com.bunny.config.BunnyConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: perrygil
 * Date: 02/07/2015
 * Time: 10:47
 * To change this template use File | Settings | File Templates.
 */
public class BunnySubscriber {

    private List<QueueMap> queueMaps;
    private BunnyConfig bunnyConfig;

    public BunnySubscriber(final List<QueueMap> queueMaps, final BunnyConfig bunnyConfig) {
        this.queueMaps = queueMaps;
        this.bunnyConfig = bunnyConfig;
    }

    public void subscribe() throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(bunnyConfig.getHost());

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(bunnyConfig.getExchangeName(), "topic", true);

        for(QueueMap queueMap : queueMaps){
            System.out.println("Queue name " + queueMap.getQueueName());

            channel.queueDeclare(queueMap.getQueueName(), true, false, false, null);

            for(String routingKey : queueMap.getRoutingKeys()){
                System.out.println("Binding routing key " + routingKey);
                channel.queueBind(queueMap.getQueueName(), bunnyConfig.getExchangeName(), routingKey);

            }
        }

        channel.close();
        connection.close();
    }
}
