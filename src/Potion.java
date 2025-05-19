
public class Potion extends Item {
        int healAmount;

        public Potion(String name, int healAmount) {
            super(name);
            this.healAmount = healAmount;
        }

        public int getHealAmount() {
            return healAmount;
        }

        @Override
        public String toString() {
            return name + " (Healar " + healAmount + " HP)";
        }
}

