import java.util.*;

class RPSGame{
    public void startRPSgame(InputHandler ih, ScoreManager sm){
        Scanner scan = new Scanner(System.in);
        Random ran = new Random();
        String options[] = {"Rock", "Paper", "Scissors"};
        int tryAgain = 0, round = 1;
        int playerC;
        do{
            System.out.println("---------- Rock Paper Scissors Game ----------");
            System.out.println("------------------------ Round " + round + " ------------------------");
            while(true){        
                try{
                    System.out.print("Enter 0 (Rock) || 1 (Paper) || 2 (Scissors): ");
                    playerC = scan.nextInt();
                    break;
                }catch(Exception e){
                    System.out.println("Invalid input. Please enter a number.");
                    scan.next();
                }
            }
            int compC = ran.nextInt(3);

            boolean validChoices = true;
            try {
                System.out.println("You chose " + options[playerC] + "!");
                System.out.println("Computer chose " + options[compC] + "!");
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input. Please enter a number between 0 and 2.");
                validChoices = false;
            }

            if (validChoices) {
                if (playerC == compC) {
                    System.out.println("It's a tie!");
                } else if ((playerC == 0 && compC == 2) ||
                           (playerC == 1 && compC == 0) || 
                           (playerC == 2 && compC == 1)) {
                    System.out.println("You win!");
                    sm.addPoints(5);
                } else {
                    System.out.println("Computer wins!");
                }
            }
            System.out.print("Do you want to try again? 1 (yes) / 0 (no): ");
            tryAgain = scan.nextInt();
            if(validChoices){
                round++;
            }
            System.out.println("------------------------------------------------");
            System.out.println();
            System.out.println();
        }while(tryAgain != 0);
        System.out.println("Thank you for playing!");
        scan.close();
    }
}
