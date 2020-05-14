package com.skillbox.blog.service;

import com.skillbox.blog.dto.response.ResponseStatisticsDto;
import com.skillbox.blog.entity.GlobalSetting;
import com.skillbox.blog.repository.GlobalSettingRepository;
import com.skillbox.blog.repository.PostRepository;
import com.skillbox.blog.repository.PostVoteRepository;
import java.nio.file.AccessDeniedException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class StatisticsService {

  private PostRepository postRepository;
  private PostVoteRepository postVoteRepository;
  private UserService userService;
  private GlobalSettingRepository repository;
  private PostService postService;

  public ResponseStatisticsDto getStatisticsForCurrentUser() {
    int userId = userService.getCurrentUser().getId();

    return ResponseStatisticsDto.builder()
        .postsCount(postRepository.findCountPostsForCurrentUser(userId))
        .likesCount(postVoteRepository.findCountOfLikesForCurrentUser(userId))
        .dislikesCount(postVoteRepository.findCountOfDislikesForCurrentUser(userId))
        .viewsCount(postRepository.findCountViewsOfPostsForCurrentUser(userId))
        .firstPublication(postService.dateMapping(postRepository.findFirstPublicationForCurrentUser(userId)))
        .build();
  }

  public ResponseStatisticsDto getStatisticForAll() {
    List<GlobalSetting> settings = repository.findAll();
    if (
        settings.stream()
            .anyMatch(s -> s.getCode().equals("STATISTICS_IS_PUBLIC") && s.getValue().equals("YES"))
    ) {
      return ResponseStatisticsDto.builder()
          .postsCount(postRepository.findCountAllPosts())
          .likesCount(postVoteRepository.findCountOfAllLikes())
          .dislikesCount(postVoteRepository.findCountOfAllDislikes())
          .viewsCount(postRepository.findCountAllViews())
          .firstPublication(postService.dateMapping(postRepository.findFirstPublication()))
          .build();
    } else {
      try {
        throw new AccessDeniedException("Statistics hidden by moderator!");
      } catch (AccessDeniedException e) {
        e.printStackTrace();
      }
    }
    return null;
  }
}
