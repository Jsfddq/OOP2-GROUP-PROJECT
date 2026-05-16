package ArcadeGameHub.member2_system;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public int getIntInput(String prompt) {
        int input = -1;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);
            try {
                input = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input!Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        return input;
    }

    public int getIntInputInRange(String prompt, int min, int max) {
        int input;
        do {
            input = getIntInput(prompt);
            if (input < min || input > max) {
                System.out.println("\nPlease enter a number between " + min + " and " + max + ".");
            }
        } while (input < min || input > max);
        return input;
    }

    public String getStringInput(String prompt) {
        if (!prompt.isEmpty()) {
            System.out.print(prompt);
        }
        return scanner.nextLine();
    }

    public boolean isExitCommand(String input) {
        if (input == null) {
            return false;
        }
        String trimmed = input.trim().toLowerCase();
        return trimmed.equals("exit") || trimmed.equals("quit") || trimmed.equals("q");
    }

    public void checkForExit(String input) {
        if (isExitCommand(input)) {
            throw new GameExitException();
        }
    }

    public String getStringInputWithExit(String prompt) {
        if (!prompt.isEmpty()) {
            System.out.print(prompt);
        }
        String line = scanner.nextLine();
        checkForExit(line);
        return line;
    }

    public int getIntInputWithExit(String prompt) {
        int input = -1;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            checkForExit(line);
            try {
                input = Integer.parseInt(line);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input! Please enter a number or type 'exit' to leave.");
            }
        }
        return input;
    }

    public int getIntInputInRangeWithExit(String prompt, int min, int max) {
        int input;
        do {
            input = getIntInputWithExit(prompt);
            if (input < min || input > max) {
                System.out.println("\nPlease enter a number between " + min + " and " + max + ".");
            }
        } while (input < min || input > max);
        return input;
    }
}
