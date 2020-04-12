package com.skillbox.blog.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestLikeDislikeDto {

  @JsonProperty(value = "post_id")
  int postId;
}