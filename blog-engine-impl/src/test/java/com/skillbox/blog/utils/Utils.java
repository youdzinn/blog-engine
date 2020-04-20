package com.skillbox.blog.utils;

import com.skillbox.blog.dto.request.RequestLoginDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Utils {

  private static final RestTemplate REQUEST = new RestTemplate();
  private static HttpHeaders headers;

  public static HttpHeaders getModeratorCookie() {

    RequestLoginDto login = new RequestLoginDto()
        .setEmail("admin@skillbox.ru")
        .setPassword("skillbox");

    HttpEntity<RequestLoginDto> entity = new HttpEntity<>(login);
    ResponseEntity<Void> response = REQUEST
        .exchange("http://localhost:8080/api/auth/login", HttpMethod.POST, entity, Void.class);

    headers = new HttpHeaders();
    headers.add("Cookie", response.getHeaders().get("Set-Cookie").get(0));

    return headers;
  }

  public static HttpHeaders getUserCookie() {

    RequestLoginDto login = new RequestLoginDto()
        .setEmail("wayne@gmail.com")
        .setPassword("qwertyui");

    HttpEntity<RequestLoginDto> entity = new HttpEntity<>(login);
    ResponseEntity<Void> response = REQUEST
        .exchange("http://localhost:8080/api/auth/login", HttpMethod.POST, entity, Void.class);

    headers = new HttpHeaders();
    headers.add("Cookie", response.getHeaders().get("Set-Cookie").get(0));

    return headers;
  }
}
