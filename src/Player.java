import java.util.List;

// Spelaren: ärver från Entity, har HP, attack och ett generiskt Inventory<Item>.
public class Player extends Entity {
    private int hp = 20;
    private int attack = 5;
    private Inventory<Item> inventory = new Inventory<>();

    public Player(String name) {
        super(name);
    }

    @Override
    public void takeDamage(int amount) {
        hp -= amount;
        System.out.println(getName() + " tog " + amount + " skada! HP kvar: " + hp);
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    // Återställer HP, max 20
    public void heal(int amount) {
        hp = Math.min(hp + amount, 20);
        System.out.println(getName() + " läker " + amount + " HP! HP nu: " + hp);
    }

    // Utrusta vapen—höjer attack
    public void equipWeapon(Weapon w) {
        attack += w.getAttackBonus();
        System.out.println(getName() + " utrustar " + w.getName() + ", attack är nu " + attack);
    }

    // @return om spelaren har en potion i inventariet
    public boolean hasPotion() {
        for (Item i : inventory.getAll()) {
            if (i instanceof Potion) {
                return true;
            }
        }
        return false;
    }

    // Drick första potion som finns
    public void usePotion() {
        List<Item> items = inventory.getAll();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) instanceof Potion) {
                Potion p = (Potion) items.get(i);
                heal(p.getHealAmount());
                inventory.remove(i);
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

    // Visar all loot i inventariet
    public void showInventory() {
        System.out.println("=== Inventariet ===");
        for (Item i : inventory.getAll()) {
            System.out.println("- " + i);
        }
    }
}