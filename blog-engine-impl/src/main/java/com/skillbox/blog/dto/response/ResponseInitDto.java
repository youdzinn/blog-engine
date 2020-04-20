package com.skillbox.blog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseInitDto {

  String title;
  String subtitle;
  String phone;
  String email;
  String copyright;
  String copyrightFrom;
}
