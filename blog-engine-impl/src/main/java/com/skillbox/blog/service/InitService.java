package com.skillbox.blog.service;

import com.skillbox.blog.dto.response.ResponseInitDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class InitService {

  public ResponseInitDto initialization() {
    return ResponseInitDto.builder()
        .title("DevPub")
        .subtitle("Рассказы разработчиков")
        .phone("+7 495 720 25 17")
        .email("deal@symbioway.ru")
        .copyright("Даниил Пилипенко")
        .copyrightFrom("2019")
        .build();
  }
}
