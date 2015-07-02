package com.bunny.catcher;

import com.bunny.config.BunnyConfig;
import com.bunny.config.Configuration;

public class BunnyBoiler {

    public static void main(String[] argv)
            throws Exception {

        BunnyConfig bunnyConfig = new BunnyConfig(Configuration.getProperties());

        QueueMapProcessor queueMapProcessor = new QueueMapProcessor(bunnyConfig);
        queueMapProcessor.parseQueues();

        System.out.println("Number of queues to set up: " + queueMapProcessor.getQueueMaps().size());

        BunnySubscriber bunnySubscriber = new BunnySubscriber(queueMapProcessor.getQueueMaps(), bunnyConfig);
        bunnySubscriber.subscribe();

    }
}