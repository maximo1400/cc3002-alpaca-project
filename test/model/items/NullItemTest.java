package model.items;

import model.map.Field;
import model.map.Location;
import model.units.Alpaca;
import model.units.Cleric;
import model.units.IUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test set for Null weapons
 *
 * @author Maximo Retamal Rojas
 * @since 2.0
 */
class NullItemTest extends AbstractTestItem{
    private NullItem nullItem;
    private NullItem wrongNullitem;
    private Alpaca alpaca;
    /**
     * Sets which item is going to be tested
     */
    @Override
    public void setTestItem() {

        nullItem = new NullItem();
    }

    /**
     * Sets up an item with wrong ranges setted.
     */
    @Override
    public void setWrongRangeItem() {
        wrongNullitem = new NullItem();
    }

    /**
     * Sets the unit that will be equipped with the test item
     */
    @Override
    public void setTestUnit() {
        alpaca = new Alpaca(10, 5, new Location(0, 0));
    }
    @Override
    @Test
    public void constructorTest() {
        // Method body intentionally left empty

    }
    @Override
    @Test
    public void equippedToTest() {
        // Method body intentionally left empty
    }

    @Override
    public IEquipableItem getWrongTestItem() {
        return wrongNullitem;
    }

    /**
     * @return the item being tested
     */
    @Override
    public IEquipableItem getTestItem() {
        return nullItem;
    }

    @Test
    public void AttackUnitTest(){
        Field field = new Field();
        field.addCells(true, new Location(0, 0), new Location(0, 1), new Location(0, 2),
                new Location(1, 0), new Location(1, 1), new Location(1, 2), new Location(2, 0),
                new Location(2, 1), new Location(2, 2));


        Alpaca targetAlpaca = new Alpaca(50, 2, field.getCell(0, 0));
        targetAlpaca.moveTo(field.getCell(0,0));
        getTestUnit().setLocation(field.getCell(0,1));
        assertTrue(targetAlpaca.getLocation().distanceTo(getTestUnit().getLocation())<=1);

        int life=targetAlpaca.getCurrentHitPoints();
        getTestUnit().getEquippedItem().attackUnit(targetAlpaca.getEquippedItem());
        assertEquals(life,targetAlpaca.getCurrentHitPoints());
        getTestUnit().addToInventory(getTestItem());
        getTestUnit().equipItem(getTestItem());
        getTestUnit().getEquippedItem().attackUnit(targetAlpaca.getEquippedItem());
        assertEquals(life,targetAlpaca.getCurrentHitPoints());

    }

    /**
     * @return a unit that can equip the item being tested
     */
    @Override
    public IUnit getTestUnit() {
        return alpaca;
    }
    @Test
    public void useHealingTest(){


        Field field = new Field();
        field.addCells(true, new Location(0, 0), new Location(0, 1), new Location(0, 2),
                new Location(1, 0), new Location(1, 1), new Location(1, 2), new Location(2, 0),
                new Location(2, 1), new Location(2, 2));


        Alpaca targetAlpaca = new Alpaca(50, 2, field.getCell(0, 0));
        targetAlpaca.moveTo(field.getCell(0,0));
        getTestUnit().setLocation(field.getCell(0,1));
        assertTrue(targetAlpaca.getLocation().distanceTo(getTestUnit().getLocation())<=1);

        int life=targetAlpaca.getCurrentHitPoints();
        getTestUnit().getEquippedItem().useHealing(targetAlpaca);
        assertEquals(life,targetAlpaca.getCurrentHitPoints());
        getTestUnit().addToInventory(getTestItem());
        getTestUnit().equipItem(getTestItem());
        getTestUnit().getEquippedItem().useHealing(targetAlpaca);
        assertEquals(life,targetAlpaca.getCurrentHitPoints());


    }

}
