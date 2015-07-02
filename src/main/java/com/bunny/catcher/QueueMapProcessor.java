package com.bunny.catcher;

import com.bunny.config.BunnyConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: perrygil
 * Date: 01/07/2015
 * Time: 21:13
 * To change this template use File | Settings | File Templates.
 */
public class QueueMapProcessor {

    final BunnyConfig bunnyConfig;

    private List<QueueMap> queueMaps;

    public QueueMapProcessor(final BunnyConfig bunnyConfig){
          this.bunnyConfig = bunnyConfig;
    }

    public List<QueueMap> getQueueMaps(){
       if(queueMaps == null){
           queueMaps = new ArrayList<QueueMap>();
       }
       return queueMaps;
    }

    private List<String> processRoutingKeys(final int queueNum){

        String rk;

        List<String> routingKeys = new ArrayList<String>();

        for(int i=1; (rk = bunnyConfig.getRoutingKey(queueNum, i)) != null; i++){
            System.out.println("Found routing key: " + rk);
            routingKeys.add(rk);
        }

        return routingKeys;
    }

    public void parseQueues(){
        String queueName;
        for(int queueCount=1; (queueName = bunnyConfig.getQueueName(queueCount)) !=null; queueCount++){

            System.out.println("Found queue name: " + queueName);

            QueueMap queueMap = new QueueMap(queueName, processRoutingKeys(queueCount));
            getQueueMaps().add(queueMap);

        }

    }


}
