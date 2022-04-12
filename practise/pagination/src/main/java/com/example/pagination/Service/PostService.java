package com.example.pagination.Service;

import com.example.pagination.DTO.PostDto;
import com.example.pagination.DTO.PostResponse;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

public interface PostService
{
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    ResponseEntity<Object> getAllPost();
}
