import java.util.ArrayList;
import java.util.List;

public class Room {
    public List<Entity> entities = new ArrayList<>();
    public List<Item> roomItems = new ArrayList<>();
    public String description;
    public int difficulty;

    public Room() {
        difficulty = (int)(Math.random() * 3) + 1;
        this.description = "Ett rum av svårighetsgrad " + difficulty + ".";
        generateEntities();
    }

    public void generateEntities() {
        int count = (int)(Math.random() * 5) + 1;
        for (int i = 0; i < count; i++) {
            int type = (int)(Math.random() * 3);
            switch (type) {
                case 0: entities.add(new Zombie(difficulty)); break;
                case 1: entities.add(new Skeleton(difficulty)); break;
                case 2: entities.add(new Spider(difficulty)); break;
            }
        }
    }

    public void dropLoot() {
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

    public void printLoot() {
        System.out.println("🎁 Loot i rummet:");
        for (Item item : roomItems) {
            System.out.println("- " + item);
        }
    }
}