import java.util.List;
import java.util.Map;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class MainMenu {
    private final Map<String, List<Question>> categories;
    private final QuizGameJavaFX quizGame;

    public MainMenu(Map<String, List<Question>> categories, QuizGameJavaFX quizGame) {
        this.categories = categories;
        this.quizGame = quizGame;
    }

    public Scene createMainMenuScene(Stage primaryStage) {
        VBox mainLayout = new VBox(20);
        mainLayout.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Choose a Category");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        HBox categoryButtonsBox = new HBox(20);
        categoryButtonsBox.setAlignment(Pos.CENTER);
        Button[] categoryButtons = new Button[categories.size()];
        int index = 0;
        for (String category : categories.keySet()) {
            categoryButtons[index] = new Button(category);
            categoryButtons[index].setStyle("-fx-font-size: 16px; -fx-padding: 10px 20px;");
            categoryButtons[index].setOnAction(e -> quizGame.startQuiz(category, primaryStage));
            categoryButtonsBox.getChildren().add(categoryButtons[index]);
            index++;
        }

        mainLayout.getChildren().addAll(titleLabel, categoryButtonsBox);
        return new Scene(mainLayout, 800, 600);
    }
}