package com.skillbox.blog.controller;

import com.skillbox.blog.dto.response.ResponseStatisticsDto;
import com.skillbox.blog.service.StatisticsService;
import java.security.Principal;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
@AllArgsConstructor
public class StatisticsController {

  StatisticsService statisticsService;

  @GetMapping("statistics/my")
  @ResponseStatus(HttpStatus.OK)
  public ResponseStatisticsDto getStatisticsForCurrentUser() {
    return statisticsService.getStatisticsForCurrentUser();
  }

  @GetMapping("statistics/all")
  @ResponseStatus(HttpStatus.OK)
  public ResponseStatisticsDto getStatisticForAll(Principal principal) {
    return statisticsService.getStatisticForAll(principal);
  }
}
