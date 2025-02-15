package in.yash.linkedin.posts_service.repository;
import in.yash.linkedin.posts_service.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike,Long> {

    Boolean existsByUserIdAndPostId(Long userId,Long postId);

}
