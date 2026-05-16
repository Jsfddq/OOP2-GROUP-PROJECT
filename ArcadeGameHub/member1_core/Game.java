package ArcadeGameHub.member1_core;

import ArcadeGameHub.member2_system.GameExitException;

public abstract class Game implements Playable {
    protected String gameName;
    private boolean exitedEarly;

    public Game(String gameName) {
        this.gameName = gameName;
    }

    public void startGame() {
        System.out.println("Starting " + gameName + "...");
        showInstructions();
        showExitHint();
        exitedEarly = false;
        try {
            play();
        } catch (GameExitException e) {
            exitedEarly = true;
            System.out.println("\nLeaving " + gameName + "... Returning to main menu.");
        }
        if (!exitedEarly) {
            endGame();
        }
    }

    public boolean wasExitedEarly() {
        return exitedEarly;
    }

    protected void showExitHint() {
        System.out.println("Tip: Type 'exit' at any prompt to return to the main menu.\n");
    }

    public String getGameName() {
        return gameName;
    }

    public abstract void endGame();
}
