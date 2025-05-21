import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        // Skapa dungeon med t.ex. 3 rum
        Dungeon dungeon = new Dungeon(3);
        Player player = new Player("Hjälten");

        System.out.println("🏰 Du går in i en dungeon med " + dungeon.size() + " rum.");
        System.out.println(player.getName() + " startar med "
                + player.getHp() + " HP och " + player.getAttack() + " attack.\n");

        // Loop över alla rum
        for (int idx = 0; idx < dungeon.size(); idx++) {
            Room room = dungeon.getRooms().get(idx);

            System.out.println("➡️  Rum " + (idx+1) + " av " + dungeon.size()
                    + " (Svårighetsgrad " + room.getDifficulty() + ")");
            System.out.println(room.getDescription() + "\n");

            // Generera och möt monstren
            List<Monster> monsters = room.getMonsters();
            while (!monsters.isEmpty() && player.isAlive()) {
                Monster m = monsters.get(0);
                System.out.println("👾 Ett " + m + " dyker upp!");

                // Spelarval
                int action = 0;
                do {
                    try {
                        System.out.println("1 = Attackera   2 = Drick potion   3 = Fly");
                        System.out.print("Välj: ");
                        action = sc.nextInt();
                        sc.nextLine(); // konsumera radslut
                    } catch (InputMismatchException e) {
                        System.out.println("Ogiltigt val, ange en siffra!");
                        sc.nextLine();
                    }
                } while (action < 1 || action > 3);

                // Hantera valet
                if (action == 3) {
                    System.out.println("🏃 Du flydde från rummet! Spelet är över.");
                    sc.close();
                    return;
                }
                if (action == 2) {
                    player.usePotion();
                } else {
                    // vanlig attack
                    System.out.println(player.getName() + " attackerar för "
                            + player.getAttack() + " skada.");
                    m.takeDamage(player.getAttack());
                }

                // Monster svarar om det lever
                if (m.isAlive()) {
                    if (rnd.nextDouble() < 0.3) {
                        m.specialAbility(player);
                    } else {
                        m.attack(player);
                    }
                    if (!player.isAlive()) {
                        System.out.println("\n💀 Du dog i striden! Spelet är över.");
                        sc.close();
                        return;
                    }
                } else {
                    System.out.println("✅ " + m.getName() + " besegrad!\n");
                    monsters.remove(0);
                }
            }

            // När rummet är rensat
            System.out.println("✨ Du rensade rum " + (idx+1) + "!\n");
            room.dropLoot();
            List<Item> loot = room.getLoot();
            for (int i = 0; i < loot.size(); i++) {
                System.out.println((i+1) + ". " + loot.get(i));
            }

            // Fråga om plocka upp
            System.out.print("\nVill du plocka upp allt? (j/n): ");
            String pick = sc.nextLine().trim();
            if (pick.equalsIgnoreCase("j")) {
                loot.forEach(player::addItem);
                loot.clear();
            }
            System.out.println(); // tom rad innan nästa rum
        }

        // Slut på dungeonen
        System.out.println("🏆 Du klarade hela dungeonen!");
        player.showInventory();
        sc.close();
    }
}