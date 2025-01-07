import java.util.List;
import java.util.Map;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * MainMenu class manages the user interface for the main menu of the quiz game.
 * It allows the user to select a category to start the quiz.
 */

class MainMenu {
    // Map storing categories and their corresponding list of questions
    private final Map<String, List<Question>> categories;
    // Reference to the QuizGameJavaFX object for handling game logic
    //    String (key) har user ka unique identifier hota hai, jaise username.
    //    User (value) ek object hota hai jo user ki details (e.g., username, score) ko represent karta hai.
    private final QuizGameJavaFX quizGame;

    /**
     * Constructor for MainMenu.
     *
     * @param categories A map where keys are category names, and values are lists of questions.
     * @param quizGame   Reference to the main quiz game application logic.
     */
    public MainMenu(Map<String, List<Question>> categories, QuizGameJavaFX quizGame) {
        this.categories = categories;
        this.quizGame = quizGame;
    }

    /**
     * Creates the main menu scene where users can select a category.
     *
     * @param primaryStage The primary stage of the application.
     * @return A Scene object representing the main menu.
     */
    public Scene createMainMenuScene(Stage primaryStage) {
        // Main vertical layout for the menu, with spacing and center alignment
        VBox mainLayout = new VBox(20);
        mainLayout.setAlignment(Pos.CENTER);

        // Title label for the menu
        Label titleLabel = new Label("Choose a Category");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Horizontal layout to hold category buttons
        HBox categoryButtonsBox = new HBox(20);
        categoryButtonsBox.setAlignment(Pos.CENTER);

        // Array to store category buttons, one for each category
        Button[] categoryButtons = new Button[categories.size()];

        // Index counter for the buttons array
        int index = 0;

        // Loop through the categories to create a button for each
        for (String category : categories.keySet()) {
            // Create a button with the category name as its label
            categoryButtons[index] = new Button(category);
            // Set the style of the button
            categoryButtons[index].setStyle("-fx-font-size: 16px; -fx-padding: 10px 15px;");

            // Set the action for the button: start the quiz for the selected category
            categoryButtons[index].setOnAction(e -> quizGame.startQuiz(category, primaryStage));

            // Add the button to the horizontal layout
            categoryButtonsBox.getChildren().add(categoryButtons[index]);
            index++; // Move to the next button
        }

        // Add the title label and the button box to the main vertical layout
        mainLayout.getChildren().addAll(titleLabel, categoryButtonsBox);

        // Create and return the scene with the layout
        return new Scene(mainLayout, 700, 500);
    }
}
