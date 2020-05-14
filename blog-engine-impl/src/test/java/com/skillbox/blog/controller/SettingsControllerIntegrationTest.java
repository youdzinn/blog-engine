package com.skillbox.blog.controller;

import com.skillbox.blog.dto.GlobalSettingsDto;
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
public class SettingsControllerIntegrationTest {

  @Autowired
  TestRestTemplate testRestTemplate;

  @Test
  void getSettings_withModeratorAccount_resultOk() {
    GlobalSettingsDto globalSettingsDto = GlobalSettingsDto.builder()
        .MULTIUSER_MODE(false)
        .POST_PREMODERATION(true)
        .STATISTICS_IS_PUBLIC(true)
        .build();

    HttpEntity<String> entity = new HttpEntity<>("body", Utils.getModeratorCookie());
    ResponseEntity<GlobalSettingsDto> response = testRestTemplate
        .exchange("/api/settings", HttpMethod.GET, entity, GlobalSettingsDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(globalSettingsDto, response.getBody());
  }

  @Test
  void getSettings_withoutModeratorAccount_resultBadRequest() {
    HttpEntity<String> entity = new HttpEntity<>("body", Utils.getUserCookie());
    ResponseEntity<ResponseResults> response = testRestTemplate
        .exchange("/api/settings", HttpMethod.GET, entity, ResponseResults.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(false, response.getBody().isResult());

  }

  @Test
  void saveSettings_withModeratorAccount_resultOk() {
    GlobalSettingsDto globalSettingsDto = GlobalSettingsDto.builder()
        .MULTIUSER_MODE(true)
        .POST_PREMODERATION(true)
        .STATISTICS_IS_PUBLIC(true)
        .build();

    HttpEntity<GlobalSettingsDto> entity = new HttpEntity<>(globalSettingsDto,
        Utils.getModeratorCookie());
    ResponseEntity<GlobalSettingsDto> response = testRestTemplate
        .exchange("/api/settings", HttpMethod.PUT, entity, GlobalSettingsDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(globalSettingsDto, response.getBody());
  }

  @Test
  void saveSettings_withoutModeratorAccount_resultBadRequest() {
    GlobalSettingsDto globalSettingsDto = GlobalSettingsDto.builder()
        .MULTIUSER_MODE(true)
        .POST_PREMODERATION(true)
        .STATISTICS_IS_PUBLIC(true)
        .build();

    HttpEntity<GlobalSettingsDto> entity = new HttpEntity<>(globalSettingsDto,
        Utils.getUserCookie());
    ResponseEntity<ResponseResults> response = testRestTemplate
        .exchange("/api/settings", HttpMethod.PUT, entity,
            ResponseResults.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(false, response.getBody().isResult());
  }
}
