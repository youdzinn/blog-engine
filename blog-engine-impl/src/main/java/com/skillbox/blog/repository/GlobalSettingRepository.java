package com.skillbox.blog.repository;

import com.skillbox.blog.entity.GlobalSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GlobalSettingRepository extends JpaRepository<GlobalSetting, Integer> {

  @Query(nativeQuery = true, value = "SELECT value FROM global_setting WHERE "
      + "code = 'POST_PREMODERATION'")
  String findPostPremoderationValue();

  @Query(nativeQuery = true, value = "SELECT value FROM global_setting WHERE "
      + "code = 'MULTIUSER_MODE'")
  String findMultiuserModeValue();
}
