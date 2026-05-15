package ArcadeGameHub.member2_system;

public class ScoreManager {
    private int score;

    public ScoreManager() {
        this.score = 0;
    }

    public void addPoints(int points) {
        this.score += points;
        System.out.println("??? Points Added: +" + points);
    }

    public void resetScore() {
        this.score = 0;
        System.out.println("???? Score has been reset to 0");
    }


    public int getScore() {
        return score;
    }
}
