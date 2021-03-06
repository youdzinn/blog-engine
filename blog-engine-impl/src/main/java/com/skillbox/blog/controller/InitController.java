package com.skillbox.blog.controller;

import com.skillbox.blog.dto.response.ResponseInitDto;
import com.skillbox.blog.service.InitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class InitController {

  InitService initService;

  @GetMapping("/init")
  @ResponseStatus(HttpStatus.OK)
  public ResponseInitDto initialization() {
    return initService.initialization();
  }
}
