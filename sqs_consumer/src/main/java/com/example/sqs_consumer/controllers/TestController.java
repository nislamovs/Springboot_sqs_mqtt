package com.example.sqs_consumer.controllers;


import static org.springframework.http.ResponseEntity.ok;

import com.example.sqs_consumer.service.MqttService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TestController {

  private final MqttService mqttService;

  //http://localhost:8080/api/v1/mqtt/test

  @GetMapping("/mqtt/test")
  public ResponseEntity mqttTest() {
    final String topic = "testamq/topic/event";

    mqttService.subscribe(topic);

    mqttService.publish(topic, "Hi\nThis is a sample message from amq", 0, true);

    return ok("Test ok!");
  }

}
