package com.skillbox.blog.service;

import com.skillbox.blog.dto.request.RequestModerationDto;
import com.skillbox.blog.dto.response.ResponseResults;
import com.skillbox.blog.entity.Post;
import com.skillbox.blog.entity.enums.ModerationStatus;
import com.skillbox.blog.repository.PostRepository;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ModerationService {

  private PostRepository postRepository;
  private UserService userService;

  public ResponseResults moderationPost(RequestModerationDto requestModerationDto) {
    Post post = postRepository.findByIdAndModerationStatusNot(requestModerationDto.getPostId(), ModerationStatus.ACCEPTED)
        .orElseThrow(EntityNotFoundException::new);

    if (requestModerationDto.getDecision().toUpperCase().equals("ACCEPT")) {
      requestModerationDto.setDecision("ACCEPTED");
    }

    if (requestModerationDto.getDecision().toUpperCase().equals("DECLINE")) {
      requestModerationDto.setDecision("DECLINED");
    }

    ModerationStatus moderationStatus = ModerationStatus
        .valueOf(requestModerationDto.getDecision().toUpperCase());

    post.setModeratorId(userService.getCurrentUser());

    post.setModerationStatus(moderationStatus);
    postRepository.save(post);
    return new ResponseResults().setResult(true);
  }
}
