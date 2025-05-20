public class Monster extends Entity {
    private int tier;

    public Monster(int tier) {
        super(5 + tier * 2, 1 + tier);
        this.tier = tier;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " (Tier: " + tier + ", HP: " + hp + ")";
    }
}