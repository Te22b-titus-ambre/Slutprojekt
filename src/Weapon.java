public class Weapon extends Item {
    int attackBonus;

    public Weapon(String name, int attackBonus) {
        super(name);
        this.attackBonus = attackBonus;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    @Override
    public String toString() {
        return name + " (Attack +" + attackBonus + ")";
    }
}
