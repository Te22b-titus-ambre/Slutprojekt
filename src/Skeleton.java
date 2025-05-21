// Skeleton är en specifik typ av monster som ärver från Monster-klassen
public class Skeleton extends Monster {
    private static final String name = "Skeleton"; // Namnet på denna monstertyp

    // Konstruktor – skapar ett Skeleton med angiven tier (svårighetsgrad)
    public Skeleton(int tier) {
        super(name, tier); // Skickar namn och tier till basklassen Monster
    }
}

