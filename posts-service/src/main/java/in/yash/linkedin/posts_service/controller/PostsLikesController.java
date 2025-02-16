package in.yash.linkedin.posts_service.controller;

import in.yash.linkedin.posts_service.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class PostsLikesController {

    private final PostLikeService postLikeService;

    @PostMapping("/{postId}")
    public ResponseEntity<Void>likePost(@PathVariable Long postId){
        postLikeService.likePost(postId,1L);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void>unlikePost(@PathVariable Long postId){
        postLikeService.unlikePost(postId,1l);
        return ResponseEntity.noContent().build();
    }
}
