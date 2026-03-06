package member2_system;

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
                System.out.println("❌ Invalid input. Please enter a number.");
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
                System.out.println("❌ Please enter a number between " + min + " and " + max + ".");
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
}