package com.example.sqs_producer.controllers;


import com.example.sqs_producer.domain.dtos.MessageDto;
import com.example.sqs_producer.service.MessagePublisherService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class MessageController implements iMessageController {

  private final MessagePublisherService messagePublisherService;

  @Override
  @GetMapping("/message")
  public Flux<?> getMsg() {
    return null;
  }

  @Override
  @PostMapping("/message/{text}")
  public Mono<?> postMsg(@PathVariable(value = "text") String text) {
    return Mono.just(messagePublisherService.sendMessage(new MessageDto(text)));
  }
}
