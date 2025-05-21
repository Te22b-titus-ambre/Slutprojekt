import java.util.Random;

public class Skeleton extends Monster {
    private Random rnd = new Random();

    public Skeleton(int tier) {
        super("Skeleton", tier);
    }

    @Override
    public void specialAbility(Entity target) {
        System.out.print(getName() + " skjuter pil... ");
        if (rnd.nextDouble() < 0.7) {
            int arrowDmg = getTier() + 1;
            System.out.println("träffar för " + arrowDmg + " skada!");
            target.takeDamage(arrowDmg);
        } else {
            System.out.println("missar!");
        }
    }
}