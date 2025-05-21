public abstract class Entity {
    private String name;

    public Entity(String name) {
        this.name = name;
    }

    // @return entitetens namn
    public String getName() {
        return name;
    }

    // Entiteten tar skada
    public abstract void takeDamage(int amount);

    // @return true om entiteten fortfarande lever
    public abstract boolean isAlive();


}