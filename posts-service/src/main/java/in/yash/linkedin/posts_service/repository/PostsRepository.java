package in.yash.linkedin.posts_service.repository;

import in.yash.linkedin.posts_service.dto.PostDto;
import in.yash.linkedin.posts_service.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Post,Long> {

    List<Post> findAllByUserId(Long userId);
}
