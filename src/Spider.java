import java.util.Random;

/**
 * Spider: giftbett som gör extra skada direkt.
 */
public class Spider extends Monster {
    private Random rnd = new Random();

    public Spider(int tier) {
        super("Spider", tier);
    }

    @Override
    public void specialAbility(Entity target) {
        int poisonDamage = getTier() + 1;
        System.out.println(getName() + " använder Poison Bite och gör " + poisonDamage + " extra skada!");
        target.takeDamage(poisonDamage);
    }
}