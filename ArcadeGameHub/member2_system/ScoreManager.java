package ArcadeGameHub.member2_system;

public class ScoreManager {
    private int score;

    public ScoreManager() {
        this.score = 0;
    }

    public void addPoints(int points) {
        this.score += points;
        System.out.println("\nPoints Added: +" + points);
    }

    public void resetScore() {
        this.score = 0;
        System.out.println("\nScore has been reset to 0");
    }

     
    public int getScore() {
        return score;
    }

     
    public int getPoints() {
        return score;
    }
}