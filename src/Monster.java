import java.util.Random;

// Abstrakt klass för monster. Har tier, hp och attack.
public abstract class Monster extends Entity {
    private int tier;   // Svårighetsgrad/nivå för monstret
    private int hp;     // Hälsopoäng
    private int attack; // Skadevärde

    // Konstruktor – sätter namn, tier, beräknar HP och attack baserat på tier
    public Monster(String name, int tier) {
        super(name);
        this.tier = tier;
        this.hp = 5 + tier * 2;       // HP ökar med tier
        this.attack = 1 + tier;       // Attack ökar med tier
    }

    // Statisk metod för att slumpa en tier-nivå mellan 1 och 3
    public static int randomTier() {
        return new Random().nextInt(3) + 1;
    }

    // Metod som anropas när monstret tar skada
    @Override
    public void takeDamage(int amount) {
        hp -= amount;
        System.out.println(getName() + " tog " + amount + " skada! HP kvar: " + hp);
    }

    // Kollar om monstret fortfarande lever
    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    // Returnerar hur mycket skada monstret gör
    public int getAttack() {
        return attack;
    }

    // Returnerar hur mycket HP monstret har kvar
    public int getHp() {
        return hp;
    }

    // Returnerar en textrepresentation av monstret (namn, tier och HP)
    @Override
    public String toString() {
        return getName() + " (Tier " + tier + ", HP " + hp + ")";
    }
}
