package fact.it.startproject.model;

// Archer class
public class Archer extends Character{

    public Archer(String name) {
        super(name);
        super.setAttackStrategy(new BowAttack());
    }



    @Override
    public String start() {
        return "Archer "+super.getName()+" is ready to attack with a "+super.getAttackStrategy().getWeapon();
    }
}