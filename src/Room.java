import java.util.ArrayList;
import java.util.Random;

public class Room {
    public ArrayList<Monster> monsters = new ArrayList<>();
    public ArrayList<Item> roomItems = new ArrayList<>();
    String roomName;
    String description;
    int difficulty;

    private void setDifficulty() {
        int randomNum = (int)(Math.random() * 3) + 1; // 1 till 3
        difficulty = randomNum;
    }

    public void GenerateMonster() {
        int amountMonsters = (int)(Math.random() * 5) + 1; // 1 till 5 monster

        for (int i = 0; i < amountMonsters; i++) {
            int monsterType = (int)(Math.random() * 3); // 0 = Zombie, 1 = Skeleton, 2 = Spider

            switch (monsterType) {
                case 0:
                    monsters.add(new Zombie(difficulty));
                    break;
                case 1:
                    monsters.add(new Skeleton(difficulty));
                    break;
                case 2:
                    monsters.add(new Spider(difficulty));
                    break;
            }
        }
    }
    public void dropLoot() {
        // Slumpa 1-2 items
        int dropCount = (int)(Math.random() * 2) + 1;

        for (int i = 0; i < dropCount; i++) {
            if (Math.random() < 0.5) {
                roomItems.add(new Potion("Health Potion", 10));
            } else {
                roomItems.add(new Weapon("Iron Sword", 2));
            }
        }
        System.out.println("Rummet är rensat! Loot har droppats.");
    }




    public Room() {
        setDifficulty();
    }
}
