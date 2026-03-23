import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.choi.springwebservice.domain.Posts;
import com.choi.springwebservice.domain.PostsRepository;

@DataJpaTest
public class PostsRepositoryTest {

    @Autowired
    private PostsRepository postsRepository;

    @Test
    public void 게시글조회시_조회수증가() {
        // given
        Posts post = new Posts("title", "content");
        postsRepository.save(post);

        // when
        Posts foundPost = postsRepository.findById(post.getId()).orElseThrow(() -> new RuntimeException("Post not found"));
        foundPost.updateViews();

        // then
        assertThat(foundPost.getViews()).isEqualTo(1);
    }
}