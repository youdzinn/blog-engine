package com.skillbox.blog.controller;

import com.skillbox.blog.dto.request.RequestCommentDto;
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
public class CommentControllerIntegrationTest {

  @Autowired
  TestRestTemplate testRestTemplate;

  @Test
  void createComment_resultOk() {
    RequestCommentDto request = RequestCommentDto.builder()
        .parentId("")
        .postId(14)
        .text("Мир, в котором мы жили до 20 века, проверить было просто.")
        .build();

    HttpEntity<RequestCommentDto> entity = new HttpEntity<>(request, Utils.getUserCookie());
    ResponseEntity<ResponseResults> response = testRestTemplate
        .exchange("/api/comment", HttpMethod.POST, entity, ResponseResults.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(27, response.getBody().getId());
  }
}
