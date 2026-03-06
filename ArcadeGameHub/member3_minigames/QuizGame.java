package member3_minigames;

import member1_core.Game;
import member2_system.InputHandler;
import member2_system.ScoreManager;
import member4_output.Display;

public class QuizGame extends Game {
    private InputHandler inputHandler;
    private ScoreManager scoreManager;
    private Display display;

    public QuizGame(InputHandler inputHandler, ScoreManager scoreManager, Display display) {
        super("Quiz Game");
        this.inputHandler = inputHandler;
        this.scoreManager = scoreManager;
        this.display = display;
    }

    @Override
    public void play() {
        String[] questions = {
            "What is the index of '30' in the array {10, 20, 30, 40}?",
            "What is the result of 17 % 5?",
            "What is the result of 189 % 6?",
            "What is the length of the string \"Java 2026\"?",
            "What is the result of 10 + 5 * 2 - 6 / 2?"
        };

        int[] answers = {2, 2, 3, 9, 17};
        int score = 0;

        System.out.println("\n📝 WELCOME TO THE JAVA QUIZ!");
        System.out.println("Answer " + questions.length + " questions correctly to earn points!\n");

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            int userAnswer = inputHandler.getIntInput("Your answer: ");

            if (userAnswer == answers[i]) {
                System.out.println("✅ Correct!\n");
                score++;
                scoreManager.addPoints(2);
            } else {
                System.out.println("❌ Wrong. The correct answer was: " + answers[i] + "\n");
            }
        }

        System.out.println("\n📊 QUIZ COMPLETE!");
        System.out.println("You got " + score + "/" + questions.length + " correct!");
        
        if (score == questions.length) {
            System.out.println("🎉 PERFECT SCORE! You're a Java expert!");
        } else if (score >= questions.length / 2) {
            System.out.println("👍 Good job! Keep practicing!");
        } else {
            System.out.println("📚 Keep studying Java! You'll get better!");
        }
    }

    @Override
    public void showInstructions() {
        System.out.println("\n=== QUIZ GAME INSTRUCTIONS ===");
        System.out.println("• You'll be asked " + 5 + " Java questions");
        System.out.println("• Enter the number of your answer");
        System.out.println("• Each correct answer earns 2 points");
        System.out.println("• Try to get them all right!");
        System.out.println("===============================\n");
    }

    @Override
    public void endGame() {
        System.out.println("Thanks for playing the Quiz Game!");
    }
}