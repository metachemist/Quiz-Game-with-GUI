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
    // Maps to store user credentials and their scores
    private final Map<String, Integer> scores = new HashMap<>();
    private final Map<String, String> users = new HashMap<>();
    private final QuizGameJavaFX quizGame;

    // File path for saving and loading user data
    private static final String FILE_PATH = "user_data.txt";

    // Screen dimensions for uniformity
    private static final int SCREEN_WIDTH = 700;
    private static final int SCREEN_HEIGHT = 500;

    public LoginUI(QuizGameJavaFX quizGame) {
        this.quizGame = quizGame;
        loadUserData(); // Load user data at initialization
    }

    // Load user data from a file into the `users` and `scores` maps
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

    // Save user data from the `users` and `scores` maps to a file
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

    // Create the login scene
    public Scene createLoginScene(Stage primaryStage) {
        // Create a VBox layout with spacing and center alignment
        VBox loginLayout = new VBox(15);
        loginLayout.setAlignment(Pos.CENTER);

        // Heading label for the login screen
        Label headingLabel = new Label("Hello there, who's playing?");
        headingLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        // Username and password fields with labels
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        usernameField.setMaxWidth(250);

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordField.setMaxWidth(250);

        // Buttons for login and registration
        Button loginButton = new Button("Login");
        Label newUserLabel = new Label("New here? 👀");
        newUserLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 13));
        Button registerButton = new Button("Register");

        // Feedback label for displaying login status
        Label feedbackLabel = new Label();
        // Login button logic
        loginButton.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();

            // Validate username and password
            if (users.containsKey(username) && users.get(username).equals(password)) {
                int lastScore = scores.getOrDefault(username, 0);
                feedbackLabel.setText("Welcome back! Your last score was: " + lastScore);
                quizGame.setCurrentUser(username); // Store the current user's name
                quizGame.startMainMenu(primaryStage); // Transition to main menu
            } else {
                feedbackLabel.setText("Invalid username or password.");
            }
        });

        // Switch to registration scene
        registerButton.setOnAction(e -> primaryStage.setScene(createRegistrationScene(primaryStage)));

        // Add all components to the layout
        loginLayout.getChildren().addAll(headingLabel, usernameLabel, usernameField, passwordLabel, passwordField, loginButton, newUserLabel, registerButton, feedbackLabel);

        // Return the constructed scene
        return new Scene(loginLayout, SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    // Create the registration scene
    private Scene createRegistrationScene(Stage primaryStage) {
        VBox registerLayout = new VBox(15);
        registerLayout.setAlignment(Pos.CENTER);

        // Heading label for the registration screen
        Label headingLabel = new Label("Welcome! Register below:");
        headingLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        // Username and password fields with labels
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        usernameField.setMaxWidth(250);

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordField.setMaxWidth(250);

        // Buttons for registration and going back to login
        Button registerButton = new Button("Register");
        Button backButton = new Button("Back");

        // Feedback label for displaying registration status
        Label feedbackLabel = new Label();

        // Registration button logic
// ActionEvent is a class in JavaFX that represents an action event, such as a button click, menu selection, or other UI interactions.

        registerButton.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();

            // Validate registration details
            if (users.containsKey(username)) {
                feedbackLabel.setText("Username already exists.");
            } else if (username.isEmpty() || password.isEmpty()) {
                feedbackLabel.setText("Please fill in all fields.");
            } else {
                users.put(username, password);
                scores.put(username, 0);
                saveUserData(); // Save the new user to the file
                feedbackLabel.setText("Registration successful!");
            }
        });

        // Back button logic to return to the login scene
        backButton.setOnAction(e -> primaryStage.setScene(createLoginScene(primaryStage)));

        // Add all components to the layout
        registerLayout.getChildren().addAll(headingLabel, usernameLabel, usernameField, passwordLabel, passwordField, registerButton, backButton, feedbackLabel);

        // Return the constructed scene
        return new Scene(registerLayout, SCREEN_WIDTH, SCREEN_HEIGHT);
    }

}
