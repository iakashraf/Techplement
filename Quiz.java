import java.util.*;

public class Quiz {
    public String title;
    public List<Question> questions;

    public Quiz(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void takeQuiz() {
        Scanner s = new Scanner(System.in);
        int score = 0;

        for (Question question : questions) {
            System.out.println(question.getquestiontext());
            List<String> options = question.getoptions();

            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + " . " + options.get(j));
            }

            System.out.print("Your answer: ");
            int userAnswer = s.nextInt();

            if (userAnswer - 1 == question.getcorrectanswerindex()) {
                score++;
            }
        }

        System.out.println("You scored " + score + " out of " + questions.size());
    }
}
