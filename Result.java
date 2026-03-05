package arcade;

public class Result {
    private String gameName;
    private String outcome;
    private int pointsEarned;
    private int attempts;
    
    public Result(String gameName, String outcome, int pointsEarned) {
        this.gameName = gameName;
        this.outcome = outcome;
        this.pointsEarned = pointsEarned;
        this.attempts = 0;
    }
    
    public Result(String gameName, String outcome, int pointsEarned, int attempts) {
        this.gameName = gameName;
        this.outcome = outcome;
        this.pointsEarned = pointsEarned;
        this.attempts = attempts;
    }
    
    public String getGameName() {
        return gameName;
    }
    
    public String getOutcome() {
        return outcome;
    }
    
    public int getPointsEarned() {
        return pointsEarned;
    }
    
    public int getAttempts() {
        return attempts;
    }
    
    public String getSummary() {
        if (attempts > 0) {
            return gameName + ": " + outcome + " (+" + pointsEarned + " points) in " + attempts + " attempts";
        }
        return gameName + ": " + outcome + " (+" + pointsEarned + " points)";
    }
}