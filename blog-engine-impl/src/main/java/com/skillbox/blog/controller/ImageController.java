package com.skillbox.blog.controller;

import com.skillbox.blog.config.StorageConfig;
import com.skillbox.blog.service.ImageService;
import java.lang.instrument.IllegalClassFormatException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class ImageController {

  ImageService imageService;
  StorageConfig storageConfig;

  @PostMapping(value = "/image", consumes = "multipart/form-data")
  @ResponseStatus(HttpStatus.OK)
  public String uploadImage(
      @RequestParam(value = "image") MultipartFile uploadFile)
      throws IllegalClassFormatException {
    return imageService.uploadImage(uploadFile, storageConfig.getLocation().get("UPLOAD"));
  }
}
