import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LoginUI {
    private final Map<String, Integer> scores = new HashMap<>();
    private final Map<String, String> users = new HashMap<>();
    private final QuizGameJavaFX quizGame;
    private static final String FILE_PATH = "user_data.txt";
    private static final int SCREEN_WIDTH = 700;  // Uniform screen width
    private static final int SCREEN_HEIGHT = 500; // Uniform screen height

    public LoginUI(QuizGameJavaFX quizGame) {
        this.quizGame = quizGame;
        loadUserData();
    }

    private void loadUserData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String username = parts[0];
                    String password = parts[1];
                    int score = Integer.parseInt(parts[2]);

                    users.put(username, password);
                    scores.put(username, score);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading user data: " + e.getMessage());
        }
    }

    private void saveUserData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String username : users.keySet()) {
                String password = users.get(username);
                int score = scores.getOrDefault(username, 0);
                writer.write(username + "," + password + "," + score);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving user data: " + e.getMessage());
        }
    }

    public Scene createLoginScene(Stage primaryStage) {
        VBox loginLayout = new VBox(15);
        loginLayout.setAlignment(Pos.CENTER);

        // Heading label
        Label headingLabel = new Label("Hello there, who's playing?");
        headingLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24)); // Custom font and size
        headingLabel.setStyle("-fx-text-fill: #333333;"); // Optional: Add a color style

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        usernameField.setMaxWidth(250); // Set preferred width for username field

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordField.setMaxWidth(250); // Set preferred width for password field

        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");
        Label feedbackLabel = new Label();

        //login Logic
        loginButton.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();

            if (users.containsKey(username) && users.get(username).equals(password)) {
                feedbackLabel.setText("Login successful!");
                quizGame.setCurrentUser(username);
                quizGame.startMainMenu(primaryStage);
            } else {
                feedbackLabel.setText("Invalid username or password.");
            }
        });
        // Switch to registration scene
        registerButton.setOnAction(e -> primaryStage.setScene(createRegistrationScene(primaryStage)));
        // Add components to layout
        loginLayout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton, registerButton, feedbackLabel);
        return new Scene(loginLayout, SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    private Scene createRegistrationScene(Stage primaryStage) {
        VBox registerLayout = new VBox(15);
        registerLayout.setAlignment(Pos.CENTER);

        // Heading for registration
        Label headingLabel = new Label("Welcome! Register below:");
        headingLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24)); // Custom font and size
        headingLabel.setStyle("-fx-text-fill: #333333;");
        
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        usernameField.setMaxWidth(250); // Set preferred width for username field

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordField.setMaxWidth(250); // Set preferred width for password field

        Button registerButton = new Button("Register");
        Button backButton = new Button("Back");
        Label feedbackLabel = new Label();

        //Registration logic
        registerButton.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();

            if (users.containsKey(username)) {
                feedbackLabel.setText("Username already exists.");
            } else if (username.isEmpty() || password.isEmpty()) {
                feedbackLabel.setText("Please fill in all fields.");
            } else {
                users.put(username, password);
                scores.put(username, 0);
                saveUserData();
                feedbackLabel.setText("Registration successful!");
            }
        });
        // Return to login scene
        backButton.setOnAction(e -> primaryStage.setScene(createLoginScene(primaryStage)));
        // Add components to layout
        registerLayout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, registerButton, backButton, feedbackLabel);
        return new Scene(registerLayout, SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    public int getUserScore(String username) {
        return scores.getOrDefault(username, 0);
    }

    public void updateUserScore(String username, int newScore) {
        scores.put(username, newScore);
        saveUserData();
    }
}
