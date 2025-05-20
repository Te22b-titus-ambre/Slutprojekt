import java.util.ArrayList;

public class Player extends Entity {
    private int hp = 20;
    private int attack = 5;
    private ArrayList<Item> inventory = new ArrayList<>();

    public int getHP() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
        System.out.println("Du tog " + dmg + " skada! HP kvar: " + hp);
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void heal(int amt) {
        hp = Math.min(hp + amt, 20);
    }

    public void upgradeAttack(int bonus) {
        attack += bonus;
    }

    public boolean hasPotion() {
        return inventory.stream().anyMatch(i -> i instanceof Potion);
    }

    public void usePotion() {
        for (Item i : inventory) {
            if (i instanceof Potion) {
                Potion p = (Potion) i;
                heal(p.getHealAmount());
                System.out.println(
                        "Du dricker " + p.getName() +
                                " och får " + p.getHealAmount() +
                                " HP! Nuvarande HP: " + hp
                );
                inventory.remove(i);
                return;
            }
        }
    }

    public void addItem(Item item) {
        inventory.add(item);
    }
}