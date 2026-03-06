public abstract class Game implements Playable {
    protected String gameName;

    public Game(String gameName) {
        this.gameName = gameName;
    }

    public void startGame() {
        System.out.println("Starting " + gameName + "...");
        showInstructions();
        play();
        endGame();
    }

    public String getGameName() {
        return gameName;
    }

    public abstract void endGame();
}