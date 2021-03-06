package com.skillbox.blog.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePostDto {

  int id;
  String time;
  PartInfoOfUser user;
  String title;
  String text;
  int likeCount;
  int dislikeCount;
  int commentCount;
  int viewCount;
  List<PartComment> comments;
  String[] tags;
}
