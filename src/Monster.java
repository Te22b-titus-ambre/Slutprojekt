public class Monster extends Entity {
    protected int tier;
    protected int hp;
    protected int attack;

    public Monster(int tier) {
        this.tier = tier;
        this.hp = 5 + tier * 2;
        this.attack = 1 + tier;
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
        System.out.println(
                getClass().getSimpleName() +
                        " tog " + dmg +
                        " skada! HP kvar: " + hp
        );
    }

    public int getAttack() {
        return attack;
    }

    public int getHP() {
        return hp;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public String toString() {
        if (tier > 0) {
            return getClass().getSimpleName() +
                    " (Tier: " + tier +
                    ", HP: " + hp + ")";
        } else {
            return getClass().getSimpleName();
        }
    }
}