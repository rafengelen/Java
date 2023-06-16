package fact.it.startproject.model;

// Mage class
public class Mage extends Character {

    public Mage(String name) {
        super(name);
        super.setAttackStrategy(new FireballAttack());
    }


    @Override
    public String start() {
        return "Mage "+super.getName()+" is ready to attack with a "+super.getAttackStrategy().getWeapon();
    }
}