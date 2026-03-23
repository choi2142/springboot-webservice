import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostsService postsService;

    private Posts post;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        post = new Posts();
        post.setId(1L);
        post.setIsDeleted(true);
    }

    @Test
    void testRestorePost() {
        // Arrange
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));

        // Act
        postsService.restorePost(1L);

        // Assert
        assertFalse(post.getIsDeleted(), "Post should be restored and isDeleted should be false");
        verify(postRepository, times(1)).save(post);
    }
}