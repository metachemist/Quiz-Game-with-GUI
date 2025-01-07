import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;

import java.io.*;
import java.util.*;

/**
 * Main class for the Quiz Game using JavaFX.
 * Handles user login, quiz management, and user score tracking.
 */
public class QuizGameJavaFX extends Application {
    private String currentUser; // Store the logged-in user
    private int currentQuestionIndex = 0; // Track the current question index in the quiz
    private int score = 0; // Store the current score
    private List<Question> currentQuestions; // List of questions for the current quiz session

    private Button playAgainButton;

    private Label questionLabel; // Label to display the current question
    private Button[] optionButtons; // Buttons for the answer options
    private Label scoreLabel; // Label to display the score

    private final Map<String, List<Question>> categories = new HashMap<>(); // Store quiz categories and questions
    private HashMap<String, User> users = new HashMap<>(); // Store user data, including scores

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Quiz Game");

        // Initialize categories and questions
        initializeQuestions();

        // Load user data from file
        loadUserDataFromFile();

        // Start with the Login UI
        LoginUI loginUI = new LoginUI(this);
        Scene loginScene = loginUI.createLoginScene(primaryStage);

        primaryStage.setScene(loginScene); // Set the login scene as the initial scene
        primaryStage.show(); // Display the primary stage
    }

    // Set the current logged-in user
    public void setCurrentUser(String username) {
        this.currentUser = username;
    }

    // Play again
    public void setPlayAgainButton(Button playAgainButton) {
        this.playAgainButton = playAgainButton;
    }

    // Start the main menu UI
    public void startMainMenu(Stage primaryStage) {
        initializeQuestions(); // Ensure categories and questions are initialized

        // Set up the main menu UI
        MainMenu mainMenu = new MainMenu(categories, this);
        Scene mainScene = mainMenu.createMainMenuScene(primaryStage);

        primaryStage.setScene(mainScene); // Display the main menu scene
    }

    // Initialize quiz questions for each category
    private void initializeQuestions() {
        categories.put("History", QuestionFactory.getHistoryQuestions());
        categories.put("Geography", QuestionFactory.getGeographyQuestions());
        categories.put("Body Facts", QuestionFactory.getBodyFactsQuestions());
        categories.put("General Knowledge", QuestionFactory.getGeneralKnowledgeQuestions());
    }

    // Start the quiz for a selected category
    public void startQuiz(String category, Stage primaryStage) {
        currentQuestions = new ArrayList<>(categories.get(category)); // Load questions for the category
        Collections.shuffle(currentQuestions); // Shuffle questions for randomness
        currentQuestionIndex = 0; // Reset question index
        score = 0; // Reset score

        // Set up the quiz UI
        QuizUI quizUI = new QuizUI(this);
        Scene quizScene = quizUI.createQuizScene(primaryStage);
        primaryStage.setScene(quizScene); // Display the quiz scene

        loadNextQuestion(); // Load the first question
    }

    // Load the next question in the quiz
    private void loadNextQuestion() {
        if (currentQuestionIndex < currentQuestions.size()) {
            // Load the current question and set its text
            Question currentQuestion = currentQuestions.get(currentQuestionIndex);
            questionLabel.setText(currentQuestion.getQuestionText());

            // Update the options on the buttons
            String[] options = currentQuestion.getOptions();
            for (int i = 0; i < 4; i++) {
                optionButtons[i].setText(options[i]);
                optionButtons[i].setDisable(false); // Enable buttons for the new question
                optionButtons[i].setVisible(true); // Make buttons visible
            }
        } else {
            // Display game over message
            questionLabel.setText("Game Over! Final Score: " + score);

            // Hide the option buttons
            for (Button button : optionButtons) {
                button.setVisible(false); // Hide the buttons at the end of the game
            }

            // Show the "Play Again" button
            playAgainButton.setVisible(true);
        }
    }

    // Handle user answer and load the next question
    public void handleAnswer(String selectedAnswer, Stage primaryStage) {
        Question currentQuestion = currentQuestions.get(currentQuestionIndex);
        if (currentQuestion.getCorrectAnswer().equals(selectedAnswer)) {
            score++; // Increment score if the answer is correct
        }
        scoreLabel.setText("Score: " + score); // Update the score label
        currentQuestionIndex++; // Move to the next question
        loadNextQuestion(); // Load the next question
    }

    // Setter for question label
    public void setQuestionLabel(Label questionLabel) {
        this.questionLabel = questionLabel;
    }

    // Setter for option buttons
    public void setOptionButtons(Button[] optionButtons) {
        this.optionButtons = optionButtons;
    }

    // Setter for score label
    public void setScoreLabel(Label scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    // Load user data from a file
    private void loadUserDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("userdata.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String username = parts[0];
                    int lastScore = Integer.parseInt(parts[1]);
                    users.put(username, new User(username, lastScore)); // Load user and score
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading user data: " + e.getMessage());
        }
    }
}
