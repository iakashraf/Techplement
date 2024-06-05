import java.util.*;

public class Main {

    public static Map<String, Quiz> quizzes = new HashMap<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("\n Enter your choice:");
            System.out.println("1. Create quiz");
            System.out.println("2. Add question");
            System.out.println("3. Take quiz");
            System.out.println("4. Exit");
            System.out.print("Enter command: ");
            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    createquiz(s);
                    break;
                case 2:
                    addquestion(s);
                    break;
                case 3:
                    takequiz(s);
                    break;
                case 4:
                    System.out.println("Exiting program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }
    }

    public static void createquiz(Scanner sc) {
        System.out.print("Enter quiz title: ");
        String title = sc.nextLine();
        quizzes.put(title, new Quiz(title));
        System.out.println("Quiz created: " + title);
    }
   public static void addquestion(Scanner sc){
    System.out.print("Enter quiz title: ");
        String title = sc.nextLine();
        Quiz quiz = quizzes.get(title);

        if (quiz == null) {
            System.out.println("Quiz not found.");
            return;
        }

        System.out.print("Enter question text: ");
        String questionText = sc .nextLine();

        System.out.print("Enter number of options: ");
        int numOptions = sc.nextInt();
        sc.nextLine();

        List<String> options = new ArrayList<>();
        for (int k = 0; k < numOptions; k++) {
            System.out.print("Enter option " + (k + 1) + ": ");
            options.add(sc.nextLine());
        }

        System.out.print("Enter correct answer index (1-" + numOptions + "): ");
        int correctAnswerIndex = sc.nextInt() - 1;
        sc.nextLine();

        Question question = new Question(questionText, options, correctAnswerIndex);
        quiz.addQuestion(question);
        System.out.println("Question added to quiz: " + title);
    }

    public static void takequiz(Scanner scanner) {
        System.out.print("Enter quiz title: ");
        String title = scanner.nextLine();
        Quiz quiz = quizzes.get(title);

        if (quiz == null) {
            System.out.println("Quiz not found.");
            return;
        }

        quiz.takeQuiz();
    }
}
