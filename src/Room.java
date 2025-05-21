import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Rum i dungeonen. Har samlingar av Monster och Item (komposition).
public class Room {
    private List<Monster> monsters = new ArrayList<>();
    private List<Item> loot = new ArrayList<>();
    private int difficulty;
    private String description;

    public Room() {
        this.difficulty = new Random().nextInt(3) + 1; // 1–3
        this.description = "Ett rum av svårighetsgrad " + difficulty;
    }

    // Genererar 1–5 monster med slumpad typ och tier
    public void generateMonsters() {
        int count = new Random().nextInt(5) + 1;
        for (int i = 0; i < count; i++) {
            int type = new Random().nextInt(3);
            int tier = Monster.randomTier();
            if (type == 0) {
                monsters.add(new Zombie(tier));
            } else if (type == 1) {
                monsters.add(new Skeleton(tier));
            } else {
                monsters.add(new Spider(tier));
            }
        }
    }

    // Släpper loot (1–2 items) efter rummet är rensat
    public void dropLoot() {
        int count = new Random().nextInt(2) + 1;
        for (int i = 0; i < count; i++) {
            if (new Random().nextBoolean()) {
                loot.add(new Potion("Health Potion", 10));
            } else {
                loot.add(new Weapon("Iron Sword", 2));
            }
        }
        System.out.println("Rummet är rensat! Loot har droppats.");
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public List<Item> getLoot() {
        return loot;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getDescription() {
        return description;
    }
}