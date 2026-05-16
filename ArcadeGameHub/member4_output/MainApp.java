package ArcadeGameHub.member4_output;

import ArcadeGameHub.member1_core.Player;
import ArcadeGameHub.member2_system.GameManager;
import ArcadeGameHub.member2_system.InputHandler;

public class MainApp {

    static final String RESET       = "\u001B[0m";
    static final String NEON_RED    = "\u001B[38;5;196m";
    static final String NEON_PURPLE = "\u001B[38;5;135m";

    private static String repeat(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        InputHandler inputHandler = new InputHandler();

        
        System.out.println();
        System.out.println(NEON_RED + "  === READY PLAYER ONE ===" + RESET);
        System.out.println();

        
        System.out.print(NEON_RED + "  ENTER NAME: " + RESET);
        String playerName = inputHandler.getStringInput("");
        Player player = new Player(playerName);

        System.out.println();
        System.out.println(NEON_RED + "  LET'S HAVE SOME FUN AT..." + RESET);
        System.out.println();
        Thread.sleep(600);

        
        System.out.println(NEON_PURPLE + " ███████████ █████                    █████████                                    █████               █████████                                        █████   █████            █████    " + RESET);
        Thread.sleep(80);
        System.out.println(NEON_PURPLE + "░█░░░███░░░█░░███                    ███░░░░░███                                  ░░███               ███░░░░░███                                      ░░███   ░░███            ░░███     " + RESET);
        Thread.sleep(80);
        System.out.println(NEON_PURPLE + "░   ░███  ░  ░███████    ██████     ░███    ░███  ████████   ██████   ██████    ███████   ██████     ███     ░░░   ██████   █████████████    ██████     ░███    ░███  █████ ████ ░███████ " + RESET);
        Thread.sleep(80);
        System.out.println(NEON_PURPLE + "    ░███     ░███░░███  ███░░███    ░███████████ ░░███░░███ ███░░███ ░░░░░███  ███░░███  ███░░███   ░███          ░░░░░███ ░░███░░███░░███  ███░░███    ░███████████ ░░███ ░███  ░███░░███" + RESET);
        Thread.sleep(80);
        System.out.println(NEON_PURPLE + "    ░███     ░███ ░███ ░███████     ░███░░░░░███  ░███ ░░░ ░███ ░░░   ███████ ░███ ░███ ░███████    ░███    █████  ███████  ░███ ░███ ░███ ░███████     ░███░░░░░███  ░███ ░███  ░███ ░███" + RESET);
        Thread.sleep(80);
        System.out.println(NEON_PURPLE + "    ░███     ░███ ░███ ░███░░░      ░███    ░███  ░███     ░███  ███ ███░░███ ░███ ░███ ░███░░░     ░░███  ░░███  ███░░███  ░███ ░███ ░███ ░███░░░      ░███    ░███  ░███ ░███  ░███ ░███" + RESET);
        Thread.sleep(80);
        System.out.println(NEON_PURPLE + "    █████    ████ █████░░██████     █████   █████ █████    ░░██████ ░░████████░░████████░░██████     ░░█████████ ░░████████ █████░███ █████░░██████     █████   █████ ░░████████ ████████ " + RESET);
        Thread.sleep(80);
        System.out.println(NEON_PURPLE + "   ░░░░░    ░░░░ ░░░░░  ░░░░░░     ░░░░░   ░░░░░ ░░░░░      ░░░░░░   ░░░░░░░░  ░░░░░░░░  ░░░░░░       ░░░░░░░░░   ░░░░░░░░ ░░░░░ ░░░ ░░░░░  ░░░░░░     ░░░░░   ░░░░░   ░░░░░░░░ ░░░░░░░░" + RESET);

        System.out.println();
        Thread.sleep(400);

         
        String challenger = "  CHALLENGER [ " + playerName.toUpperCase() + " ]";
        String score      = "Current Score: 0  ";
        int totalWidth    = 80;
        int spaces        = totalWidth - challenger.length() - score.length();
        if (spaces < 1) spaces = 4;

        System.out.println(NEON_RED + "  " + repeat("=", totalWidth) + RESET);
        System.out.println(NEON_RED + challenger + repeat(" ", spaces) + score + RESET);
        System.out.println(NEON_RED + "  " + repeat("=", totalWidth) + RESET);
        System.out.println();

         
        GameManager gameManager = new GameManager(player);
        gameManager.start();
    }
}