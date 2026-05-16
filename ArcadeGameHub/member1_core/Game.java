package ArcadeGameHub.member1_core;

import ArcadeGameHub.member2_system.GameExitException;

public abstract class Game implements Playable {

    protected String gameName;
    private boolean exitedEarly;

    protected static final String NEON_RED = "\u001B[38;5;196m"; 
    protected static final String RESET = "\u001B[0m";

    public Game(String gameName) {
        this.gameName = gameName;
    }

    protected void typeText(String text, int delayMs) {
        try {
            for (char c : text.toCharArray()) {
                System.out.print(c);
                Thread.sleep(delayMs);
            }
            System.out.println();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void startGame() {
        System.out.println("\n\n");
        
        System.out.print(NEON_RED); 
        typeText("Starting " + gameName + "...", 50);
        System.out.print(RESET);
        
        System.out.println("\n\n");

        showInstructions();
        showExitHint(); 

        System.out.println("\n");

        exitedEarly = false;

        try {
            play();
        } catch (GameExitException e) {
            exitedEarly = true;
            System.out.print(NEON_RED);
            typeText("\nLeaving " + gameName + "... Returning to main menu.", 50);
            System.out.print(RESET);
            return;
        }

        if (!exitedEarly) {
            endGame();
            endSequence();
        }
    }

    private void endSequence() {
        System.out.println();
        System.out.print(NEON_RED);
        typeText("Game finished!", 50);
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        typeText("Leaving " + gameName + "... Returning to main menu.", 50);
        System.out.print(RESET);
    }

    protected void showExitHint() {
        System.out.print(NEON_RED);
        typeText("\nTip: Type 'exit' at any prompt to return to the main menu.\n", 40);
        System.out.print(RESET);
    }

    public String getGameName() {
        return gameName;
    }

    public boolean wasExitedEarly() {
        return exitedEarly;
    }

    public abstract void showInstructions();

    public abstract void endGame();
}