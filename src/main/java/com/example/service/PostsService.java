import com.example.model.Posts;
import com.example.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsService {

    @Autowired
    private PostsRepository postsRepository;

    // Other methods...

    public void restorePost(Long id) {
        // Fetch the post by ID
        Posts post = postsRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        // Call the restore method on the post entity
        post.restore();
        // Save the updated post back to the repository
        postsRepository.save(post);
        // Log the restoration
        System.out.println("Post with ID " + id + " has been restored successfully.");
    }
}