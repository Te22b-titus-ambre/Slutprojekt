public class Zombie extends Monster {
    public Zombie(int tier) {
        super("Zombie", tier);
    }

    @Override
    public void specialAbility(Entity target) {
        int biteDamage = getTier() + 2;
        System.out.println(getName() + " använder Bite och gör " + biteDamage + " skada!");
        target.takeDamage(biteDamage);
        int healAmount = biteDamage / 2;
        heal(healAmount);
    }
}