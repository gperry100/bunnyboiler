package com.bunny.config;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: perrygil
 * Date: 01/07/2015
 * Time: 20:40
 * To change this template use File | Settings | File Templates.
 */
public class Configuration {

    public static final Properties properties = new Properties();
    public static final String PROPERTIES_FILE = "bunnyboiler.properties";
    private static final Logger LOG = Logger.getLogger(Configuration.class);

    static {
        String transactionId = UUID.randomUUID().toString();
        InputStream propertiesInputStream = ClassLoader.getSystemResourceAsStream(PROPERTIES_FILE);

        try {
            properties.load(propertiesInputStream);
            System.out.println("Loaded configuration from ${ClassLoader.getSystemResource(PROPERTIES_FILE).path}");

        } catch (IOException e) {
            System.out.println("Unable to load configuration from " + PROPERTIES_FILE);

        }
    }



    public static Properties getProperties() {
        return properties;
    }


}
