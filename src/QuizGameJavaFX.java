import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.*;

public class QuizGameJavaFX extends Application {

    private int currentQuestionIndex = 0;
    private int score = 0;
    private List<Question> currentQuestions;

    private Label questionLabel;
    private Button[] optionButtons;
    private Label scoreLabel;

    private final Map<String, List<Question>> categories = new HashMap<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Quiz Game");

        
        // Initialize categories and questions
        initializeQuestions();

        // Set up main menu UI
        MainMenu mainMenu = new MainMenu(categories, this);
        Scene mainScene = mainMenu.createMainMenuScene(primaryStage);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    private void initializeQuestions() {
        categories.put("History", QuestionFactory.getHistoryQuestions());
        categories.put("Geography", QuestionFactory.getGeographyQuestions());
        categories.put("Body Facts", QuestionFactory.getBodyFactsQuestions());
        categories.put("General Knowledge", QuestionFactory.getGeneralKnowledgeQuestions());
    }

    public void startQuiz(String category, Stage primaryStage) {
        currentQuestions = new ArrayList<>(categories.get(category));
        Collections.shuffle(currentQuestions);
        currentQuestionIndex = 0;
        score = 0;

        // Set up quiz UI
        QuizUI quizUI = new QuizUI(this);
        Scene quizScene = quizUI.createQuizScene(primaryStage);
        primaryStage.setScene(quizScene);

        loadNextQuestion();
    }

    private void loadNextQuestion() {
        if (currentQuestionIndex < currentQuestions.size()) {
            Question currentQuestion = currentQuestions.get(currentQuestionIndex);
            questionLabel.setText(currentQuestion.getQuestionText());
            String[] options = currentQuestion.getOptions();
            for (int i = 0; i < 4; i++) {
                optionButtons[i].setText(options[i]);
            }
        } else {
            questionLabel.setText("Game Over! Final Score: " + score);
            for (Button button : optionButtons) {
                button.setDisable(true);
            }
        }
    }

    public void handleAnswer(String selectedAnswer, Stage primaryStage) {
        Question currentQuestion = currentQuestions.get(currentQuestionIndex);
        if (currentQuestion.getCorrectAnswer().equals(selectedAnswer)) {
            score++;
        }
        scoreLabel.setText("Score: " + score);
        currentQuestionIndex++;
        loadNextQuestion();
    }

    public Label getQuestionLabel() {
        return questionLabel;
    }

    public Button[] getOptionButtons() {
        return optionButtons;
    }

    public Label getScoreLabel() {
        return scoreLabel;
    }

    public void setQuestionLabel(Label questionLabel) {
        this.questionLabel = questionLabel;
    }

    public void setOptionButtons(Button[] optionButtons) {
        this.optionButtons = optionButtons;
    }

    public void setScoreLabel(Label scoreLabel) {
        this.scoreLabel = scoreLabel;
    }
}