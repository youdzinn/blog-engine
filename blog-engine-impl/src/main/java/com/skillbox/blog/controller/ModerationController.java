package com.skillbox.blog.controller;

import com.skillbox.blog.dto.request.RequestModerationDto;
import com.skillbox.blog.dto.response.ResponseResults;
import com.skillbox.blog.entity.enums.Role;
import com.skillbox.blog.service.ModerationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class ModerationController {

  ModerationService moderationService;

  @PostMapping("/moderation")
  @ResponseStatus(HttpStatus.OK)
  @Secured(Role.Code.MODERATOR)
  public ResponseResults moderationPost(
      @RequestBody RequestModerationDto requestModerationDto) {
    return moderationService.moderationPost(requestModerationDto);
  }
}
