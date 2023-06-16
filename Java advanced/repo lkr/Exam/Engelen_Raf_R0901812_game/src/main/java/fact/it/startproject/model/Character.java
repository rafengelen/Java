package fact.it.startproject.model;

// Character class
public abstract class Character {
    private AttackStrategy attackStrategy;
    private String name;

    public Character(String name) {
        this.name = name;
    }
    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public abstract String start();
}