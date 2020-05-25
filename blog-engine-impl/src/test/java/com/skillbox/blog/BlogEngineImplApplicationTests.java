package com.skillbox.blog;

import com.skillbox.blog.config.GlobalSettingsConfig;
import com.skillbox.blog.entity.GlobalSetting;
import com.skillbox.blog.entity.enums.GlobalSettingsValue;
import com.skillbox.blog.repository.GlobalSettingRepository;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogEngineImplApplicationTests {

  @Autowired
  GlobalSettingRepository repository;

  @Autowired
  GlobalSettingsConfig config;

  @Test
  void contextLoads() {
  }

  @Test
  void settingsInitTest() {

    String mu = "MULTIUSER_MODE";
    String pm = "MULTIUSER_MODE";
    String ps = "STATISTICS_IS_PUBLIC";

    Map<String, String> settings = config.getGlobalSettings()
        .stream().collect(Collectors.toMap(GlobalSettingsConfig.GlobalSettingConfig::getCode,
            GlobalSettingsConfig.GlobalSettingConfig::getValue));

    Map<String, GlobalSettingsValue> persistedSettings = repository.findAll()
        .stream().collect(Collectors.toMap(GlobalSetting::getCode, GlobalSetting::getValue));

    Assertions.assertEquals(settings.get(mu), persistedSettings.get(mu));
    Assertions.assertEquals(settings.get(pm), persistedSettings.get(pm));
    Assertions.assertEquals(settings.get(ps), persistedSettings.get(ps));
  }
}
