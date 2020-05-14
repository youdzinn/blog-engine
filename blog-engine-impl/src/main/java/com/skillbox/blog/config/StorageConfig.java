package com.skillbox.blog.config;

import com.skillbox.blog.service.ImageService;
import java.util.Map;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StorageConfig implements WebMvcConfigurer, CommandLineRunner {

  @Getter
  private Map<String, String> location = Map.of("UPLOAD", "upload", "AVATARS", "avatars");

  @Autowired
  ImageService imageService;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler(location.values().stream().map(l -> l += "/*").toArray(String[]::new))
        .addResourceLocations(location.values().stream().map(l -> String.format("file:%s/", l))
            .toArray(String[]::new));
  }

  @Override
  public void run(String... args) throws Exception {
    imageService.init();
  }
}
