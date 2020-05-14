package com.skillbox.blog.service;

import com.skillbox.blog.config.StorageConfig;
import com.skillbox.blog.exception.StorageException;
import com.skillbox.blog.utils.RandomStringGenerator;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.IllegalClassFormatException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.imageio.ImageIO;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@AllArgsConstructor
public class ImageService {

  private final StorageConfig storageConfig;

  public String uploadImage(MultipartFile uploadFile, String location)
      throws IllegalClassFormatException {
    StringBuilder pathBuilder = new StringBuilder();
    try {
      String fileExt = FilenameUtils.getExtension(uploadFile.getOriginalFilename());

      if (!fileExt.equals("jpg") &&
          !fileExt.equals("jpeg") &&
          !fileExt.equals("png")) {
        throw new IllegalClassFormatException("Illegal file format");
      }

      pathBuilder
          .append(RandomStringGenerator.randomString(10))
          .append(".")
          .append(fileExt);

      Path file = Paths.get(location).resolve(pathBuilder.toString());

      try (InputStream inputStream = uploadFile.getInputStream()) {
        if (location.equals(storageConfig.getLocation().get("AVATARS"))) {
          ImageIO.write(resizeImg(inputStream), fileExt, file.toFile());
        } else {
          Files.copy(inputStream, file,
              StandardCopyOption.REPLACE_EXISTING);
        }
      }
      return "/" + file;
    } catch (IOException e) {
      throw new StorageException("Failed to store file " + pathBuilder, e);
    }
  }

  public void init() {
    storageConfig.getLocation().values().forEach(l -> {
      try {
        Files.createDirectories(Paths.get(l));
      } catch (IOException e) {
        throw new StorageException("Could not initialize storage", e);
      }
    });
  }

  private BufferedImage resizeImg(InputStream inputStream) throws IOException {
    return Scalr.resize(ImageIO.read(inputStream), Method.AUTOMATIC, Mode.AUTOMATIC, 100,
        Scalr.OP_ANTIALIAS);
  }
}