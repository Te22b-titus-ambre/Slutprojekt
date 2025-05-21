import java.util.Random;

public abstract class Monster extends Entity {
    private int tier;
    private int hp;
    private int attack;
    private Random rnd = new Random();

    public Monster(String name, int tier) {
        super(name);
        this.tier = tier;
        this.hp = 5 + tier * 2;
        this.attack = 1 + tier;
    }

    /**
     * Ger ett slumpmässigt tier-värde mellan 1 och 3.
     */
    public static int randomTier() {
        return new Random().nextInt(3) + 1;
    }

    /** Enkel vanlig attack */
    public void attack(Entity target) {
        System.out.println(getName() + " attackerar för " + attack + " skada.");
        target.takeDamage(attack);
    }

    /**
     * Specialförmåga – varje typ implementerar den olika.
     */
    public abstract void specialAbility(Entity target);

    @Override
    public void takeDamage(int amount) {
        hp -= amount;
        System.out.println(getName() + " tog " + amount + " skada! HP kvar: " + hp);
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    /** För självläkning i subklasser */
    protected void heal(int amount) {
        hp += amount;
        System.out.println(getName() + " läker " + amount + " HP! HP nu: " + hp);
    }

    public int getTier() {
        return tier;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public String toString() {
        return getName() + " (Tier " + tier + ", HP " + hp + ")";
    }
}