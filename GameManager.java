import java.util.*;

public class GameManager{
    private Scanner scan;
    private boolean isRunning;
    private String selectedGame;
    private InputHandler ih = new InputHandler();
    private ScoreManager sm = new ScnoreManager();

    public GameManager(){
        this.scan = new Scanner(System.in);
        this.isRunning = true;
        this.selectedGame = "";
    }
    public void displayMenu(){
        System.out.println("\n-----Game Menu-----\n");
        System.out.println("1.) Guess Game");
        System.out.println("2.) Quiz Game");
        System.out.println("3.) Rock Paper Scissors Game");
        System.out.println("4.) View Scores");
        System.out.println("3.) Restart Scores");
        System.out.println("4.) Exit");
    }
    public void selectGame(){
        IntputHandler ih = new InputHandler();



        int choice = scan.nextInt();

        switch (choice){
            case 1:
                selectedGame = "Guess Game";
                runGame();
                break;
            case 2:
                selectedGame = "Quiz Game";
                runGame();
                break;
            case 3:
                selectedGame = "Rock Paper Game";
                runGame();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    public void runGame(){
        System.out.println("\nSelect an Option: " + selectedGame + "...");

        if(selectedGame.equals("Guess Game")){
            GuessGame gm = new GuessGame();

            gm.guessNumber(this.ih, this.sm);
        }else if(selectedGame.equals("Quiz Game")){
            QuizGame qm = new QuizGame();
            qm.startQuiz(this.ih, this.sm);
        }else if(selectedGame.equals("Rock Paper Scissors Game")){
            RPSGame rps = new RPSGame();
            rps.startRPSgame(this.ih, this.sm);
        }else if(choice == 4){
            this.sm.showScore();
        }else if(choice == 5){
            this.sm.resetScore();
        }
    }

    public void start(){
        while(isRunning){
            displayMenu();
            selectGame();
        }
    }
}