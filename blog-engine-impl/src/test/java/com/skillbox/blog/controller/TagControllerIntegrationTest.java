package com.skillbox.blog.controller;

import com.skillbox.blog.dto.response.ResponseTagsDto;
import com.skillbox.blog.utils.IntegrationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@IntegrationTest
public class TagControllerIntegrationTest {

  @Autowired
  TestRestTemplate testRestTemplate;

  @Test
  void getTags_resultOk() {
    HttpEntity<String> entity = new HttpEntity<>("body", null);
    ResponseEntity<ResponseTagsDto> response = testRestTemplate
        .exchange("/api/tag?query=", HttpMethod.GET, entity, ResponseTagsDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(6, response.getBody().getTags().size());
  }
}
