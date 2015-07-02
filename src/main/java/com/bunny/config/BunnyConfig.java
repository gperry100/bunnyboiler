package com.bunny.config;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: perrygil
 * Date: 02/07/2015
 * Time: 11:05
 * To change this template use File | Settings | File Templates.
 */
public class BunnyConfig {

    private final Properties properties;

    public BunnyConfig(final Properties properties){
        this.properties = properties;
    }

    public String getRoutingKey(final int queueNum, final int keyIndex){
        return properties.getProperty("bunny.queue." + queueNum + ".routing-key." + keyIndex);
    }

    public String getQueueName(final int queueNum){
        return properties.getProperty("bunny.queue." + queueNum + ".name");
    }

    public String getHost(){
        return properties.getProperty("bunny.host");
    }

    public String getExchangeName() {
        return properties.getProperty("bunny.exchange");
    }
}
