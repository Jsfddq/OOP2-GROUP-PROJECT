public interface TwoPlayerGame {
    void setPlayer2(String name);
    String getPlayer2();
    void switchTurn();
    String getCurrentPlayer();
    boolean isPlayer2Turn();
}

