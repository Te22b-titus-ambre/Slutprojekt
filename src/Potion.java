public class Potion extends Item {
    private int healAmount;

    public Potion(String name, int healAmount) {
        super(name);
        this.healAmount = healAmount;
    }

    // @return hur mycket HP denna potion återställer
    public int getHealAmount() {
        return healAmount;
    }

    @Override
    public String toString() {
        return getName() + " (Healar " + healAmount + " HP)";
    }
}