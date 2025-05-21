// Abstrakt basklass för alla entiteter i spelet (t.ex. spelare och monster)
public abstract class Entity {
    private String name; // Namn på entiteten

    // Konstruktor – initierar entitetens namn
    public Entity(String name) {
        this.name = name;
    }

    // Returnerar entitetens namn
    public String getName() {
        return name;
    }

    // Abstrakt metod för att ta skada – implementeras i subklasser
    public abstract void takeDamage(int amount);

    // Abstrakt metod för att kontrollera om entiteten lever – implementeras i subklasser
    public abstract boolean isAlive();
}
