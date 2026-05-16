package ArcadeGameHub.member3_minigames;

import ArcadeGameHub.member1_core.Game;
import ArcadeGameHub.member2_system.InputHandler;
import ArcadeGameHub.member2_system.ScoreManager;
import ArcadeGameHub.member4_output.Display;

import java.util.ArrayList;
import java.util.Collections;

public class QuizGame extends Game {

    private InputHandler inputHandler;
    private ScoreManager scoreManager;
    private Display display;

    private static final String NEON_AMBER = "\u001B[38;5;220m";
    private static final String RESET = "\u001B[0m";

    public QuizGame(InputHandler inputHandler, ScoreManager scoreManager, Display display) {
        super("Quiz Game");
        this.inputHandler = inputHandler;
        this.scoreManager = scoreManager;
        this.display = display;
    }

    static class Question {
        String question;
        String[] options;
        String answer;
        int points;

        Question(String question, String[] options, String answer, int points) {
            this.question = question;
            this.options = options;
            this.answer = answer;
            this.points = points;
        }
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void printRoundHeader(String title) {
        System.out.println();
        System.out.print(NEON_AMBER);
        typeText("======================", 10);
        typeText(title, 25);
        typeText("======================", 10);
        System.out.print(RESET);
        System.out.println();
    }

    private void playRound(String title, ArrayList<Question> roundQuestions) {

        printRoundHeader(title);
        sleep(800);

        for (Question q : roundQuestions) {

            System.out.print(NEON_AMBER);
            typeText(q.question, 20);
            System.out.print(RESET);

            for (String option : q.options) {
                typeText(option, 15);
            }

            String userAnswer = inputHandler.getStringInputWithExit("Your answer: ")
                    .toUpperCase()
                    .trim();

            if (userAnswer.equals(q.answer)) {
                System.out.print(NEON_AMBER);
                typeText("Correct! +" + q.points + " points", 30);
                System.out.print(RESET);
                scoreManager.addPoints(q.points);
            } else {
                typeText("Wrong. Correct answer: " + q.answer, 30);
            }

            sleep(700);
            System.out.println();
        }
    }

    @Override
    public void play() {

        ArrayList<Question> easy = new ArrayList<>();
        ArrayList<Question> medium = new ArrayList<>();
        ArrayList<Question> hard = new ArrayList<>();
        ArrayList<Question> bonus = new ArrayList<>();

        easy.add(new Question("What is the capital city of Japan?",
                new String[]{"A. Tokyo", "B. Seoul", "C. Beijing", "D. Bangkok"}, "A", 1));

        easy.add(new Question("What is the largest planet in our solar system?",
                new String[]{"A. Earth", "B. Mars", "C. Jupiter", "D. Saturn"}, "C", 1));

        easy.add(new Question("What gas do humans need to breathe to survive?",
                new String[]{"A. Carbon Dioxide", "B. Oxygen", "C. Nitrogen", "D. Hydrogen"}, "B", 1));

        medium.add(new Question("What is the smallest ocean in the world?",
                new String[]{"A. Indian Ocean", "B. Atlantic Ocean", "C. Arctic Ocean", "D. Pacific Ocean"}, "C", 2));

        medium.add(new Question("In what continent is Egypt located?",
                new String[]{"A. Europe", "B. Africa", "C. Asia", "D. South America"}, "B", 2));

        medium.add(new Question("What is the square root of 64?",
                new String[]{"A. 6", "B. 7", "C. 8", "D. 9"}, "C", 2));

        hard.add(new Question("Who developed the theory of relativity?",
                new String[]{"A. Isaac Newton", "B. Galileo Galilei", "C. Albert Einstein", "D. Nikola Tesla"}, "C", 3));

        hard.add(new Question("What is the longest river in the world (commonly accepted)?",
                new String[]{"A. Amazon River", "B. Nile River", "C. Yangtze River", "D. Mississippi River"}, "B", 3));

        hard.add(new Question("What is the main language spoken in Brazil?",
                new String[]{"A. Spanish", "B. Portuguese", "C. French", "D. English"}, "B", 3));

        bonus.add(new Question("The more you take, the more you leave behind. What am I?",
                new String[]{"A. Memories", "B. Time", "C. Footsteps", "D. Air"}, "C", 7));

        Collections.shuffle(easy);
        Collections.shuffle(medium);
        Collections.shuffle(hard);

        sleep(1000);

        playRound("EASY ROUND (1 point each)", easy);
        playRound("MEDIUM ROUND (2 points each)", medium);
        playRound("HARD ROUND (3 points each)", hard);

        System.out.print(NEON_AMBER);
        typeText("\nBONUS ROUND UNLOCKED\n", 40);
        System.out.print(RESET);
        sleep(1000);

        playRound("BONUS ROUND (7 points)", bonus);

        int totalScore = scoreManager.getScore();

        System.out.print(NEON_AMBER);
        typeText("\nQUIZ COMPLETE", 30);
        System.out.print(RESET);
        
        typeText("Total Score: " + totalScore + " points", 30);

        sleep(500);

        if (totalScore >= 20) {
            typeText("Excellent! You're a quiz master!", 30);
        } else if (totalScore >= 10) {
            typeText("Good job! Keep improving!", 30);
        } else {
            typeText("Keep practicing! You'll get better!", 30);
        }
    }

    @Override
    public void showInstructions() {

        try {
    Thread.sleep(600);
    System.out.println(NEON_AMBER + "████▄     ▄█████▄ ▄▄ ▄▄ ▄▄ ▄▄▄▄▄    ▄████   ▄▄▄  ▄▄   ▄▄ ▄▄▄▄▄" + RESET);
    Thread.sleep(80);
    System.out.println(NEON_AMBER + " ▄▄██     ██ ▄ ██ ██ ██ ██   ▄█▀    ██  ▄▄▄██▀██ ██▀▄▀██ ██▄▄" + RESET);
    Thread.sleep(80);
    System.out.println(NEON_AMBER + "▄▄▄█▀ ▄   ▀█████▀ ▀███▀ ██ ▄██▄▄    ▀███▀  ██▀██ ██   ██ ██▄▄▄" + RESET);
    Thread.sleep(80);
    System.out.println(NEON_AMBER + "               ▀▀" + RESET);
    Thread.sleep(400);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}
        
        System.out.print(NEON_AMBER);
        typeText("\nWELCOME TO THE QUIZ GAME!", 30);
        typeText("Test your brain with questions and see how high you can score.", 25);
        typeText("\n======= POINT SCORING GUIDE =======", 15);
        System.out.print(RESET);
        
        typeText("\nEasy = 1 point", 20);
        typeText("Medium = 2 points", 20);
        typeText("Hard = 3 points", 20);
        typeText("Bonus = 7 points (Riddle)", 20);
        System.out.print(NEON_AMBER);
        typeText("\n==================================", 15);
        typeText("\nAnswer using A, B, C, or D", 20);
        System.out.print(RESET);
    }

    @Override
    public void endGame() {
        typeText("\nThanks for playing the Quiz Game!", 30);
    }
}