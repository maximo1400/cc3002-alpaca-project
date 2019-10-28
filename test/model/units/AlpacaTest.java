package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test set for the alpaca unit
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class AlpacaTest extends AbstractTestUnit {

    private Alpaca alpaca;

    @Override
    public void setTestUnit() {
        alpaca = new Alpaca(50, 2, field.getCell(0, 0));
    }

    @Override
    public Alpaca getTestUnit() {
        return alpaca;
    }

    @Override
    public void checkCombat() {
    }

    @Test
    @Override
    public void checkExchange() {
        targetAlpaca.moveTo(getField().getCell(0, 0));
        getTestUnit().moveTo(getField().getCell(0, 2));

        targetAlpaca.addToInventory(getAnima());
        targetAlpaca.addToInventory(getAxe());
        targetAlpaca.addToInventory(getBow());
        targetAlpaca.addToInventory(getDarkness());
        targetAlpaca.addToInventory(getLight());
        targetAlpaca.addToInventory(getSpear());
        targetAlpaca.addToInventory(getStaff());
        targetAlpaca.addToInventory(getSword());

        targetAlpaca.exchange(getAnima(), getTestUnit());
        assertFalse(getTestUnit().getItems().contains(getAnima()));

        targetAlpaca.moveTo(getField().getCell(0, 0));
        getTestUnit().moveTo(getField().getCell(0, 1));
        assertTrue(targetAlpaca.getLocation().distanceTo(getTestUnit().getLocation()) <= 1);


        targetAlpaca.exchange(getAnima(), getTestUnit());
        targetAlpaca.exchange(getAxe(), getTestUnit());
        targetAlpaca.exchange(getBow(), getTestUnit());
        targetAlpaca.exchange(getDarkness(), getTestUnit());
        targetAlpaca.exchange(getLight(), getTestUnit());
        targetAlpaca.exchange(getSpear(), getTestUnit());
        targetAlpaca.exchange(getStaff(), getTestUnit());
        targetAlpaca.exchange(getSword(), getTestUnit());

        assertTrue(getTestUnit().getItems().contains(getAnima()));
        assertTrue(getTestUnit().getItems().contains(getAxe()));
        assertTrue(getTestUnit().getItems().contains(getBow()));
        assertTrue(getTestUnit().getItems().contains(getDarkness()));
        assertTrue(getTestUnit().getItems().contains(getLight()));
        assertTrue(getTestUnit().getItems().contains(getSpear()));
        assertTrue(getTestUnit().getItems().contains(getStaff()));
        assertTrue(getTestUnit().getItems().contains(getSword()));

    }
}