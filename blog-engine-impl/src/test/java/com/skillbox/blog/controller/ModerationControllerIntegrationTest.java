package com.skillbox.blog.controller;

import com.skillbox.blog.dto.request.RequestModerationDto;
import com.skillbox.blog.dto.response.ResponseResults;
import com.skillbox.blog.utils.IntegrationTest;
import com.skillbox.blog.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@IntegrationTest
public class ModerationControllerIntegrationTest {

  @Autowired
  TestRestTemplate testRestTemplate;

  @Test
  void moderationPost_resultOk() {
    RequestModerationDto request = RequestModerationDto.builder()
        .postId(17)
        .decision("ACCEPT")
        .build();

    HttpEntity<RequestModerationDto> entity = new HttpEntity<>(request, Utils.getModeratorCookie());
    ResponseEntity<ResponseResults> response = testRestTemplate
        .exchange("/api/moderation", HttpMethod.POST, entity, ResponseResults.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(true, response.getBody().isResult());
  }

  @Test
  void moderationPost_withoutGrants_resultForbidden() {
    RequestModerationDto request = RequestModerationDto.builder()
        .postId(18)
        .decision("ACCEPT")
        .build();

    HttpEntity<RequestModerationDto> entity = new HttpEntity<>(request, Utils.getUserCookie());
    ResponseEntity<ResponseResults> response = testRestTemplate
        .exchange("/api/moderation", HttpMethod.POST, entity, ResponseResults.class);

    Assertions.assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
    Assertions.assertEquals(true, response.getBody().isResult());
  }
}
