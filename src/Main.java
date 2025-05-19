import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dungeon dungeon = new Dungeon(5); // 5 rum genereras
        Player player = new Player();
        boolean running = true;

        System.out.println("Dungeon med 5 rum genererades!");
        System.out.println("Du startar i rum 0.");

        while (running) {
            System.out.println("\n=== MENY ===");
            System.out.println("1. Visa rum du är i");
            System.out.println("2. Visa monster i nuvarande rum");
            System.out.println("3. Gå till nästa rum");
            System.out.println("4. Gå till föregående rum");
            System.out.println("5. Lista alla rum");
            System.out.println("6. Avsluta");
            System.out.println("7. Slåss mot första monstret i rummet");
            System.out.println("8. Visa items i rummet");
            System.out.print("Välj: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Du är i rum " + dungeon.getPlayerPosition());
                    break;

                case "2":
                    Room currentRoom = dungeon.getCurrentRoom();
                    if (currentRoom.monsters.isEmpty()) {
                        System.out.println("Inga monster här.");
                    } else {
                        System.out.println("Monster i rummet:");
                        for (Monster m : currentRoom.monsters) {
                            System.out.println("- " + m);
                        }
                    }
                    break;

                case "3":
                    dungeon.moveToNextRoom();
                    break;

                case "4":
                    dungeon.moveToPreviousRoom();
                    break;

                case "5":
                    dungeon.printAllRooms();
                    break;

                case "6":
                    System.out.println("Avslutar...");
                    running = false;
                    break;
                case "7":
                    Room fightRoom = dungeon.getCurrentRoom();
                    if (fightRoom.monsters.isEmpty()) {
                        System.out.println("Inga monster här!");
                    } else {
                        Monster monster = fightRoom.monsters.get(0);
                        System.out.println("Du börjar slåss mot en " + monster.getClass().getSimpleName());

                        while (player.isAlive() && monster.isAlive()) {
                            // Spelaren attackerar
                            monster.takeDamage(player.getAttack());

                            // Monster attackerar om det lever
                            if (monster.isAlive()) {
                                player.takeDamage(monster.getAttack());
                            }
                        }

                        if (!monster.isAlive()) {
                            System.out.println("Du besegrade " + monster.getClass().getSimpleName() + "!");
                            fightRoom.monsters.remove(monster);
                        } else {
                            System.out.println("Du dog... Spelet är över.");
                            running = false;
                        }
                        if (!monster.isAlive()) {
                            System.out.println("Du besegrade " + monster.getClass().getSimpleName() + "!");
                            fightRoom.monsters.remove(monster);

                            // Om rummet är klart – droppa loot
                            if (fightRoom.monsters.isEmpty() && fightRoom.roomItems.isEmpty()) {
                                fightRoom.dropLoot();
                            }
                        }

                    }
                    break;
                case "8":
                    Room itemRoom = dungeon.getCurrentRoom();
                    if (itemRoom.roomItems.isEmpty()) {
                        System.out.println("Det finns inga items i detta rum.");
                    } else {
                        System.out.println("Items i rummet:");
                        for (Item item : itemRoom.roomItems) {
                            System.out.println("- " + item);
                        }
                    }
                    break;
                default:
                    System.out.println("Ogiltigt val!");
            }
        }

        scanner.close();
    }
}
