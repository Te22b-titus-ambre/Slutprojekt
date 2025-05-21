// En potion är ett föremål som läker spelaren. Ärver från Item.
public class Potion extends Item {
    private int healAmount; // Hur mycket HP potions läker

    // Konstruktor – sätter namn och hur mycket potionen läker
    public Potion(String name, int healAmount) {
        super(name);               // Skickar namn till basklassen Item
        this.healAmount = healAmount;
    }

    // Returnerar hur mycket HP potionen återställer
    public int getHealAmount() {
        return healAmount;
    }

    // Returnerar en textbeskrivning av potionen
    @Override
    public String toString() {
        return getName() + " (Healar " + healAmount + " HP)";
    }
}
