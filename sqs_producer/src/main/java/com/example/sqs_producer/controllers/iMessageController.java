package com.example.sqs_producer.controllers;

import com.example.sqs_producer.domain.dtos.MessageDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface iMessageController {

  @Operation(summary = "Get page of messages")
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Returns page of messages",
          content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = MessageDto.class)
              )
          }),
      @ApiResponse(
          responseCode = "400",
          description = "Bad request",
          content = @Content),
      @ApiResponse(
          responseCode = "404",
          description = "Messages were not found",
          content = @Content)
  })
  Flux<?> getMsg();

  @Operation(summary = "Adds new product")
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Returns acknowledge [product created]",
          content = @Content),
      @ApiResponse(
          responseCode = "400",
          description = "Bad request",
          content = @Content)
  })
  Mono<?> postMsg(@Parameter(description = "New product") final Mono<MessageDto> dto);
}
