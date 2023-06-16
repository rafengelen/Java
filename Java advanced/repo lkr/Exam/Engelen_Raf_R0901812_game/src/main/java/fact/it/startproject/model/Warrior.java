package fact.it.startproject.model;

// Warrior class
public class Warrior extends Character{

    public Warrior(String name) {
        super(name);
        super.setAttackStrategy(new SwordAttack());
    }

    @Override
    public String start() {
        return "Warrior "+super.getName()+" is ready to attack with a "+super.getAttackStrategy().getWeapon();
    }
}