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

    /**
     * Gets the user's password.
     * @return The password as a String.
     */
    public String getPassword() {
        return password; // Return the password. Note: Be cautious with exposing passwords.
    }

    /**
     * Gets the user's last score.
     * @return The last score as an integer.
     */
    public int getLastScore() {
        return lastScore; // Return the last recorded score.
    }

    /**
     * Updates the user's last score.
     * @param lastScore The new score to set.
     */
    public void setLastScore(int lastScore) {
        this.lastScore = lastScore; // Update the last score with the new value.
    }
}
