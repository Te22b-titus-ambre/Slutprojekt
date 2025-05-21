// Zombie är en specifik typ av monster som ärver från Monster-klassen
public class Zombie extends Monster {
    private static final String name = "Zombie"; // Namnet på denna monstertyp

    // Konstruktor – skapar en Zombie med angiven tier (svårighetsgrad)
    public Zombie(int tier) {
        super(name, tier); // Skickar namn och tier till basklassen Monster
    }
}
