import java.util.ArrayList;
import java.util.Scanner;



public class Player extends Entity {
    private int hp;
    private int attack;

    public Player() {
        this.hp = 20;
        this.attack = 5;
    }

    public int getHP() {
        return hp;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println("Du tog " + damage + " skada! HP kvar: " + hp);
    }

    public int getAttack() {
        return attack;
    }

    public boolean isAlive() {
        return hp > 0;
    }
}




/*public class Player extends Entity {

    String playerName = name;

    ArrayList<Item> inventory = new ArrayList<Item>();

    public Player() {
        setUser();
    }

    public String getUsername() {
        return playerName;
    }

    public void setUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write username:");
        String input = scanner.nextLine();

        while (input.length() > 30 ||input == null || input.contains(" ")) {
            System.out.println("try again.");
            input = scanner.nextLine();
        }
        System.out.println("You succesfully created a username: " + input);
        playerName = input;
    }
    public void attack(){

    }
}*/