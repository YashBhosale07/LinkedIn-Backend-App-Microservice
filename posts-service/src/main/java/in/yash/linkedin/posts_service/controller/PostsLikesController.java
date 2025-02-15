package in.yash.linkedin.posts_service.controller;

import in.yash.linkedin.posts_service.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
