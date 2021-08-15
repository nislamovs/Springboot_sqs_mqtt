package com.example.sqs_consumer.queueHandlers;

import com.amazonaws.services.sqs.model.Message;
import com.example.sqs_consumer.service.MqttService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageHandlingService {

  private final MqttService mqttService;

  private final String topic = "testamq/topic/event";

  @SqsListener(value = "${cloud.aws.end-point.uri}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
  public void receiveMessage(Message message) {
    log.info("message received {} - {}", message.toString(), message.getBody());

    mqttService.publish(topic, message.getBody(), 0, true);
  }

//  private final QueueMessagingTemplate queueMessagingTemplate;
//
//  public ResponseDto sendMessage(MessageDto messageDto) {
//    log.info("Sending Message to SQS: {},", messageDto);
//    queueMessagingTemplate.convertAndSend(endpoint, buildMessage(messageDto));
//
//    return ResponseDto.builder().responseMsg("Message sent!").build();
//  }
//
//  private Message buildMessage(MessageDto messageDto) {
//
//    Message msg = new Message();
//    msg.setMessageId(UUID.randomUUID().toString());
////    msg.setBody("{\"payload\": \"asdasd2212\"}");
//    msg.setBody(JSONSerializer.serializeObject(messageDto));
//
//    MessageAttributeValue messageAttribute = new MessageAttributeValue();
//    messageAttribute.setDataType("String");
//    messageAttribute.setStringValue("false");
//
//    msg.addMessageAttributesEntry("isRetry", messageAttribute);
//
//
//
//    return msg;
//  }
}
