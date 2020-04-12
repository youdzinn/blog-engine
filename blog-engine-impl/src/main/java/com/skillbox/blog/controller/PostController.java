package com.skillbox.blog.controller;

import com.skillbox.blog.dto.request.RequestLikeDislikeDto;
import com.skillbox.blog.dto.request.RequestPost;
import com.skillbox.blog.dto.response.ResponseAllPostsDto;
import com.skillbox.blog.dto.response.ResponseOnePostDto;
import com.skillbox.blog.dto.response.ResponseResults;
import com.skillbox.blog.service.PostService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PostController {

  PostService postService;

  @GetMapping("/post")
  @ResponseStatus(HttpStatus.OK)
  public ResponseAllPostsDto getPosts(@RequestParam String mode) {
    return postService.getPosts(mode);
  }

  @GetMapping("/post/search")
  @ResponseStatus(HttpStatus.OK)
  public ResponseAllPostsDto searchPosts(
      @RequestParam(value = "query", defaultValue = "") String query) {
    return postService.searchPosts(query);
  }

  @GetMapping("/post/{postId}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseOnePostDto getPost(@PathVariable int postId) {
    return postService.getPost(postId);
  }

  @GetMapping("/post/byDate")
  @ResponseStatus(HttpStatus.OK)
  public ResponseAllPostsDto getPostsByDate(@RequestParam String date) {
    return postService.getPostsByDate(date);
  }

  @GetMapping("/post/byTag")
  @ResponseStatus(HttpStatus.OK)
  public ResponseAllPostsDto getPostsByTag(@RequestParam(value = "tag") String tag) {
    return postService.getPostsByTag(tag);
  }

  @GetMapping("/post/moderation")
  @ResponseStatus(HttpStatus.OK)
  public ResponseAllPostsDto getModerationList(@RequestParam String status) {
    return postService.getModerationList(status);
  }

  @GetMapping("/post/my")
  @ResponseStatus(HttpStatus.OK)
  public ResponseAllPostsDto getMyPosts(@RequestParam(value = "status") String status) {
    return postService.getMyPosts(status);
  }

  @PostMapping("/post")
  @ResponseStatus(HttpStatus.OK)
  public ResponseResults<Boolean> createPost(@Valid @RequestBody RequestPost requestPost) {
    return postService.createPost(requestPost);
  }

  @PostMapping("/post/like")
  @ResponseStatus(HttpStatus.OK)
  public ResponseResults<Boolean> like(@RequestBody RequestLikeDislikeDto requestLikeDislikeDto) {
    return postService.like(requestLikeDislikeDto);
  }

  @PostMapping("/post/dislike")
  @ResponseStatus(HttpStatus.OK)
  public ResponseResults<Boolean> dislike(
      @RequestBody RequestLikeDislikeDto requestLikeDislikeDto) {
    return postService.dislike(requestLikeDislikeDto);
  }
}