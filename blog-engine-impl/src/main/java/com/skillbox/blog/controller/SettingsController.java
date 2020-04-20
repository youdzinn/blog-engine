package com.skillbox.blog.controller;

import com.skillbox.blog.dto.GlobalSettingsDto;
import com.skillbox.blog.service.SettingsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class SettingsController {

  SettingsService settingsService;

  @GetMapping("/settings")
  @ResponseStatus(HttpStatus.OK)
  public GlobalSettingsDto getSettings() {
    return settingsService.getSettings();
  }

  @PutMapping("/settings")
  @ResponseStatus(HttpStatus.OK)
  public GlobalSettingsDto saveSettings(@RequestBody GlobalSettingsDto request) {
    return settingsService.saveSettings(request);
  }
}
