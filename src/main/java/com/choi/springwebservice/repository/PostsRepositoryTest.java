import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.choi.springwebservice.domain.Posts;
import com.choi.springwebservice.repository.PostsRepostitory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PostsRepositoryTest {

    @Autowired
    private PostsRepostitory postsRepostitory;

    private Posts post;

    @BeforeEach
    public void setUp() {
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
        Posts retrievedPost = postsRepostitory.getDetail(postId);

        // Then
        assertThat(retrievedPost.getViews()).isEqualTo(1);
    }
}