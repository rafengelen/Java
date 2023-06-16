package fact.it.startproject;

import fact.it.startproject.model.*;
import fact.it.startproject.model.Character;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class startprojectApplicationTests {

    @Test
    public void a_testSingleton() {
        CharacterSelectionMenu csMenu = CharacterSelectionMenu.getInstance();
        CharacterSelectionMenu csMenu2 = CharacterSelectionMenu.getInstance();
        assertTrue(csMenu == csMenu2);
    }

    @Test
    public void b_archerDefaultAttack_returnsBow(){
        Character archer = new Archer("Legolas");
        assertEquals("Archer Legolas is ready to attack with a bow", archer.start());
    }
    @Test
    public void c_warriorDefaultAttack_returnsSword(){
        Character warrior = new Warrior("Aragorn");
        assertEquals("Warrior Aragorn is ready to attack with a sword", warrior.start());
    }
    @Test
    public void d_mageDefaultAttack_returnsFireBall(){
        Character mage = new Mage("Gandalf");
        assertEquals("Mage Gandalf is ready to attack with a fireball", mage.start());
    }

    @Test
    public void e_mageChangeDefaultAttackSword_returnsSword(){
        Character mage = new Mage("Gandalf");
        mage.setAttackStrategy(new SwordAttack());
        assertEquals("sword", mage.getAttackStrategy().getWeapon());
    }
    @Test
    public void f_archerChangeDefaultAttackFireBall_returnsFireBall(){
        Character archer = new Archer("Legolas");
        archer.setAttackStrategy(new FireballAttack());
        assertEquals("fireball", archer.getAttackStrategy().getWeapon());
    }
    @Test
    public void e_warriorChangeDefaultAttackBow_returnsBow(){
        Character warrior = new Warrior("Gimli");
        warrior.setAttackStrategy(new BowAttack());
        assertEquals("bow", warrior.getAttackStrategy().getWeapon());
    }
}




