import java.util.Arrays;
import java.util.List;

// The `QuestionFactory` class is responsible for creating and providing lists of questions for various categories.
class QuestionFactory {

    /**
     * Provides a list of history-related questions.
     * @return A list of `Question` objects related to history.
     */
    public static List<Question> getHistoryQuestions() {
        // Returns a list of `Question` objects with history-based questions, options, and correct answers.
        return Arrays.asList(
                new Question(
                        "Who was the first President of the United States?",
                        new String[]{"Abraham Lincoln", "George Washington", "Thomas Jefferson", "John Adams"},
                        "George Washington"
                ),
                new Question(
                        "In what year did World War II end?",
                        new String[]{"1942", "1945", "1948", "1950"},
                        "1945"
                ),
                new Question(
                        "Who discovered America?",
                        new String[]{"Christopher Columbus", "Vasco da Gama", "Ferdinand Magellan", "Marco Polo"},
                        "Christopher Columbus"
                ),
                new Question(
                        "Who was the first woman to fly solo across the Atlantic Ocean?",
                        new String[]{"Amelia Earhart", "Harriet Quimby", "Bessie Coleman", "Jacqueline Cochran"},
                        "Amelia Earhart"
                ),
                new Question(
                        "In which year did the Titanic sink?",
                        new String[]{"1912", "1908", "1921", "1899"},
                        "1912"
                ),
                new Question(
                        "Who was the first emperor of China?",
                        new String[]{"Wudi", "Qin Shi Huang", "Li Shimin", "Zhao Kuangyin"},
                        "Qin Shi Huang"
                ),
                new Question(
                        "Which country was ruled by the Pharaohs?",
                        new String[]{"Greece", "Rome", "Egypt", "Mesopotamia"},
                        "Egypt"
                ),
                new Question(
                        "Who was the British Prime Minister during World War II?",
                        new String[]{"Winston Churchill", "Neville Chamberlain", "Clement Attlee", "Harold Macmillan"},
                        "Winston Churchill"
                ),
                new Question(
                        "What year did the Berlin Wall fall?",
                        new String[]{"1989", "1991", "1987", "1990"},
                        "1989"
                ),
                new Question(
                        "Which event started World War I?",
                        new String[]{"Assassination of Archduke Franz Ferdinand", "German invasion of Belgium", "Battle of Verdun", "Attack on Poland"},
                        "Assassination of Archduke Franz Ferdinand"
                )
        );
    }

    /**
     * Provides a list of geography-related questions.
     * @return A list of `Question` objects related to geography.
     */
    public static List<Question> getGeographyQuestions() {
        // Returns a list of `Question` objects with geography-based questions, options, and correct answers.
        return Arrays.asList(
                new Question(
                        "Which is the largest ocean on Earth?",
                        new String[]{"Atlantic", "Indian", "Arctic", "Pacific"},
                        "Pacific"
                ),
                new Question(
                        "Which country has the most natural lakes?",
                        new String[]{"India", "Canada", "Australia", "Russia"},
                        "Canada"
                ),
                new Question(
                        "What is the capital of Australia?",
                        new String[]{"Sydney", "Melbourne", "Canberra", "Brisbane"},
                        "Canberra"
                ),
                new Question(
                        "What is the smallest country in the world?",
                        new String[]{"Monaco", "Liechtenstein", "Vatican City", "San Marino"},
                        "Vatican City"
                ),
                new Question(
                        "Which country is known as the Land of the Rising Sun?",
                        new String[]{"Japan", "China", "South Korea", "Thailand"},
                        "Japan"
                ),
                new Question(
                        "Which is the longest river in the world?",
                        new String[]{"Amazon River", "Nile River", "Yangtze River", "Mississippi River"},
                        "Nile River"
                ),
                new Question(
                        "Which continent is the Sahara Desert located in?",
                        new String[]{"Asia", "Africa", "South America", "Australia"},
                        "Africa"
                ),
                new Question(
                        "What is the tallest mountain in the world?",
                        new String[]{"K2", "Mount Everest", "Kangchenjunga", "Lhotse"},
                        "Mount Everest"
                ),
                new Question(
                        "Which country has the largest population?",
                        new String[]{"India", "China", "USA", "Indonesia"},
                        "China"
                ),
                new Question(
                        "Which city is the capital of Canada?",
                        new String[]{"Vancouver", "Toronto", "Ottawa", "Montreal"},
                        "Ottawa"
                )
        );
    }

    /**
     * Provides a list of human body-related questions.
     * @return A list of `Question` objects related to body facts.
     */
    public static List<Question> getBodyFactsQuestions() {
        // Returns a list of `Question` objects with body facts-based questions, options, and correct answers.
        return Arrays.asList(
                new Question(
                        "How many bones are in the human body?",
                        new String[]{"206", "208", "210", "212"},
                        "206"
                ),
                new Question(
                        "What is the largest organ in the human body?",
                        new String[]{"Liver", "Skin", "Heart", "Brain"},
                        "Skin"
                ),
                new Question(
                        "What is the smallest bone in the human body?",
                        new String[]{"Stapes", "Femur", "Humerus", "Radius"},
                        "Stapes"
                ),
                new Question(
                        "Which part of the human body is responsible for pumping blood?",
                        new String[]{"Brain", "Liver", "Heart", "Lungs"},
                        "Heart"
                ),
                new Question(
                        "How many chambers are in the human heart?",
                        new String[]{"2", "3", "4", "5"},
                        "4"
                ),
                new Question(
                        "What is the average lifespan of a red blood cell?",
                        new String[]{"120 days", "60 days", "30 days", "180 days"},
                        "120 days"
                ),
                new Question(
                        "Which organ filters waste from the blood?",
                        new String[]{"Kidneys", "Liver", "Lungs", "Spleen"},
                        "Kidneys"
                ),
                new Question(
                        "What is the longest bone in the human body?",
                        new String[]{"Femur", "Tibia", "Humerus", "Fibula"},
                        "Femur"
                ),
                new Question(
                        "What part of the brain controls balance?",
                        new String[]{"Cerebellum", "Cerebrum", "Medulla", "Thalamus"},
                        "Cerebellum"
                ),
                new Question(
                        "How many pairs of ribs does a human typically have?",
                        new String[]{"10", "11", "12", "13"},
                        "12"
                )
        );
    }

    /**
     * Provides a list of general knowledge-related questions.
     * @return A list of `Question` objects related to general knowledge.
     */
    public static List<Question> getGeneralKnowledgeQuestions() {
        // Returns a list of `Question` objects with general knowledge-based questions, options, and correct answers.
        return Arrays.asList(
                new Question(
                        "Who wrote 'Romeo and Juliet'?",
                        new String[]{"Charles Dickens", "Mark Twain", "William Shakespeare", "Leo Tolstoy"},
                        "William Shakespeare"
                ),
                new Question(
                        "What is the boiling point of water?",
                        new String[]{"90°C", "100°C", "120°C", "110°C"},
                        "100°C"
                ),
                new Question(
                        "Which planet is known as the Red Planet?",
                        new String[]{"Earth", "Mars", "Jupiter", "Venus"},
                        "Mars"
                ),
                new Question(
                        "What is the square root of 64?",
                        new String[]{"6", "7", "8", "9"},
                        "8"
                ),
                new Question(
                        "What is the capital of France?",
                        new String[]{"London", "Berlin", "Paris", "Madrid"},
                        "Paris"
                ),
                new Question(
                        "Which element has the chemical symbol 'O'?",
                        new String[]{"Oxygen", "Osmium", "Ozone", "Oganesson"},
                        "Oxygen"
                ),
                new Question(
                        "What is the largest mammal on Earth?",
                        new String[]{"Elephant", "Blue Whale", "Giraffe", "Shark"},
                        "Blue Whale"
                ),
                new Question(
                        "Who painted the Mona Lisa?",
                        new String[]{"Vincent van Gogh", "Leonardo da Vinci", "Pablo Picasso", "Claude Monet"},
                        "Leonardo da Vinci"
                ),
                new Question(
                        "What is the currency of Japan?",
                        new String[]{"Yuan", "Won", "Yen", "Ringgit"},
                        "Yen"
                ),
                new Question(
                        "Which country is known for the pyramids?",
                        new String[]{"Mexico", "India", "Egypt", "Peru"},
                        "Egypt"
                )
        );
    }
}
