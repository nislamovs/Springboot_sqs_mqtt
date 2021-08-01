package com.example.sqs_producer.service;

import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.example.sqs_producer.domain.dtos.MessageDto;
import com.example.sqs_producer.domain.dtos.ResponseDto;
import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nonapi.io.github.classgraph.json.JSONSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessagePublisherService {

  @Value("${cloud.aws.end-point.uri}")
  private String endpoint;

  private final QueueMessagingTemplate queueMessagingTemplate;

  public ResponseDto sendMessage(MessageDto messageDto) {
    log.info("Sending Message to SQS: {},", messageDto);
    queueMessagingTemplate.convertAndSend(endpoint, buildMessage(messageDto));

    return ResponseDto.builder().responseMsg("Message sent!").build();
  }

  private Message buildMessage(MessageDto messageDto) {

    Message msg = new Message();
    msg.setMessageId(UUID.randomUUID().toString());
//    msg.setBody("{\"payload\": \"asdasd2212\"}");
    msg.setBody(JSONSerializer.serializeObject(messageDto));

    MessageAttributeValue messageAttribute = new MessageAttributeValue();
    messageAttribute.setDataType("String");
    messageAttribute.setStringValue("false");

    msg.addMessageAttributesEntry("isRetry", messageAttribute);



    return msg;
  }
}
