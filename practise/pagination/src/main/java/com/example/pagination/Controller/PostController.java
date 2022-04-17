package com.example.pagination.Controller;

import com.example.pagination.DTO.PostDto;
import com.example.pagination.DTO.PostResponse;
import com.example.pagination.Entity.Post;
import com.example.pagination.Service.PostService;
import com.example.pagination.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
    @RequestMapping("/api/posts")
public class PostController
{
    private PostService postService;

    @Autowired
    private RestTemplate restTemplate;

    public PostController(PostService postService)
    {
        this.postService = postService;
    }

    // create blog post rest api
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto)
    {
         return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    // get all post rest api
    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sorDir
    )
    {
        return postService.getAllPosts(pageNo, pageSize, sortBy, sorDir);
    }

    @GetMapping(value = "/get_post")
    public ResponseEntity<Object> getPost()
    {
        return postService.getAllPost();
    }
}
