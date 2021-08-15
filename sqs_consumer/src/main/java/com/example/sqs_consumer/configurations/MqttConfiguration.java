package com.example.sqs_consumer.configurations;


import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class MqttConfiguration {

  @Bean
  @ConfigurationProperties(prefix = "mqtt")
  public MqttConnectOptions mqttConnectOptions() {
    return new MqttConnectOptions();
  }

  @Bean
  public IMqttClient mqttClient(
      @Value("${mqtt.clientId}") String clientId,
      @Value("${mqtt.host}") String host) throws MqttException {

    IMqttClient mqttClient = new MqttClient(host, clientId);
    mqttClient.connect(mqttConnectOptions());

    return mqttClient;
  }

}
