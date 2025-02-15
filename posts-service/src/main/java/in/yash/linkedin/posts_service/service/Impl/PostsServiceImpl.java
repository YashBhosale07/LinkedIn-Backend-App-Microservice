package in.yash.linkedin.posts_service.service.Impl;
import in.yash.linkedin.posts_service.Exception.ResourceNotFoundException;
import in.yash.linkedin.posts_service.dto.PostCreationRequestDto;
import in.yash.linkedin.posts_service.dto.PostDto;
import in.yash.linkedin.posts_service.entity.Post;
import in.yash.linkedin.posts_service.repository.PostsRepository;
import in.yash.linkedin.posts_service.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostsServiceImpl implements PostsService {

    private final PostsRepository postsRepository;
    private final ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostCreationRequestDto postCreationRequestDto,Long userId) {
        Post post=modelMapper.map(postCreationRequestDto,Post.class);
        post.setUserId(userId);
        Post savedPost=postsRepository.save(post);
        return modelMapper.map(savedPost,PostDto.class);
    }

    @Override
    public PostDto getPostById(Long postId) {
        Post post=postsRepository.findById(postId).orElseThrow(
                ()->new ResourceNotFoundException("Post is not present with id "+postId));
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public List<PostDto> getAllPostsOfUser(Long userId) {
        List<Post>posts=postsRepository.findAllByUserId(userId);
        return posts.stream().map((element)->modelMapper.map(element,PostDto.class))
                .toList();
    }
}
