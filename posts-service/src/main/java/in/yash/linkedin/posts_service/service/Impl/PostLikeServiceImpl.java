package in.yash.linkedin.posts_service.service.Impl;

import in.yash.linkedin.posts_service.Exception.BadRequestException;
import in.yash.linkedin.posts_service.Exception.ResourceNotFoundException;
import in.yash.linkedin.posts_service.entity.PostLike;
import in.yash.linkedin.posts_service.repository.PostLikeRepository;
import in.yash.linkedin.posts_service.repository.PostsRepository;
import in.yash.linkedin.posts_service.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostLikeServiceImpl implements PostLikeService {
    private final PostsRepository postsRepository;
    private final PostLikeRepository postsLikeRepository;

    @Override
    public void likePost(Long postId, Long userId) {

        log.info("Trying to like the post");

        boolean exists=postsRepository.existsById(postId);
        if(!exists){
            log.info("Post does not exits");
            throw new ResourceNotFoundException("Post does not exits we cannot like the Post");

        }

        boolean ifAlreadyLike=postsLikeRepository.existsByUserIdAndPostId(userId,postId);
        if(ifAlreadyLike){
            log.info("Post has been already liked");
            throw new BadRequestException("Post has been already liked");
        }
        PostLike postLike=PostLike.builder()
                .postId(postId)
                .userId(userId)
                .build();
        postsLikeRepository.save(postLike);
        log.info("Post has been successfully liked");


    }

    @Override
    public void unlikePost(Long postId, long userId) {
        boolean isPresentPost=postsRepository.existsById(postId);
        if(!isPresentPost){
            throw new ResourceNotFoundException("Post is not Present");
        }
        boolean savedLikedPost=postsLikeRepository.existsByUserIdAndPostId(postId,userId);
        if(!savedLikedPost){
            throw new BadRequestException("Cannot unlike the post which is not liked.");
        }
        postsLikeRepository.deleteByUserIdAndPostId(userId,postId);
        log.info("Unlike the post succesfully");
    }
}
