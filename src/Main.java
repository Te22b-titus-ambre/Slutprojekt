import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Startpunkt för spelet. Hanterar all användarinteraktion med felkontroll.
public class Main {
    public static void main(String[] args) {
        // Skapar Scanner för användarinmatning
        Scanner sc = new Scanner(System.in);

        // Skapar dungeon med 5 rum
        Dungeon dungeon = new Dungeon(5);

        // Skapar spelaren med namnet "Hjälten"
        Player player = new Player("Hjälten");

        // Visar startinformation
        System.out.println("Dungeonen består av " + dungeon.size() + " rum.");
        System.out.println(player.getName() + " startar med "
                + player.getHp() + " HP och " + player.getAttack() + " attack.");

        // Går igenom varje rum i dungeonen så länge spelaren lever
        for (int idx = 0; idx < dungeon.size() && player.isAlive(); idx++) {
            Room room = dungeon.getRooms().get(idx);

            System.out.println();
            System.out.println("Du går in i rum " + idx
                    + " (Svårighetsgrad " + room.getDifficulty() + ")");
            System.out.println(room.getDescription());

            List<Monster> monsters = room.getMonsters();

            // Så länge det finns monster och spelaren är vid liv
            while (!monsters.isEmpty() && player.isAlive()) {
                Monster m = monsters.get(0);
                System.out.println();
                System.out.println("Ett " + m.getName()
                        + " dyker upp! (HP: " + m.getHp() + ")");

                int action = 0;
                // Inhämtar spelarens val med felhantering
                do {
                    try {
                        System.out.println("1=Attackera  2=Drick potion  3=Fly");
                        System.out.print("Välj: ");
                        action = sc.nextInt();
                        sc.nextLine(); // rensar input
                    } catch (InputMismatchException ex) {
                        System.out.println("Ogiltigt val, ange en siffra!");
                        sc.nextLine(); // rensar felaktig inmatning
                    }
                } while (action < 1 || action > 3);

                // Bearbetar spelarens val
                if (action == 1) {
                    m.takeDamage(player.getAttack()); // spelaren attackerar
                    if (!m.isAlive()) {
                        System.out.println("Monstret besegrat!");
                        monsters.remove(0); // ta bort besegrat monster
                    } else {
                        player.takeDamage(m.getAttack()); // monstret slår tillbaka
                    }
                } else if (action == 2) {
                    player.usePotion(); // spelaren använder potion
                } else {
                    System.out.println("Du flydde. Spelet avslutas.");
                    sc.close();
                    return;
                }
            }

            // Om spelaren överlevt rummet
            if (player.isAlive()) {
                System.out.println();
                System.out.println("Rummet är rensat!");
                room.dropLoot(); // släpp föremål
                room.getLoot().forEach(item -> System.out.println("- " + item));

                System.out.print("Plocka upp allt? (j/n): ");
                String pick = sc.nextLine();
                if (pick.equalsIgnoreCase("j")) {
                    room.getLoot().forEach(player::addItem); // plocka upp loot
                }
            }
        }

        // Spelets slut
        if (player.isAlive()) {
            System.out.println();
            System.out.println("Du klarade hela dungeonen!");
            player.showInventory(); // visa vad spelaren samlat
        } else {
            System.out.println();
            System.out.println("Du dog i dungeonen.");
        }

        sc.close(); // stäng input
    }
}
