import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {
    private List<Item> inventory = new ArrayList<>();

    public Player() {
        super(20, 5);
    }

    public int getHP() {
        return super.getHP();
    }

    public int getAttack() {
        return super.getAttack();
    }

    public void heal(int amount) {
        hp = Math.min(hp + amount, 20);
        System.out.println("🧪 Du helar " + amount + " HP. Nuvarande HP: " + hp);
    }

    public void upgradeAttack(int bonus) {
        attack += bonus;
        System.out.println("🗡️ Din attack ökar med " + bonus + ". Nuvarande attack: " + attack);
    }

    public boolean hasPotion() {
        return inventory.stream().anyMatch(i -> i instanceof Potion);
    }

    public void usePotion() {
        for (Item i : inventory) {
            if (i instanceof Potion) {
                Potion p = (Potion) i;
                heal(p.getHealAmount());
                inventory.remove(i);
                return;
            }
        }
        System.out.println("Ingen potion i inventariet!");
    }

    public void addItem(Item item) {
        inventory.add(item);
        System.out.println("➕ Du plockade upp: " + item);
    }
}