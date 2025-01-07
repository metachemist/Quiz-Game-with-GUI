import java.io.Serializable;

// The `User` class represents a user in the quiz game.
// It implements `Serializable` so that objects of this class can be saved to a file or transferred over a network.
public class User implements Serializable {
    // The user's password is stored as a private final field for security purposes.
    private final String password;

    // The user's last score is stored as a private field.
    private int lastScore;

    /**
     * Constructor to initialize a `User` object with a password and last score.
     * @param password The user's password.
     * @param lastScore The user's last recorded score.
     */
    public User(String password, int lastScore) {
        this.password = password; // Set the user's password.
        this.lastScore = lastScore; // Set the user's last score.
    }


}
