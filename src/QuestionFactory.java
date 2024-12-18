import java.util.Arrays;
import java.util.List;

class QuestionFactory {
    public static List<Question> getHistoryQuestions() {
        return Arrays.asList(
                new Question("Who was the first President of the United States?", new String[]{"Abraham Lincoln", "George Washington", "Thomas Jefferson", "John Adams"}, "George Washington"),
                new Question("In what year did World War II end?", new String[]{"1942", "1945", "1948", "1950"}, "1945"),
                new Question("Who discovered America?", new String[]{"Christopher Columbus", "Vasco da Gama", "Ferdinand Magellan", "Marco Polo"}, "Christopher Columbus")
        );
    }

    public static List<Question> getGeographyQuestions() {
        return Arrays.asList(
                new Question("Which is the largest ocean on Earth?", new String[]{"Atlantic", "Indian", "Arctic", "Pacific"}, "Pacific"),
                new Question("Which country has the most natural lakes?", new String[]{"India", "Canada", "Australia", "Russia"}, "Canada"),
                new Question("What is the capital of Australia?", new String[]{"Sydney", "Melbourne", "Canberra", "Brisbane"}, "Canberra")
        );
    }

    public static List<Question> getBodyFactsQuestions() {
        return Arrays.asList(
                new Question("How many bones are in the human body?", new String[]{"206", "208", "210", "212"}, "206"),
                new Question("What is the largest organ in the human body?", new String[]{"Liver", "Skin", "Heart", "Brain"}, "Skin"),
                new Question("What is the smallest bone in the human body?", new String[]{"Stapes", "Femur", "Humerus", "Radius"}, "Stapes")
        );
    }

    public static List<Question> getGeneralKnowledgeQuestions() {
        return Arrays.asList(
                new Question("Who wrote 'Romeo and Juliet'?", new String[]{"Charles Dickens", "Mark Twain", "William Shakespeare", "Leo Tolstoy"}, "William Shakespeare"),
                new Question("What is the boiling point of water?", new String[]{"90°C", "100°C", "120°C", "110°C"}, "100°C"),
                new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Venus"}, "Mars")
        );
    }
}
