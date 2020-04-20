package com.skillbox.blog.controller;

import com.skillbox.blog.dto.response.ResponseInitDto;
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
public class InitControllerIntegrationTest {

  @Autowired
  TestRestTemplate testRestTemplate;

  @Test
  void getInfoOfBlog_resultOk() {
    ResponseInitDto responseInitDto = ResponseInitDto.builder()
        .title("DevPub")
        .subtitle("Рассказы разработчиков")
        .phone("+7 495 720 25 17")
        .email("deal@symbioway.ru")
        .copyright("Даниил Пилипенко")
        .copyrightFrom("2019")
        .build();

    HttpEntity<String> entity = new HttpEntity<>("body", null);
    ResponseEntity<ResponseInitDto> response = testRestTemplate
        .exchange("/api/init", HttpMethod.GET, entity, ResponseInitDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(responseInitDto, response.getBody());
  }
}
