// The `Question` class represents a single quiz question with its text, possible answers, and the correct answer.
class Question {
    // Private fields to store the question's text, answer options, and the correct answer.
    private final String questionText; // The text of the question to be displayed to the user.
    private final String[] options;    // An array containing four answer options for the question.
    private final String correctAnswer; // The correct answer for the question.

    /**
     * Constructor to initialize a `Question` object with its text, answer options, and correct answer.
     * @param questionText The text of the question.
     * @param options An array of four possible answers for the question.
     * @param correctAnswer The correct answer for the question (must be one of the options).
     */
    public Question(String questionText, String[] options, String correctAnswer) {
        this.questionText = questionText;         // Assign the question text to the field.
        this.options = options;                   // Assign the answer options to the field.
        this.correctAnswer = correctAnswer;       // Assign the correct answer to the field.
    }

    /**
     * Getter method to retrieve the question text.
     * @return The text of the question.
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Getter method to retrieve the answer options.
     * @return An array containing the four answer options.
     */
    public String[] getOptions() {
        return options;
    }

    /**
     * Getter method to retrieve the correct answer.
     * @return The correct answer for the question.
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
