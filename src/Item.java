// Abstrakt basklass för alla föremål (t.ex. potion, vapen)
public abstract class Item {
    protected String name; // Namnet på föremålet

    // Konstruktor – sätter namn på föremålet
    public Item(String name) {
        this.name = name;
    }

    // Returnerar namnet på föremålet
    public String getName() {
        return name;
    }

    // Returnerar en strängrepresentation av föremålet (namnet)
    @Override
    public String toString() {
        return name;
    }
}
