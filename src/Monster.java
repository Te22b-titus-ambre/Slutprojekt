import java.util.Random;

// Abstrakt klass för monster. Har tier, hp och attack.
public abstract class Monster extends Entity {
    private int tier;
    private int hp;
    private int attack;

    public Monster(String name, int tier) {
        super(name);
        this.tier = tier;
        this.hp = 5 + tier * 2;
        this.attack = 1 + tier;
    }

    // Slumpmässigt tier-attribut (1–3)
    public static int randomTier() {
        return new Random().nextInt(3) + 1;
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

    //@return hur mycket skada monstret gör
    public int getAttack() {
        return attack;
    }

    // @return monstrets tier
    public int getTier() {
        return tier;
    }

    // @return återstående HP
    public int getHp() {
        return hp;
    }

    @Override
    public String toString() {
        return getName() + " (Tier " + tier + ", HP " + hp + ")";
    }
}