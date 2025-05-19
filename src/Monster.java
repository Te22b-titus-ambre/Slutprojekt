import javax.swing.*;
import java.util.ArrayList;

public class Monster extends Entity {
    protected int tier;
    protected int hp;
    protected int attack;

    public Monster(int tierNumber) {
        tier = tierNumber;
        hp = 5 + tier * 2;
        attack = 1 + tier;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println(getClass().getSimpleName() + " tog " + damage + " skada! HP kvar: " + hp);
    }

    public int getAttack() {
        return attack;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public String toString() {
        if (tier > 0) {
            return getClass().getSimpleName() + " (Tier: " + tier + ", HP: " + hp + ")";
        } else {
            return getClass().getSimpleName();
        }
    }
}
