package in.yash.linkedin.posts_service.controller;

import in.yash.linkedin.posts_service.dto.PostCreationRequestDto;
import in.yash.linkedin.posts_service.dto.PostDto;
import in.yash.linkedin.posts_service.service.PostsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostsService postsService;

    @PostMapping
    public ResponseEntity<PostDto>createPost(@RequestBody PostCreationRequestDto postCreationRequestDto, HttpServletRequest httpServletRequest){
            PostDto post=postsService.createPost(postCreationRequestDto,1L);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto>getPost(@PathVariable Long postId){
        PostDto postDto =postsService.getPostById(postId);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/allPosts")
    public ResponseEntity<List<PostDto>>getAllPostsOfUser(@PathVariable Long userId){
        List<PostDto>postDtos=postsService.getAllPostsOfUser(userId);
        return new ResponseEntity<>(postDtos,HttpStatus.OK);
    }

}
