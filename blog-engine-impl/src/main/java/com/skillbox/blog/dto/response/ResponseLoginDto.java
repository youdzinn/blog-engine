package com.skillbox.blog.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseLoginDto {

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private boolean result;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  ResponseUserDto user;
}




