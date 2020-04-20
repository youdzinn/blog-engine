package com.skillbox.blog.controller;

import com.skillbox.blog.dto.response.ResponseStatisticsDto;
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
public class StatisticsControllerIntegrationTest {

  @Autowired
  TestRestTemplate testRestTemplate;

  @Test
  void getStatisticForCurrentUser_resultOk() {
    ResponseStatisticsDto responseStatisticsDto = ResponseStatisticsDto.builder()
        .postsCount(5)
        .likesCount(5)
        .dislikesCount(4)
        .viewsCount(41)
        .firstPublication("17.09.2018 16:30")
        .build();

    HttpEntity<String> entity = new HttpEntity<>("body", Utils.getUserCookie());
    ResponseEntity<ResponseStatisticsDto> response = testRestTemplate
        .exchange("/api/statistics/my", HttpMethod.GET, entity, ResponseStatisticsDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(responseStatisticsDto, response.getBody());
  }

  @Test
  void getStatisticForAll_resultOk() {
    ResponseStatisticsDto responseStatisticsDto = ResponseStatisticsDto.builder()
        .postsCount(37)
        .likesCount(25)
        .dislikesCount(25)
        .viewsCount(180)
        .firstPublication("03.01.2018 15:30")
        .build();

    HttpEntity<String> entity = new HttpEntity<>("body", null);
    ResponseEntity<ResponseStatisticsDto> response = testRestTemplate
        .exchange("/api/statistics/all", HttpMethod.GET, entity, ResponseStatisticsDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(responseStatisticsDto, response.getBody());
  }
}
