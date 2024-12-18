import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class QuizUI {
    private final QuizGameJavaFX quizGame;

    public QuizUI(QuizGameJavaFX quizGame) {
        this.quizGame = quizGame;
    }

    public Scene createQuizScene(Stage primaryStage) {
        VBox quizLayout = new VBox(20);
        quizLayout.setAlignment(Pos.CENTER);

        Label questionLabel = new Label();
        questionLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        quizGame.setQuestionLabel(questionLabel);

        Label scoreLabel = new Label("Score: 0");
        scoreLabel.setStyle("-fx-font-size: 16px;");
        quizGame.setScoreLabel(scoreLabel);

        Button[] optionButtons = new Button[4];
        VBox optionsBox = new VBox(10);
        optionsBox.setAlignment(Pos.CENTER);
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new Button();
            optionButtons[i].setStyle("-fx-font-size: 16px; -fx-padding: 10px 20px;");
            int finalI = i;
            optionButtons[i].setOnAction(e -> quizGame.handleAnswer(optionButtons[finalI].getText(), primaryStage));
            optionsBox.getChildren().add(optionButtons[i]);
        }
        quizGame.setOptionButtons(optionButtons);

        quizLayout.getChildren().addAll(questionLabel, optionsBox, scoreLabel);
        return new Scene(quizLayout, 800, 600);
    }
}
