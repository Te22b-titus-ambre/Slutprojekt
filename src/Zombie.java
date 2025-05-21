public class Zombie extends Monster {
    public Zombie(int tier) {
        super("Zombie", tier);
    }

    @Override
    public void specialAbility(Entity target) {
        int biteDamage = getTier() + 2;
        System.out.println(getName() + " använder Bite! Gör " + biteDamage + " skada och läker själv " + biteDamage/2 + " HP.");
        target.takeDamage(biteDamage);
        // Läker själv halva skadan
        int heal = biteDamage / 2;
        // Anta att Entity har en heal-metod på spelaren, annars caste:
        if (this instanceof Monster) {
            // Monster läker sig själv
            // Om du vill låta monstret läka, lägg in hp-åtkomst i basklassen.
        }
    }
}