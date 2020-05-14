package com.skillbox.blog.repository;

import com.skillbox.blog.entity.Post;
import com.skillbox.blog.entity.enums.ModerationStatus;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>,
    JpaSpecificationExecutor<Post> {

  @Query(nativeQuery = true, value = "SELECT DATE(time) FROM post WHERE time <= NOW() "
      + "AND is_active = 1 and moderation_status = 'ACCEPTED' AND EXTRACT(YEAR FROM time) = :year")
  ArrayList<String> findCountPublicationsOnDateByYear(int year);

  @Query(nativeQuery = true, value = "SELECT EXTRACT(YEAR FROM time) AS years "
      + "FROM post WHERE time <= now() AND is_active = 1 AND moderation_status = 'ACCEPTED' "
      + "GROUP BY years ORDER BY years DESC")
  List<Integer> findYearsWherePublicationsPresent();

  Optional<Post> findById(int id);

  @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM post "
      + "WHERE is_active = 1 AND moderation_status = 'ACCEPTED' AND time <= NOW()")
  int findCountOfSuitablePosts();

  @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM post")
  int findCountAllPosts();

  @Query(nativeQuery = true, value = "SELECT SUM(view_count) FROM post")
  int findCountAllViews();

  @Query(nativeQuery = true, value = "SELECT MIN(time) FROM post")
  LocalDateTime findFirstPublication();

  @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM post WHERE user_id = :userId")
  int findCountPostsForCurrentUser(int userId);

  @Query(nativeQuery = true, value = "SELECT SUM(view_count) FROM post "
      + "WHERE user_id = :userId")
  int findCountViewsOfPostsForCurrentUser(int userId);

  @Query(nativeQuery = true, value = "SELECT MIN(time) FROM post "
      + "WHERE user_id = :userId")
  LocalDateTime findFirstPublicationForCurrentUser(int userId);

  @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM post WHERE is_active = 1 "
      + "AND moderation_status = 'ACCEPTED'")
  int postCountTotal();

  @Query(nativeQuery = true, value = "SELECT * FROM post WHERE is_active = 1 "
      + "AND moderation_status = 'ACCEPTED' AND time <= NOW()")
  List<Post> findSuitablePosts(Pageable pageable);

  @Query(nativeQuery = true, value = "SELECT * FROM post WHERE is_active = 1 "
      + "AND moderation_status = 'ACCEPTED' AND time \\:\\:DATE = :date \\:\\:DATE")
  List<Post> findByDate(String date, Pageable pageable);

  @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM post WHERE is_active = 1 "
      + "AND moderation_status = 'NEW'")
  int findCountPostsForModeration();

  @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM post WHERE is_active = 1 "
      + "AND moderation_status = :status")
  int findCountPostsForModerationByStatus(String status);

  @Query(nativeQuery = true, value = "SELECT * FROM post WHERE is_active = 1 "
      + "AND moderation_status = :status")
  List<Post> findPostsForModerationByStatus(String status, Pageable pageable);

  Optional<Post> findByIdAndModerationStatusNot(int id, ModerationStatus ms);

  @Query(nativeQuery = true, value = "SELECT p.* FROM be.post p "
      + "JOIN be.post2tag ON post_id = p.id JOIN be.tag ON tag_id = tag.id "
      + "WHERE tag.name = :tag AND p.is_active = 1 AND p.moderation_status = 'ACCEPTED'")
  List<Post> findAllByTag(String tag, Pageable pageable);

  @Query(nativeQuery = true, value = "SELECT * FROM post WHERE user_id = :userId"
      + " AND is_active = :isActive AND moderation_status LIKE :moderationStatus")
  List<Post> findMyPosts(int userId, int isActive, String moderationStatus, Pageable pageable);

  @Query(nativeQuery = true, value = "SELECT * FROM post WHERE is_active = 1 "
      + "AND time <= NOW() AND moderation_status = 'ACCEPTED' "
      + "AND text LIKE %:query% OR title LIKE %:query%")
  List<Post> findAllPostsByQuery(String query, Pageable pageable);

  @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM post WHERE is_active = 1 "
      + "AND moderation_status = 'ACCEPTED' AND text LIKE %:query%")
  int findCountAllPostsByQuery(String query);

  @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM post WHERE is_active = 1 "
      + "AND moderation_status = 'ACCEPTED' AND time \\:\\:DATE = :date \\:\\:DATE")
  int findCountOfPostsByDate(String date);

  @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM post p "
      + "JOIN post2tag ON post_id = p.id JOIN tag ON tag_id = tag.id "
      + "WHERE tag.name = :tag AND p.is_active = 1 AND p.moderation_status = 'ACCEPTED'")
  int findCountOfPostsByTag(String tag);

  @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM post WHERE user_id = :userId"
      + " AND is_active = :isActive AND moderation_status LIKE :moderationStatus")
  int findCountOfMyPosts(int userId, int isActive, String moderationStatus);

  @Query(nativeQuery = true, value = "SELECT p.id, p.is_active, p.moderation_status, p.text, "
      + "p.time, p.title, p.view_count, p.moderator_id, p.user_id FROM post_comment pc "
      + "LEFT JOIN post p ON pc.post_id = p.id GROUP BY p.id ORDER BY count(p.id) DESC")
  List<Post> findPostsByPopular(Pageable pageable);

  @Query(nativeQuery = true, value = "SELECT p.id, p.is_active, p.moderation_status, p.text, "
      + "p.time, p.title, p.view_count, p.moderator_id, p.user_id FROM post_vote pv "
      + "LEFT JOIN post p ON pv.post_id = p.id GROUP BY p.id ORDER BY count(p.id) DESC")
  List<Post> findPostsByBest(Pageable pageable);
}
