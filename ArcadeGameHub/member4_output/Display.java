package ArcadeGameHub.member4_output;

public class Display {

    static final String RESET     = "\u001B[0m";
    static final String NEON_LIME = "\u001B[38;5;118m";
    static final String NEON_AMBER= "\u001B[38;5;220m";
    static final String NEON_CYAN = "\u001B[38;5;51m";
    static final String BOLD      = "\u001B[1m";

    private void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    private void printDelayed(String text, long delayMs) {
        System.out.println(text);
        sleep(delayMs);
    }

    private void typewriter(String text, long charDelayMs) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            sleep(charDelayMs);
        }
        System.out.println();
    }

   
    private String blanks(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) sb.append(' ');
        return sb.toString();
    }

    private void flashLine(String text, int flashes, long flashDelayMs) throws InterruptedException {
        int visibleLength = text.replaceAll("\u001B\\[[;\\d]*m", "").length();
        for (int i = 0; i < flashes; i++) {
            System.out.print("\r" + text);
            Thread.sleep(flashDelayMs);
            System.out.print("\r" + blanks(visibleLength));
            Thread.sleep(flashDelayMs);
        }
        System.out.println(text);
    }

    public void showGoodbye(String playerName, int finalScore) {
        try {
            System.out.println();
            sleep(300);

             
            printDelayed(NEON_AMBER + "▄▄ " + RESET, 80);
            printDelayed(NEON_AMBER + "██████ ▄▄ ▄▄  ▄▄▄  ▄▄  ▄▄ ▄▄ ▄▄   ██  ██ ▄▄▄  ▄▄ ▄▄   ██████ ▄▄▄  ▄▄▄▄    █████▄ ▄▄     ▄▄▄  ▄▄ ▄▄ ▄▄ ▄▄  ▄▄  ▄▄▄▄  ██ " + RESET, 60);
            printDelayed(NEON_AMBER + "  ██   ██▄██ ██▀██ ███▄██ ██▄█▀    ▀██▀ ██▀██ ██ ██   ██▄▄  ██▀██ ██▄█▄   ██▄▄█▀ ██    ██▀██ ▀███▀ ██ ███▄██ ██ ▄▄  ██ " + RESET, 60);
            printDelayed(NEON_AMBER + "  ██   ██ ██ ██▀██ ██ ▀██ ██ ██     ██  ▀███▀ ▀███▀   ██    ▀███▀ ██ ██   ██     ██▄▄▄ ██▀██   █   ██ ██ ▀██ ▀███▀  ▄▄ " + RESET, 80);

            System.out.println();
            sleep(200);

            printDelayed(NEON_AMBER + "                                                                                               ▄▄                      " + RESET, 60);
            printDelayed(NEON_AMBER + "▄█████ ▄▄▄▄▄ ▄▄▄▄▄   ██  ██ ▄▄▄  ▄▄ ▄▄   ███  ██ ▄▄▄▄▄ ▄▄ ▄▄ ▄▄▄▄▄▄   ██████ ▄▄ ▄▄   ▄▄ ▄▄▄▄▄  ██                      " + RESET, 60);
            printDelayed(NEON_AMBER + "▀▀▀▄▄▄ ██▄▄  ██▄▄     ▀██▀ ██▀██ ██ ██   ██ ▀▄██ ██▄▄  ▀█▄█▀   ██       ██   ██ ██▀▄▀██ ██▄▄   ██                      " + RESET, 60);
            printDelayed(NEON_AMBER + "█████▀ ██▄▄▄ ██▄▄▄     ██  ▀███▀ ▀███▀   ██   ██ ██▄▄▄ ██ ██   ██       ██   ██ ██   ██ ██▄▄▄  ▄▄                      " + RESET, 120);

            System.out.println();
            sleep(400);

             
            System.out.print(NEON_LIME + "  Loading your final score");
            for (int i = 0; i < 6; i++) {
                sleep(300);
                System.out.print(".");
            }
            System.out.println(RESET);
            sleep(300);

            System.out.println();
            System.out.println();
            String scoreLine = BOLD + NEON_LIME + "  !!!  FINAL SCORE FOR [ " + playerName.toUpperCase() + " ]: " + finalScore + " POINTS   !!!  " + RESET;
            flashLine(scoreLine, 3, 180);

            System.out.println();
            sleep(200);

             
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}