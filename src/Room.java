import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Rum i dungeonen. Innehåller monster och föremål (loot).
public class Room {
    private List<Monster> monsters = new ArrayList<>(); // Lista över monster i rummet
    private List<Item> loot = new ArrayList<>();         // Lista över föremål i rummet
    private int difficulty;                              // Svårighetsgrad (1–3)
    private String description;                          // Beskrivning av rummet

    // Konstruktor – skapar rummet med slumpmässig svårighetsgrad
    public Room() {
        this.difficulty = new Random().nextInt(3) + 1; // Svårighetsgrad mellan 1 och 3
        this.description = "Ett rum av svårighetsgrad " + difficulty;
    }

    // Genererar 1–5 monster med slumpad typ (Zombie, Skeleton, Spider) och tier
    public void generateMonsters() {
        int count = new Random().nextInt(5) + 1; // 1 till 5 monster
        for (int i = 0; i < count; i++) {
            int type = new Random().nextInt(3);      // 0, 1 eller 2
            int tier = Monster.randomTier();         // tier mellan 1 och 3
            if (type == 0) {
                monsters.add(new Zombie(tier));
            } else if (type == 1) {
                monsters.add(new Skeleton(tier));
            } else {
                monsters.add(new Spider(tier));
            }
        }
    }

    // Genererar loot (1–2 items) när rummet rensas – potioner eller vapen
    public void dropLoot() {
        int count = new Random().nextInt(2) + 1; // 1 eller 2 föremål
        for (int i = 0; i < count; i++) {
            if (new Random().nextBoolean()) {
                loot.add(new Potion("Health Potion", 10));  // Lägg till en potion
            } else {
                loot.add(new Weapon("Iron Sword", 2));      // Lägg till ett vapen
            }
        }
        System.out.println("Rummet är rensat! Loot har droppats.");
    }

    // Returnerar listan av monster i rummet
    public List<Monster> getMonsters() {
        return monsters;
    }

    // Returnerar listan av loot i rummet
    public List<Item> getLoot() {
        return loot;
    }

    // Returnerar rummets svårighetsgrad
    public int getDifficulty() {
        return difficulty;
    }

    // Returnerar en beskrivning av rummet
    public String getDescription() {
        return description;
    }
}
