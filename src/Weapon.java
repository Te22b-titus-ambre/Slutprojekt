public class Weapon extends Item {
    private int attackBonus;

    public Weapon(String name, int attackBonus) {
        super(name);
        this.attackBonus = attackBonus;
    }

    // @return bonus som läggs på attack
    public int getAttackBonus() {
        return attackBonus;
    }

    @Override
    public String toString() {
        return getName() + " (Attack +" + attackBonus + ")";
    }
}