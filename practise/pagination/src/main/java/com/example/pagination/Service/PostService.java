package com.example.pagination.Service;

import com.example.pagination.DTO.PostDto;
import com.example.pagination.DTO.PostResponse;

public interface PostService
{
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
}
