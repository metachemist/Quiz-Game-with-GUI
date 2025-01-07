import javafx.geometry.Pos; // Provides alignment options for UI elements.
import javafx.scene.Scene; // Represents the container for all content in a JavaFX application.
import javafx.scene.control.Button; // Represents buttons that users can interact with.
import javafx.scene.control.Label; // Used to display text in the UI.
import javafx.scene.layout.VBox; // A layout pane that arranges its children in a vertical column.
import javafx.stage.Stage; // Represents the primary window of the application.

class QuizUI {
    private final QuizGameJavaFX quizGame; // Reference to the main application class for accessing its methods and data.

    // Constructor to initialize the QuizUI class with the main application instance.
    public QuizUI(QuizGameJavaFX quizGame) {
        this.quizGame = quizGame;
    }

    /**
     * Creates the quiz scene where the questions, options, and score are displayed.
     * @param primaryStage The main application window where the scene will be set.
     * @return A Scene object containing the quiz layout.
     */
    public Scene createQuizScene(Stage primaryStage) {
        VBox quizLayout = new VBox();
        quizLayout.setAlignment(Pos.CENTER);

        // Set custom spacing between elements
        quizLayout.setSpacing(10); // Reduce overall spacing

        // Question label
        Label questionLabel = new Label();
        questionLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        quizGame.setQuestionLabel(questionLabel);

        // Score label
        Label scoreLabel = new Label("Score: 0");
        scoreLabel.setStyle("-fx-font-size: 16px;");
        quizGame.setScoreLabel(scoreLabel);

        // Option buttons
        Button[] optionButtons = new Button[4];
        VBox optionsBox = new VBox(5); // Custom spacing for options
        optionsBox.setAlignment(Pos.CENTER);
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new Button();

            // Style for smooth edges and a polished look
            optionButtons[i].setStyle(
                    "-fx-font-size: 16px;" +
                            "-fx-padding: 10px 20px;" +
                            "-fx-background-color: #bdc3c7;" + // Light blue background
                            "-fx-text-fill: black;" +         // White text
                            "-fx-background-radius: 15px;" + // Smooth edges
                            "-fx-border-radius: 15px;" +     // Match border radius
                            "-fx-border-width: 2px;"
            );

            int finalI = i;
            optionButtons[i].setOnAction(e -> quizGame.handleAnswer(optionButtons[finalI].getText(), primaryStage));
            optionsBox.getChildren().add(optionButtons[i]);
        }
        quizGame.setOptionButtons(optionButtons);


        // Play Again button
        Button playAgainButton = new Button("Play Again");
        playAgainButton.setStyle("-fx-font-size: 16px; -fx-padding: 10px 20px;");
        playAgainButton.setOnAction(e -> quizGame.startMainMenu(primaryStage));
        playAgainButton.setVisible(false);
        quizGame.setPlayAgainButton(playAgainButton);

        // Add elements with reduced spacing
        quizLayout.getChildren().addAll(questionLabel, scoreLabel, optionsBox, playAgainButton);
        return new Scene(quizLayout, 700, 500);
    }
}
