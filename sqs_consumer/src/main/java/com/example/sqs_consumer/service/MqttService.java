package com.example.sqs_consumer.service;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MqttService {

  private final IMqttClient mqttClient;

  @SneakyThrows
  public void publish(final String topic, final String payload, int qos, boolean retained) {

    MqttMessage mqttMessage = new MqttMessage();
    mqttMessage.setPayload(payload.getBytes());
    mqttMessage.setQos(qos);
    mqttMessage.setRetained(retained);

    mqttClient.publish(topic, mqttMessage);

    //mqttClient.publish(topic, payload.getBytes(), qos, retained);

    mqttClient.disconnect();
  }

  @SneakyThrows
  public void subscribe(final String topic) {
    System.out.println("Messages received:");

    mqttClient.subscribeWithResponse(topic, (tpic, msg) -> {
      System.out.println(msg.getId() + " -> " + new String(msg.getPayload()));
    });
  }

}
