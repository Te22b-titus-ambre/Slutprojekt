import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Startpunkt för spelet. Hanterar all användarinteraktion med felkontroll.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dungeon dungeon = new Dungeon(5);
        Player player = new Player("Hjälten");

        System.out.println("Dungeonen består av " + dungeon.size() + " rum.");
        System.out.println(player.getName() + " startar med "
                + player.getHp() + " HP och " + player.getAttack() + " attack.");

        for (int idx = 0; idx < dungeon.size() && player.isAlive(); idx++) {
            Room room = dungeon.getRooms().get(idx);
            System.out.println();
            System.out.println("Du går in i rum " + idx
                    + " (Svårighetsgrad " + room.getDifficulty() + ")");
            System.out.println(room.getDescription());

            List<Monster> monsters = room.getMonsters();
            while (!monsters.isEmpty() && player.isAlive()) {
                Monster m = monsters.get(0);
                System.out.println();
                System.out.println("Ett " + m.getName()
                        + " dyker upp! (HP: " + m.getHp() + ")");

                int action = 0;
                do {
                    try {
                        System.out.println("1=Attackera  2=Drick potion  3=Fly");
                        System.out.print("Välj: ");
                        action = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException ex) {
                        System.out.println("Ogiltigt val, ange en siffra!");
                        sc.nextLine();
                    }
                } while (action < 1 || action > 3);

                if (action == 1) {
                    m.takeDamage(player.getAttack());
                    if (!m.isAlive()) {
                        System.out.println("Monstret besegrat!");
                        monsters.remove(0);
                    } else {
                        player.takeDamage(m.getAttack());
                    }
                } else if (action == 2) {
                    player.usePotion();
                } else {
                    System.out.println("Du flydde. Spelet avslutas.");
                    sc.close();
                    return;
                }
            }

            if (player.isAlive()) {
                System.out.println();
                System.out.println("Rummet är rensat!");
                room.dropLoot();
                room.getLoot().forEach(item -> System.out.println("- " + item));
                System.out.print("Plocka upp allt? (j/n): ");
                String pick = sc.nextLine();
                if (pick.equalsIgnoreCase("j")) {
                    room.getLoot().forEach(player::addItem);
                }
            }
        }

        if (player.isAlive()) {
            System.out.println();
            System.out.println("Du klarade hela dungeonen!");
            player.showInventory();
        } else {
            System.out.println();
            System.out.println("Du dog i dungeonen.");
        }
        sc.close();
    }
}