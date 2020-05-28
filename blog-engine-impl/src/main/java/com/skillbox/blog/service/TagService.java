package com.skillbox.blog.service;

import com.skillbox.blog.dto.response.ResponseTagsDto;
import com.skillbox.blog.dto.response.TagDto;
import com.skillbox.blog.entity.Tag;
import com.skillbox.blog.repository.PostRepository;
import com.skillbox.blog.repository.TagRepository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class TagService {

  private TagRepository tagRepository;
  private PostRepository postRepository;

  public ResponseTagsDto getTags(String query) {
    List<Tag> resultList;
    float maxWeight;

    if (query.isEmpty()) {
      resultList = tagRepository.findAll();
    } else {
      resultList = tagRepository.findAllByNameContaining(query);
    }

    List<TagDto> responseTags = resultList.stream()
        .map(tag -> {
          String name = tag.getName();
          float weight =
              (float) tagRepository.findTagLinks(tag.getId()) / postRepository.postCountTotal();
          return new TagDto(name, weight);
        })
        .collect(Collectors.toList());
    if (responseTags.size() > 0) {
      maxWeight = (float) responseTags.stream()
          .mapToDouble(TagDto::getWeight)
          .max().orElseThrow(NoSuchElementException::new);
      responseTags
          .forEach(t -> t.setWeight(t.getWeight()/maxWeight));
    }
    return new ResponseTagsDto(responseTags);
  }
}
