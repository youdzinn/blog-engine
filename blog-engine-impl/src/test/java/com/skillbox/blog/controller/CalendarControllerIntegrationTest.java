package com.skillbox.blog.controller;

import com.skillbox.blog.dto.response.ResponseCalendarDto;
import com.skillbox.blog.utils.IntegrationTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@IntegrationTest
public class CalendarControllerIntegrationTest {

  @Autowired
  TestRestTemplate testRestTemplate;

  List<Integer> years;
  Map<String, Integer> posts;

  @BeforeEach
  public void init() {
    years = new ArrayList<>();
    years.add(2020);
    years.add(2019);
    years.add(2018);

    posts = new HashMap<>();
    posts.put("2018-01-03", 1);
    posts.put("2018-04-07", 1);
    posts.put("2018-09-17", 1);
    posts.put("2018-10-30", 1);
    posts.put("2018-12-18", 1);
  }

  @Test
  void getPublicationsCount_withEmptyParam_resultOk() {
    HttpEntity<String> entity = new HttpEntity<>("body", null);
    ResponseEntity<ResponseCalendarDto> response = testRestTemplate
        .exchange("/api/calendar?year=", HttpMethod.GET, entity, ResponseCalendarDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(years, response.getBody().getYears());
  }

  @Test
  void getPublicationsCount_resultOk() {
    HttpEntity<String> entity = new HttpEntity<>("body", null);
    ResponseEntity<ResponseCalendarDto> response = testRestTemplate
        .exchange("/api/calendar?year=2018", HttpMethod.GET, entity, ResponseCalendarDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(years, response.getBody().getYears());
    Assertions.assertEquals(posts, response.getBody().getPosts());
  }
}
