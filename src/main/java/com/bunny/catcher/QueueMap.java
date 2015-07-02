package com.bunny.catcher;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: perrygil
 * Date: 01/07/2015
 * Time: 20:47
 * To change this template use File | Settings | File Templates.
 */
public class QueueMap {

    private String queueName;
    private List<String> routingKeys;

    public QueueMap(final String queueName, final List<String> routingKeys) {
        this.queueName = queueName;
        this.routingKeys = routingKeys;
    }

    public String getQueueName(){
        return queueName;
    }

    public List<String> getRoutingKeys() {
        return routingKeys;
    }
}
