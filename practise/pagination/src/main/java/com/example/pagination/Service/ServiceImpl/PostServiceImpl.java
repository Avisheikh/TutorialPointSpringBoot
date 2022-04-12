package com.example.pagination.Service.ServiceImpl;

import com.example.pagination.DTO.PostDto;
import com.example.pagination.DTO.PostResponse;
import com.example.pagination.Entity.Post;
import com.example.pagination.Repository.PostRepository;
import com.example.pagination.Service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService
{
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository)
    {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto)
    {
        // convert dto to entity
        Post post = mapToEntity(postDto);
        Post newPost = postRepository.save(post);

        // convert entity to DTO
        PostDto postResponse = mapToDTO(newPost);
        return postResponse;
    }

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir)
    {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Post> posts = postRepository.findAll(pageable);

        // get content for page object
        List<Post> listOfPosts = posts.getContent();

        List<PostDto> content = listOfPosts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(content);
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalElements(posts.getTotalElements());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setLast(posts.isLast());

        return postResponse;
    }

    // convert Entity into DTO
    private PostDto mapToDTO(Post post)
    {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getContent());
        postDto.setContent(post.getContent());
        return postDto;
    }

    // convert Dto to entity
    private Post mapToEntity(PostDto postDto)
    {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }

    @Override
    public ResponseEntity<Object> getAllPost()
    {
        List<Post> post = postRepository.findAll();

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

}
