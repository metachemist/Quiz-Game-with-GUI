import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

class LoginUI {
    private final Map<String, String> users = new HashMap<>(); // Stores username and password
    private final QuizGameJavaFX quizGame;

    public LoginUI(QuizGameJavaFX quizGame) {
        this.quizGame = quizGame;
        initializeUsers();
    }

    // Add some default users
    private void initializeUsers() {
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("admin", "admin123");
    }

    public Scene createLoginScene(Stage primaryStage) {
        VBox loginLayout = new VBox(15);
        loginLayout.setAlignment(Pos.CENTER);

        // UI Components
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");
        Label feedbackLabel = new Label(); // For error/success messages

        // Handle login button click
        loginButton.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();

            if (users.containsKey(username) && users.get(username).equals(password)) {
                feedbackLabel.setText("Login successful!");
                quizGame.startMainMenu(primaryStage); // Navigate to main menu
            } else {
                feedbackLabel.setText("Invalid username or password.");
            }
        });

        loginLayout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton, feedbackLabel);

        return new Scene(loginLayout, 400, 300);
    }
}
