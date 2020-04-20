package com.skillbox.blog.dto.request;

import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
public class RequestPost {

  private String time;
  private byte active;
  @Size(max = 256, message = "Заголовок не установлен")
  private String title;
  @Size(min = 50, message = "Текст публикации слишком короткий")
  private String text;
  private String[] tags;
}
