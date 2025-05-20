import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dungeon dungeon = new Dungeon(5);
        Player player = new Player();

        System.out.println("Äventyret börjar! Du har " +
                player.getHP() + " HP och attack " +
                player.getAttack() + ".");
        System.out.println("Du går in i en dungeon med " +
                dungeon.getRoomCount() + " rum...\n");

        for (int i = 0; i < dungeon.getRoomCount(); i++) {
            Room room = dungeon.getRoom(i);
            System.out.println("Du går in i rum " + i +
                    " (Svårighetsgrad: " + room.difficulty + ")");
            System.out.println(room.description);

            System.out.println("\nVad vill du göra?");
            System.out.println("1. Gå till attack mot monster");
            System.out.println("2. Drick potion (om du har någon)");
            System.out.println("3. Fly från dungeonen");
            System.out.print("Ditt val: ");
            String choice = scanner.nextLine();

            if (choice.equals("3")) {
                System.out.println("Du valde att fly. Äventyret avslutas.");
                scanner.close();
                return;
            } else if (choice.equals("2")) {
                if (player.hasPotion()) {
                    player.usePotion();
                } else {
                    System.out.println("Ingen potion i inventariet!");
                }
            }

            while (!room.entities.isEmpty() && player.isAlive()) {
                Entity entity = room.entities.get(0);
                System.out.println("\n Ett " +
                        entity.getClass().getSimpleName() +
                        " dyker upp! (HP: " + entity.getHP() + ")");

                System.out.println("Välj handling:");
                System.out.println("1. Attackera");
                System.out.println("2. Drick potion");
                System.out.println("3. Fly");
                System.out.print("Ditt val: ");
                String action = scanner.nextLine();

                if (action.equals("3")) {
                    System.out.println("Du flydde från striden! Spelet avslutas.");
                    scanner.close();
                    return;
                } else if (action.equals("2")) {
                    if (player.hasPotion()) {
                        player.usePotion();
                        continue;
                    } else {
                        System.out.println("Ingen potion kvar!");
                        continue;
                    }
                }

                player.attack(entity);

                if (entity.isAlive()) {
                    entity.attack(player);
                }

                if (!entity.isAlive()) {
                    System.out.println("✅ Du besegrade " +
                            entity.getClass().getSimpleName() + "!");
                    room.entities.remove(entity);
                }
                if (!player.isAlive()) {
                    System.out.println("Du dog! Spelet är över.");
                    scanner.close();
                    return;
                }
            }

            if (room.entities.isEmpty()) {
                System.out.println("\nDu rensade rummet!");
                room.dropLoot();
                room.printLoot();

                System.out.print("Vill du plocka upp allt? (j/n): ");
                String lootChoice = scanner.nextLine();
                if (lootChoice.equalsIgnoreCase("j")) {
                    for (Item item : room.roomItems) {
                        player.addItem(item);
                    }
                    room.roomItems.clear();
                }
            }

            System.out.println("\n----- Du går vidare till nästa rum -----\n");
        }

        System.out.println(" Du klarade dungeonen! Grattis!");
        scanner.close();
    }
}
