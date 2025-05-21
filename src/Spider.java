// Spider är en specifik typ av monster som ärver från Monster-klassen
public class Spider extends Monster {
    private static final String name = "Spider"; // Namnet på denna monstertyp

    // Konstruktor – skapar en Spider med angiven tier (svårighetsgrad)
    public Spider(int tier) {
        super(name, tier); // Skickar namn och tier till basklassen Monster
    }
}
