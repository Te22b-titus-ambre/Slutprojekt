// Weapon är ett föremål som ökar spelarens attack. Ärver från Item.
public class Weapon extends Item {
    private int attackBonus; // Hur mycket extra attack vapnet ger

    // Konstruktor – sätter namn och attackbonus
    public Weapon(String name, int attackBonus) {
        super(name);               // Skickar namn till basklassen Item
        this.attackBonus = attackBonus;
    }

    // Returnerar en textbeskrivning av vapnet med attackbonus
    @Override
    public String toString() {
        return getName() + " (Attack +" + attackBonus + ")";
    }
}
