import java.util.List;

// Spelaren: ärver från Entity, har HP, attack och ett generiskt Inventory<Item>.
public class Player extends Entity {
    private int hp = 20;                     // Spelarens hälsa
    private int attack = 5;                  // Spelarens attackstyrka
    private Inventory<Item> inventory = new Inventory<>(); // Spelarens inventarie

    // Konstruktor – skickar namn till basklassen
    public Player(String name) {
        super(name);
    }

    // Spelaren tar skada – minskar HP och skriver ut återstående HP
    @Override
    public void takeDamage(int amount) {
        hp -= amount;
        System.out.println(getName() + " tog " + amount + " skada! HP kvar: " + hp);
    }

    // Kontroll om spelaren lever
    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    // Returnerar spelarens nuvarande HP
    public int getHp() {
        return hp;
    }

    // Returnerar spelarens attackvärde
    public int getAttack() {
        return attack;
    }

    // Läker spelaren – max 20 HP
    public void heal(int amount) {
        hp = Math.min(hp + amount, 20);
        System.out.println(getName() + " läker " + amount + " HP! HP nu: " + hp);
    }

    // Försöker använda en potion från inventariet
    public void usePotion() {
        List<Item> items = inventory.getAll();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) instanceof Potion) {
                Potion p = (Potion) items.get(i);
                heal(p.getHealAmount());      // läker spelaren
                inventory.remove(i);          // tar bort potion
                return;
            }
        }
        System.out.println("Ingen potion att dricka!");
    }

    // Lägger till ett föremål i inventariet
    public void addItem(Item item) {
        inventory.add(item);
        System.out.println(item.getName() + " lades till i inventariet.");
    }

    // Skriver ut allt som finns i inventariet
    public void showInventory() {
        System.out.println("=== Inventariet ===");
        for (Item i : inventory.getAll()) {
            System.out.println("- " + i);
        }
    }
}
