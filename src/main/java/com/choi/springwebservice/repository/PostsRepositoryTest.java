import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.choi.springwebservice.domain.Posts;
import com.choi.springwebservice.repository.PostsRepostitory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@Transactional
@Rollback
class PostsRepositoryTest {

    @Autowired
    private PostsRepostitory postsRepostitory;

    private Posts post;

    @BeforeEach
    void setUp() {
        post = new Posts();
        post.setTitle("Test Title");
        post.setContent("Test Content");
        postsRepostitory.save(post);
    }

    @Test
    public void 게시글조회시_조회수증가() {
        // Given
        Long postId = post.getId();

        // When
        Posts retrievedPost = postsRepostitory.findById(postId).orElseThrow();
        retrievedPost.updateViews();

        // Then
        assertThat(retrievedPost.getViews()).isEqualTo(1);
    }
}