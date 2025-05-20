public abstract class Entity {
    protected int hp;
    protected int attack;

    public Entity(int hp, int attack) {
        this.hp = hp;
        this.attack = attack;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println(
                getClass().getSimpleName() + " tog " + damage + " skada! HP kvar: " + hp
        );
    }

    public void attack(Entity target) {
        System.out.println(
                getClass().getSimpleName() + " attackerar " + target.getClass().getSimpleName() + " för " + attack + " skada."
        );
        target.takeDamage(attack);
    }

    public int getHP() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public boolean isAlive() {
        return hp > 0;
    }
}