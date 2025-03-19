import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    String name;
    int health;
    ArrayList<Item> inventory = new ArrayList<Item>();

    public Player() {
        setUser();
    }

    public String getUsername() {
        return name;
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
        name = input;
    }
}