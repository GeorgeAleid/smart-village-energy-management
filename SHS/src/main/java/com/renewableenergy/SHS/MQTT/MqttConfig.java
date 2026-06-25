package com.renewableenergy.SHS.MQTT;

public abstract class MqttConfig {
    protected final String broker = System.getenv().getOrDefault("MQTT_HOST", "127.0.0.1");
    protected final int qos = Integer.parseInt(System.getenv().getOrDefault("MQTT_QOS", "1"));
    protected Boolean hasSSL = false;
    protected final int port = Integer.parseInt(System.getenv().getOrDefault("MQTT_PORT", "1883"));
    protected final String username = System.getenv().getOrDefault("MQTT_USERNAME", "user1");
    protected final String password = System.getenv().getOrDefault("MQTT_PASSWORD", "user1");
    protected final String TCP = "tcp://";
    protected final String SSL = "ssl://";


    /**
     * Custom Config
     * @param _broker
     * @param _port
     * @param _ssl
     * @param withAuth
    * */
    protected abstract void config(String _broker, Integer _port, Boolean _ssl, Boolean withAuth);

    /**
     * Default Config
     */
    protected abstract void config();

}
