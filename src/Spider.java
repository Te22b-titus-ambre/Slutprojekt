import java.util.Random;

//Spider: giftattack som ger skada över tid.

public class Spider extends Monster {
    private Random rnd = new Random();

    public Spider(int tier) {
        super("Spider", tier);
    }

    @Override
    public void specialAbility(Entity target) {
        int poisonDmg = getTier();
        System.out.println(getName() + " använder Poison Bite! Ger omedelbart " + poisonDmg + " skada och förgiftar målet.");
        target.takeDamage(poisonDmg);
        // Förgiftning: applicera en effekt som ger extra skada över tid.
        // Här kan du t.ex. lagra en flagga på target som i en framtida rond
        // ger mer skada. Exempelvis:
        // if (target instanceof Player) ((Player) target).applyPoison(getTier());
    }
}