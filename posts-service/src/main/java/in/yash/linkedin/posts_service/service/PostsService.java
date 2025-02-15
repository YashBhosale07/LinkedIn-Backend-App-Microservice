package in.yash.linkedin.posts_service.service;

import in.yash.linkedin.posts_service.dto.PostCreationRequestDto;
import in.yash.linkedin.posts_service.dto.PostDto;

import java.util.List;

public interface PostsService {
    PostDto createPost(PostCreationRequestDto postCreationRequestDto,Long userId);

    PostDto getPostById(Long postId);

    List<PostDto> getAllPostsOfUser(Long userId);
}
