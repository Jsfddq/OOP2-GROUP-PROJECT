import java.util.*;

public class QuizGame {

    // TESTING
    /*
    public static void main(String[] args) {
        QuizGame game = new QuizGame();
        game.startQuiz();
    }*/

    public void startQuiz(){
        Scanner scan = new Scanner(System.in);
        int score = 0;

        String[] questions = {
            "1. What is the index of '30' in {10, 20, 30, 40}?",
            "2. What is the result of 17 % 5?",
            "3. What is the result of 189 % 6?",
            "4. What is the length of the string \"Java 2026\"?",
            "5. What is the result of 10 + 5 * 2 - 6 / 2?"
        };

        int[] answers = {2, 2, 3, 9, 17};

        System.out.println("--- Welcome to the Java Quiz ---");
        System.out.println("Type your answer and press Enter.\n");

        for (int i = 0; i < questions.length; i++) {
            boolean valid = false;

            while (!valid) {
                try {
                    System.out.println(questions[i]);
                    System.out.print("Your Answer: ");
                    
                    int userAnswer = scan.nextInt(); 
                    valid = true;

                    if (userAnswer == answers[i]) {
                        System.out.println("Correct!\n");
                        score++;
                    } else {
                        System.out.println("Wrong. The correct answer was: " + answers[i] + "\n");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid integer.");
                    scan.next(); 
                    System.out.println();
                }
            }
        }
        System.out.println("--- Quiz Finished ---");
        System.out.println("Your Final Score: " + score + "/" + questions.length);
        
        if (score == questions.length) {
            System.out.println("Perfect score! You're a Java Pro.");
        }

        scan.close();
    }
}