import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^010-\d{4}-\d{4}$", message = "Invalid phone number format. Must be 010-XXXX-XXXX.")
    private String phoneNumber;

    // Other fields, getters, and setters

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}