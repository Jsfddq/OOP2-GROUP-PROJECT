
import java.util.*;

// TESTING
/*
public class FightingGame {
    public static void main(String[] args) {
        Combat cmb = new Combat();
        cmb.combatSystem();
    }
}*/

abstract class Character {
    protected int hp;
    protected int mp;
    
    public void setHP(int hp) { this.hp = Math.max(0, hp); }
    public int getHP() { return this.hp; }
    
    public void setMP(int mp) { this.mp = mp; }
    public int getMP() { return this.mp; }
    
    public abstract void message();
    public abstract void atkMessage();
    public abstract void receiveDmgMessage();
}

class Player extends Character {
    public void message() {
        System.out.println(">>> You died! Game Over.");
    }
    public void atkMessage() {
        System.out.println(">>> You struck the enemy!");
    }
    public void receiveDmgMessage() {
        System.out.println(">>> You have received damage");
    }
}

class Enemy extends Character {
    public void message() {
        System.out.println(">>> The enemy has been defeated! Victory!");
    }
    public void atkMessage() {
        System.out.println(">>> The enemy swings wildly at you!");
    }
    public void receiveDmgMessage() {
        System.out.println(">>> The enemy howls in pain!");
    }
}

class Combat {
    Scanner scan = new Scanner(System.in);
    Player plyr = new Player();
    Enemy nme = new Enemy();
    
    public void combatSystem() {
        System.out.println("Make your own character!");
        System.out.print("Set HP: ");
        plyr.setHP(scan.nextInt());
        System.out.print("Set MP: ");
        plyr.setMP(scan.nextInt());
        
        System.out.println("\nCreate your own enemy!");
        System.out.print("Set HP: ");
        nme.setHP(scan.nextInt());
        System.out.print("Set MP: ");
        nme.setMP(scan.nextInt());

        while (plyr.getHP() > 0 && nme.getHP() > 0) {
            System.out.println("\n----------------------------------------");
            System.out.println("Player HP: " + plyr.getHP() + "\tEnemy HP: " + nme.getHP());
            System.out.println("Player MP: " + plyr.getMP() + "\tEnemy MP: " + nme.getMP());
            System.out.println("----------------------------------------");
            System.out.println("Select an action!");
            System.out.println("1. Auto Attack");
            System.out.println("2. Run");
            System.out.print("> ");
            int action = scan.nextInt();
            
            if (action == 1) {
                plyr.atkMessage(); 
                nme.setHP(nme.getHP() - 10);
                nme.receiveDmgMessage(); 
                
                if (nme.getHP() > 0) {
                    System.out.println();
                    nme.atkMessage(); 
                    plyr.setHP(plyr.getHP() - 5);
                    plyr.receiveDmgMessage(); 
                }
            }
            else if (action == 2) {
                System.out.println("You ran away!");
                return; 
            }
        }
        
        System.out.println("\n--- BATTLE END ---");
        if (plyr.getHP() <= 0) plyr.message();
        else nme.message();
    }
}