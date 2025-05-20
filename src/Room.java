import java.util.ArrayList;

public class Room {
    public ArrayList<Monster> monsters = new ArrayList<>();
    public ArrayList<Item> roomItems = new ArrayList<>();
    public String roomName;
    public String description;
    public int difficulty;

    public Room() {
        setDifficulty();
        this.roomName = "Rum (lvl " + difficulty + ")";
        this.description = "Ett rum av svårighetsgrad " + difficulty + ".";
    }

    private void setDifficulty() {
        difficulty = (int)(Math.random() * 3) + 1; // 1–3
    }

    public void GenerateMonster() {
        int amountMonsters = (int)(Math.random() * 5) + 1; // 1–5
        for (int i = 0; i < amountMonsters; i++) {
            int monsterType = (int)(Math.random() * 3);
            switch (monsterType) {
                case 0: monsters.add(new Zombie(difficulty));
                break;
                case 1: monsters.add(new Skeleton(difficulty));
                break;
                case 2: monsters.add(new Spider(difficulty));
                break;
            }
        }
    }

    public void dropLoot() {
        int dropCount = (int)(Math.random() * 2) + 1; // 1–2 items
        for (int i = 0; i < dropCount; i++) {
            if (Math.random() < 0.5) {
                roomItems.add(new Potion("Health Potion", 10));
            } else {
                roomItems.add(new Weapon("Iron Sword", 2));
            }
        }
        System.out.println("Rummet är rensat! Loot har droppats.");
    }

    public void printLoot() {
        System.out.println("Loot i rummet:");
        for (Item item : roomItems) {
            System.out.println("- " + item);
        }
    }
}