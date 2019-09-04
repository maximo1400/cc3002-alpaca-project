package model.units;

import model.items.Bow;
import model.items.books.Anima;
import model.items.books.Darkness;
import model.items.books.Light;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SorcererTest extends  AbstractTestUnit{
    private Sorcerer sorcerer;

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    @Override
    public void setTestUnit() {
        sorcerer = new Sorcerer(50, 2, field.getCell(0, 0));
    }

    /**
     * @return the current unit being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }

    @Test
    @Override
    public void equipAnimaTest() {
        checkEquippedItem(anima);
    }
    @Test
    @Override
    public void equipDarknessTest() {
        checkEquippedItem(darkness);
    }
    @Test
    @Override
    public void equipLightTest() {
        checkEquippedItem(light);
    }
    @Test
    @Override
    public void checkCombat(){
        checkStrongWeakCombat(getAnima(), getLight(),getTargetSorcerer());setUp();
        checkWeakStrongCombat(getAnima(), getDarkness(),getTargetSorcerer());setUp();
        checkNormalNormalCombat(getAnima(),new Anima("Other Anima",10,1,3),getTargetSorcerer());setUp();
        checkStrongStrongCombat(getAnima(),getBow(),getTargetArcher());setUp();
        checkStrongStrongCombat(getAnima(),getAxe(),getTargetFighter());setUp();
        checkStrongStrongCombat(getAnima(),getSpear(),getTargetHero());setUp();
        checkStrongStrongCombat(getAnima(),getSword(),getTargetSwordMaster());setUp();
        checkUnilateralCombat(getAnima(),getTargetCleric());setUp();
        checkUnilateralCombat(getAnima(),getTargetAlpaca());setUp();

        checkWeakStrongCombat(getDarkness(), getLight(),getTargetSorcerer());setUp();
        checkNormalNormalCombat(getDarkness(), new Darkness("Other Darkness",10,1,3),getTargetSorcerer());setUp();
        checkStrongWeakCombat(getDarkness(),getAnima(),getTargetSorcerer());setUp();
        checkStrongStrongCombat(getDarkness(),getBow(),getTargetArcher());setUp();
        checkStrongStrongCombat(getDarkness(),getAxe(),getTargetFighter());setUp();
        checkStrongStrongCombat(getDarkness(),getSpear(),getTargetHero());setUp();
        checkStrongStrongCombat(getDarkness(),getSword(),getTargetSwordMaster());setUp();
        checkUnilateralCombat(getDarkness(),getTargetCleric());setUp();
        checkUnilateralCombat(getDarkness(),getTargetAlpaca());setUp();

        checkNormalNormalCombat(getLight(), new Light("Other Light",10,1,3),getTargetSorcerer());setUp();
        checkStrongWeakCombat(getLight(), getDarkness(),getTargetSorcerer());setUp();
        checkWeakStrongCombat(getLight(),getAnima(),getTargetSorcerer());setUp();
        checkStrongStrongCombat(getLight(),getBow(),getTargetArcher());setUp();
        checkStrongStrongCombat(getLight(),getAxe(),getTargetFighter());setUp();
        checkStrongStrongCombat(getLight(),getSpear(),getTargetHero());setUp();
        checkStrongStrongCombat(getLight(),getSword(),getTargetSwordMaster());setUp();
        checkUnilateralCombat(getLight(),getTargetCleric());setUp();
        checkUnilateralCombat(getLight(),getTargetAlpaca());setUp();



    }
}

