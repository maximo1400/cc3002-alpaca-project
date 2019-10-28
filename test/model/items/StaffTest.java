package model.items;

import model.map.Field;
import model.map.Location;
import model.units.Alpaca;
import model.units.Cleric;
import model.units.IUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test set for staffs
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class StaffTest extends AbstractTestItem {

    private Staff staff;
    private Staff wrongStaff;
    private Cleric cleric;

    /**
     * Sets which item is going to be tested
     */
    @Override
    public void setTestItem() {
        expectedName = "Common staff";
        expectedPower = 5;
        expectedMinRange = 1;
        expectedMaxRange = 2;
        staff = new Staff(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    }

    /**
     * Sets up an item with wrong ranges setted.
     */
    @Override
    public void setWrongRangeItem() {
        wrongStaff = new Staff("Wrong staff", 0, -1, -2);
    }

    /**
     * Sets the unit that will be equipped with the test item
     */
    @Override
    public void setTestUnit() {
        cleric = new Cleric(10, 5, new Location(0, 0));
    }

    @Override
    public IEquipableItem getWrongTestItem() {
        return wrongStaff;
    }

    /**
     * @return the item being tested
     */
    @Override
    public IEquipableItem getTestItem() {
        return staff;
    }

    @Test
    public void AttackUnitTest() {
        Field field = new Field();
        field.addCells(true, new Location(0, 0), new Location(0, 1), new Location(0, 2),
                new Location(1, 0), new Location(1, 1), new Location(1, 2), new Location(2, 0),
                new Location(2, 1), new Location(2, 2));


        Alpaca targetAlpaca = new Alpaca(50, 2, field.getCell(0, 0));
        targetAlpaca.moveTo(field.getCell(0, 0));
        getTestUnit().setLocation(field.getCell(0, 1));
        assertTrue(targetAlpaca.getLocation().distanceTo(getTestUnit().getLocation()) <= 1);

        int life = targetAlpaca.getCurrentHitPoints();
        getTestUnit().getEquippedItem().attackUnit(targetAlpaca.getEquippedItem());
        assertEquals(life, targetAlpaca.getCurrentHitPoints());
        getTestUnit().addToInventory(getTestItem());
        getTestUnit().equipItem(getTestItem());
        getTestUnit().getEquippedItem().attackUnit(targetAlpaca.getEquippedItem());
        assertEquals(life, targetAlpaca.getCurrentHitPoints());

    }

    /**
     * @return a unit that can equip the item being tested
     */
    @Override
    public IUnit getTestUnit() {
        return cleric;
    }

    @Test
    public void useHealingTest() {


        Field field = new Field();
        field.addCells(true, new Location(0, 0), new Location(0, 1), new Location(0, 2),
                new Location(1, 0), new Location(1, 1), new Location(1, 2), new Location(2, 0),
                new Location(2, 1), new Location(2, 2));


        Alpaca targetAlpaca = new Alpaca(50, 2, field.getCell(0, 0));
        targetAlpaca.moveTo(field.getCell(0, 0));
        getTestUnit().setLocation(field.getCell(0, 1));
        assertTrue(targetAlpaca.getLocation().distanceTo(getTestUnit().getLocation()) <= 1);

        int life = targetAlpaca.getCurrentHitPoints();
        getTestUnit().getEquippedItem().useHealing(targetAlpaca);
        assertEquals(life, targetAlpaca.getCurrentHitPoints());
        getTestUnit().addToInventory(getTestItem());
        getTestUnit().equipItem(getTestItem());
        getTestUnit().getEquippedItem().useHealing(targetAlpaca);
        assertEquals(life + getTestItem().getPower(), targetAlpaca.getCurrentHitPoints());


    }

}
