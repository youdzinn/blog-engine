package com.skillbox.blog.service;

import com.skillbox.blog.dto.request.RequestCommentDto;
import com.skillbox.blog.dto.response.ResponseResults;
import com.skillbox.blog.entity.Post;
import com.skillbox.blog.entity.PostComment;
import com.skillbox.blog.mapper.RequestPostToPost;
import com.skillbox.blog.repository.PostCommentRepository;
import com.skillbox.blog.repository.PostRepository;
import java.time.LocalDateTime;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CommentService {

  private PostRepository postRepository;
  private PostService postService;
  private UserService userService;
  private PostCommentRepository postCommentRepository;
  RequestPostToPost requestMapper;

  public ResponseResults createComment(RequestCommentDto comment) {
    PostComment commentToSave = new PostComment();
    Post post = postRepository.findById(comment.getPostId())
        .orElseThrow(EntityNotFoundException::new);
    commentToSave.setPostId(post);
    commentToSave.setTime(LocalDateTime.now());
    commentToSave.setText(comment.getText());
    commentToSave.setUserId(userService.getCurrentUser());

    int parentId;
    if (comment.getParentId() == null) {
      parentId = 0;
    } else {
      parentId = Integer.parseInt(comment.getParentId());
    }

    if (parentId != 0) {
      PostComment parent = postCommentRepository.findById(parentId)
          .orElseThrow(EntityNotFoundException::new);
      commentToSave.setParentId(parent);
    }
    return new ResponseResults().setId(postCommentRepository.save(commentToSave).getId());
  }
}
