package model.units;

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
}

