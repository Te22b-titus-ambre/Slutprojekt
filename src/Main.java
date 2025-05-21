import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        // Exempelrum med några monster
        Room room = new Room();
        room.generateMonsters();

        Player player = new Player("Hjälten");
        System.out.println(player.getName() + " har " + player.getHp() + " HP och attack " + player.getAttack() + ".");
        System.out.println("Du går in i ett rum med svårighetsgrad " + room.getDifficulty() + " och "
                + room.getMonsters().size() + " monster.\n");

        List<Monster> monsters = room.getMonsters();
        while (!monsters.isEmpty() && player.isAlive()) {
            Monster m = monsters.get(0);
            System.out.println("Ett " + m + " dyker upp!");

            // Spelarens val
            int action = 0;
            do {
                try {
                    System.out.println("1=Attackera   2=Drick potion   3=Fly");
                    System.out.print("Välj: ");
                    action = sc.nextInt();
                    sc.nextLine();
                } catch (InputMismatchException ex) {
                    System.out.println("Ogiltigt val, ange en siffra!");
                    sc.nextLine();
                }
            } while (action < 1 || action > 3);

            if (action == 3) {
                System.out.println("Du flydde. Spelet avslutas.");
                sc.close();
                return;
            } else if (action == 2) {
                player.usePotion();
            } else {
                // spelaren attackerar
                System.out.println(player.getName() + " attackerar för " + player.getAttack() + " skada.");
                m.takeDamage(player.getAttack());
            }

            // Monsterets tur
            if (m.isAlive()) {
                if (rnd.nextDouble() < 0.3) {
                    m.specialAbility(player);
                } else {
                    m.attack(player);
                }
                if (!player.isAlive()) {
                    System.out.println(player.getName() + " dog. Spelet är över.");
                    sc.close();
                    return;
                }
            } else {
                System.out.println(m.getName() + " besegrad!\n");
                monsters.remove(0);
            }
        }

        // Rensat rum + loot
        System.out.println("Rummet är rensat!");
        room.dropLoot();
        room.getLoot().forEach(item -> System.out.println("- " + item));
        System.out.print("Vill du plocka upp allt? (j/n): ");
        String pick = sc.nextLine();
        if (pick.equalsIgnoreCase("j")) {
            room.getLoot().forEach(player::addItem);
        }

        System.out.println("\nÄventyret är slut. Slutstatus:");
        player.showInventory();
        sc.close();
    }
}