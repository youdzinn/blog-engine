package com.skillbox.blog.controller;

import com.skillbox.blog.dto.request.RequestLikeDislikeDto;
import com.skillbox.blog.dto.request.RequestPost;
import com.skillbox.blog.dto.response.ResponseAllPostsDto;
import com.skillbox.blog.dto.response.ResponsePostDto;
import com.skillbox.blog.dto.response.ResponseResults;
import com.skillbox.blog.utils.IntegrationTest;
import com.skillbox.blog.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@IntegrationTest
@TestMethodOrder(OrderAnnotation.class)
public class PostControllerIntegrationTest {

  @Autowired
  TestRestTemplate testRestTemplate;

  @Test
  @Order(1)
  void getPosts_withRecentMode_resultOk() {
    HttpEntity<String> entity = new HttpEntity<>("body", null);
    ResponseEntity<ResponseAllPostsDto> response = testRestTemplate
        .exchange("/api/post?offset=0&limit=3&mode=recent",
            HttpMethod.GET, entity, ResponseAllPostsDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(30, response.getBody().getCount());
    Assertions.assertEquals("18.03.2020 16:30", response.getBody().getPosts().get(0).getTime());
    Assertions.assertEquals(15, response.getBody().getPosts().get(1).getId());
    Assertions.assertEquals(11, response.getBody().getPosts().get(2).getViewCount());
  }

  @Test
  @Order(2)
  void getPosts_withPopularMode_resultOk() {
    HttpEntity<String> entity = new HttpEntity<>("body", null);
    ResponseEntity<ResponseAllPostsDto> response = testRestTemplate
        .exchange("/api/post?offset=0&limit=5&mode=popular",
            HttpMethod.GET, entity, ResponseAllPostsDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(2, response.getBody().getPosts().get(0).getCommentCount());
    Assertions.assertEquals(5, response.getBody().getPosts().size());
  }

  @Test
  @Order(4)
  void getPosts_withBestMode_resultOk() {
    HttpEntity<String> entity = new HttpEntity<>("body", null);
    ResponseEntity<ResponseAllPostsDto> response = testRestTemplate
        .exchange("/api/post?offset=0&limit=7&mode=best",
            HttpMethod.GET, entity, ResponseAllPostsDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(1, response.getBody().getPosts().get(0).getLikeCount());
  }

  @Test
  @Order(5)
  void getPosts_withEarlyMode_resultOk() {
    HttpEntity<String> entity = new HttpEntity<>("body", null);
    ResponseEntity<ResponseAllPostsDto> response = testRestTemplate
        .exchange("/api/post?offset=0&limit=10&mode=early",
            HttpMethod.GET, entity, ResponseAllPostsDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(30, response.getBody().getCount());
    Assertions.assertEquals("03.01.2018 15:30", response.getBody().getPosts().get(0).getTime());
    Assertions.assertEquals(10, response.getBody().getPosts().size());
  }

  @Test
  @Order(6)
  void searchPosts_withEmptyQuery_resultOk() {
    HttpEntity<String> entity = new HttpEntity<>("body", null);
    ResponseEntity<ResponseAllPostsDto> response = testRestTemplate
        .exchange("/api/post/search?offset=0&limit=10&query=",
            HttpMethod.GET, entity, ResponseAllPostsDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(1, response.getBody().getPosts().get(0).getLikeCount());
  }

  @Test
  @Order(7)
  void searchPosts_withQuery_resultOk() {
    HttpEntity<String> entity = new HttpEntity<>("body", null);
    ResponseEntity<ResponseAllPostsDto> response = testRestTemplate
        .exchange("/api/post/search?offset=0&limit=10&query=нужно усилие",
            HttpMethod.GET, entity, ResponseAllPostsDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(33, response.getBody().getPosts().get(0).getId());
    Assertions.assertEquals(1, response.getBody().getCount());
  }

  @Test
  @Order(8)
  void getPost_resultOk() {
    String[] tags = new String[]{"SQL"};

    HttpEntity<String> entity = new HttpEntity<>("body", null);
    ResponseEntity<ResponsePostDto> response = testRestTemplate
        .exchange("/api/post/4", HttpMethod.GET, entity, ResponsePostDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals("Рассказ №5", response.getBody().getTitle());
    Assertions.assertEquals(1, response.getBody().getTags().length);
    Assertions.assertEquals(tags[0], response.getBody().getTags()[0]);
    Assertions.assertEquals(7, response.getBody().getViewCount());
  }

  @Test
  @Order(9)
  void getPostByDate_resultOk() {
    HttpEntity<String> entity = new HttpEntity<>("body", null);
    ResponseEntity<ResponseAllPostsDto> response = testRestTemplate
        .exchange("/api/post/byDate?offset=0&limit=10&date=2018-12-18",
            HttpMethod.GET, entity, ResponseAllPostsDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(1, response.getBody().getCount());
  }

  @Test
  @Order(10)
  void getPostByTag_resultOk() {
    HttpEntity<String> entity = new HttpEntity<>("body", null);
    ResponseEntity<ResponseAllPostsDto> response = testRestTemplate
        .exchange("/api/post/byTag?offset=0&limit=10&tag=Spring",
            HttpMethod.GET, entity, ResponseAllPostsDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(6, response.getBody().getCount());
  }

  @Test
  @Order(3)
  void like_resultOk() {
    RequestLikeDislikeDto request = RequestLikeDislikeDto.builder()
        .postId(30)
        .build();

    HttpEntity<RequestLikeDislikeDto> entity = new HttpEntity<>(request, Utils.getUserCookie());
    ResponseEntity<ResponseResults> response = testRestTemplate
        .exchange("/api/post/like", HttpMethod.POST, entity, ResponseResults.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(true, response.getBody().isResult());
  }

  @Test
  @Order(11)
  void getModerationList_resultOk() {
    HttpEntity<String> entity = new HttpEntity<>("body", Utils.getModeratorCookie());
    ResponseEntity<ResponseAllPostsDto> response = testRestTemplate
        .exchange("/api/post/moderation?offset=0&limit=10&status=declined",
            HttpMethod.GET, entity, ResponseAllPostsDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(1, response.getBody().getCount());
  }

  @Test
  @Order(15)
  void getMyPosts_withStatusNew_resultOk() {
    HttpEntity<String> entity = new HttpEntity<>("body", Utils.getUserCookie());
    ResponseEntity<ResponseAllPostsDto> response = testRestTemplate
        .exchange("/api/post/my?offset=0&limit=10&status=pending",
            HttpMethod.GET, entity, ResponseAllPostsDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(1, response.getBody().getCount());
  }

  @Test
  @Order(16)
  void getMyPosts_withStatusDeclined_resultOk() {
    HttpEntity<String> entity = new HttpEntity<>("body", Utils.getUserCookie());
    ResponseEntity<ResponseAllPostsDto> response = testRestTemplate
        .exchange("/api/post/my?offset=0&limit=10&status=declined",
            HttpMethod.GET, entity, ResponseAllPostsDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(0, response.getBody().getCount());
  }

  @Test
  @Order(12)
  void getMyPosts_withStatusAccepted_resultOk() {
    HttpEntity<String> entity = new HttpEntity<>("body", Utils.getUserCookie());
    ResponseEntity<ResponseAllPostsDto> response = testRestTemplate
        .exchange("/api/post/my?offset=0&limit=10&status=published",
            HttpMethod.GET, entity, ResponseAllPostsDto.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(4, response.getBody().getCount());
    Assertions.assertEquals(4, response.getBody().getPosts().size());
  }

  @Test
  @Order(13)
  void createPost_withModeratorAccountAndModeMU_resultOk() {
    RequestPost requestPost = RequestPost.builder()
        .time("2020-05-02 12:00:00")
        .active((byte) 1)
        .title("Коробочка")
        .text("Мне было не хорошо. Я сидел за столом в большом зале, набитом людьми. "
            + "Впервые в таком странном зале. До этого я лепил дома. Для мамы и, кажется, папы. "
            + "Но на прошлой неделе что-то произошло. А сегодня меня привезли сюда.")
        .tags(new String[]{"Spring"})
        .build();

    HttpEntity<RequestPost> entity = new HttpEntity<>(requestPost, Utils.getModeratorCookie());
    ResponseEntity<ResponseResults> response = testRestTemplate
        .exchange("/api/post", HttpMethod.POST, entity, ResponseResults.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(true, response.getBody().isResult());
  }

  @Test
  @Order(14)
  void createPost_withUserAccountAndModeMU_resultBadRequest() {
    RequestPost requestPost = RequestPost.builder()
        .time("2020-05-02 12:00:00")
        .active((byte) 1)
        .title("Коробочка")
        .text("Мне было не хорошо. Я сидел за столом в большом зале, набитом людьми. "
            + "Впервые в таком странном зале. До этого я лепил дома. Для мамы и, кажется, папы. "
            + "Но на прошлой неделе что-то произошло. А сегодня меня привезли сюда.")
        .tags(new String[]{"Spring"})
        .build();

    HttpEntity<RequestPost> entity = new HttpEntity<>(requestPost, Utils.getUserCookie());
    ResponseEntity<ResponseResults> response = testRestTemplate
        .exchange("/api/post", HttpMethod.POST, entity, ResponseResults.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(false, response.getBody().isResult());
  }

  @Test
  @Order(18)
  void editPost_resultOk() {
    RequestPost requestPost = RequestPost.builder()
        .time("2020-05-02 12:00:00")
        .active((byte) 1)
        .title("Коробочка №2")
        .text("После спектакля огни погасли. Ее утащили наверх, подхватили руки кукольника. "
            + "И сложив пополам, засунули в коробочку. Это был странный момент: ни каната, "
            + "ни криков, ни огненных глаз смотрящих на нее снизу вверх. Неподвижно, расслабленно, "
            + "лежала она возле ниток, и по привычке продолжала на них висеть. Мертвая вся, кроме "
            + "руки и века. И когда коробка, в которой она лежала, загорается, когда на ее "
            + "глянцевой коже раздувается пузырь, вот-вот готовый лопнуть, ее рука распахивает "
            + "крышку, а ее глаз оглядывается по сторонам.")
        .tags(new String[]{"Spring"})
        .build();

    HttpEntity<RequestPost> entity = new HttpEntity<>(requestPost, Utils.getUserCookie());
    ResponseEntity<ResponseResults> response = testRestTemplate
        .exchange("/api/post/9", HttpMethod.PUT, entity, ResponseResults.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(true, response.getBody().isResult());
  }

  @Test
  @Order(17)
  void dislike_resultOk() {
    RequestLikeDislikeDto request = RequestLikeDislikeDto.builder()
        .postId(30)
        .build();

    HttpEntity<RequestLikeDislikeDto> entity = new HttpEntity<>(request, Utils.getUserCookie());
    ResponseEntity<ResponseResults> response = testRestTemplate
        .exchange("/api/post/dislike", HttpMethod.POST, entity, ResponseResults.class);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(true, response.getBody().isResult());
  }
}
