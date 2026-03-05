import java.util.*;

public class InputHandler{
    private Scanner scan;

    public InputHandler(){
        this.scan = new Scanner(System.in);
    }
    public int getIntIntput(String prompt){
        int input = -1;
        boolean isValid = false;

        while(isValid){
            System.out.print(prompt);
            try {
                input = scan.nextInt();
                scan.nextLine();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("PLEASE CHOOSE FROM 1 TO 3.");
                scan.nextLine();
            }
        }
        return input;
    }
    public String getStringInput(String prompt){
        System.out.println(prompt);
        return scan.nextLine();
    }
}