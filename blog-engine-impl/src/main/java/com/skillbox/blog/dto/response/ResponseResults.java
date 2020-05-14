package com.skillbox.blog.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ResponseResults {

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Integer id;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private boolean result;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Map<String, String> errors;

}
