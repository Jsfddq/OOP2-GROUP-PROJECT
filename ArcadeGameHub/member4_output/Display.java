package ArcadeGameHub.member4_output;

public class Display {

    static final String RESET       = "\u001B[0m";
    static final String NEON_LIME   = "\u001B[38;5;118m";
    static final String NEON_AMBER  = "\u001B[38;5;220m";

    public void showGoodbye(String playerName, int finalScore) {
        System.out.println();
        System.out.println(NEON_AMBER + "▄▄ " + RESET);
        System.out.println(NEON_AMBER + "██████ ▄▄ ▄▄  ▄▄▄  ▄▄  ▄▄ ▄▄ ▄▄   ██  ██ ▄▄▄  ▄▄ ▄▄   ██████ ▄▄▄  ▄▄▄▄    █████▄ ▄▄     ▄▄▄  ▄▄ ▄▄ ▄▄ ▄▄  ▄▄  ▄▄▄▄  ██ " + RESET);
        System.out.println(NEON_AMBER + "  ██   ██▄██ ██▀██ ███▄██ ██▄█▀    ▀██▀ ██▀██ ██ ██   ██▄▄  ██▀██ ██▄█▄   ██▄▄█▀ ██    ██▀██ ▀███▀ ██ ███▄██ ██ ▄▄  ██ " + RESET);
        System.out.println(NEON_AMBER + "  ██   ██ ██ ██▀██ ██ ▀██ ██ ██     ██  ▀███▀ ▀███▀   ██    ▀███▀ ██ ██   ██     ██▄▄▄ ██▀██   █   ██ ██ ▀██ ▀███▀  ▄▄ " + RESET);
        System.out.println();
        System.out.println(NEON_AMBER + "                                                                                               ▄▄                      " + RESET);
        System.out.println(NEON_AMBER + "▄█████ ▄▄▄▄▄ ▄▄▄▄▄   ██  ██ ▄▄▄  ▄▄ ▄▄   ███  ██ ▄▄▄▄▄ ▄▄ ▄▄ ▄▄▄▄▄▄   ██████ ▄▄ ▄▄   ▄▄ ▄▄▄▄▄  ██                      " + RESET);
        System.out.println(NEON_AMBER + "▀▀▀▄▄▄ ██▄▄  ██▄▄     ▀██▀ ██▀██ ██ ██   ██ ▀▄██ ██▄▄  ▀█▄█▀   ██       ██   ██ ██▀▄▀██ ██▄▄   ██                      " + RESET);
        System.out.println(NEON_AMBER + "█████▀ ██▄▄▄ ██▄▄▄     ██  ▀███▀ ▀███▀   ██   ██ ██▄▄▄ ██ ██   ██       ██   ██ ██   ██ ██▄▄▄  ▄▄                      " + RESET);
        System.out.println();
        System.out.println();
        System.out.println(NEON_LIME+ "  FINAL SCORE FOR [ " + playerName.toUpperCase() + " ]: " + finalScore + " POINTS" + RESET);
        System.out.println();
    }
}