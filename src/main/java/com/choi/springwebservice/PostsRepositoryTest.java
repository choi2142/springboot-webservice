import com.choi.springwebservice.domain.Posts;
import com.choi.springwebservice.repository.PostsRepostitory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PostsRepositoryTest {

    @Autowired
    private PostsRepostitory postsRepository;

    @Test
    public void testViewCountIncrement() {
        // Given
        Posts post = new Posts();
        post.setTitle("Test Title");
        post.setContent("Test Content");
        postsRepository.save(post);

        // When
        post.updateViews(); // Increment view count
        postsRepository.save(post); // Save the updated post

        // Then
        Posts updatedPost = postsRepository.findById(post.getId()).orElseThrow();
        assertThat(updatedPost.getViews()).isEqualTo(1);
    }
}