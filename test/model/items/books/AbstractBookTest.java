package model.items.books;

import model.items.AbstractTestItem;
import model.items.IEquipableItem;
import model.map.Location;
import model.units.IUnit;
import model.units.Sorcerer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

abstract class AbstractBookTest extends AbstractTestItem {
    public Sorcerer sorcerer;

    /**
     * Sets up a correctly implemented item that's going to be tested
     */
    @Override
    public abstract void setTestItem();

    /**
     * Sets up an item with wrong ranges setted.
     */
    @Override
    public abstract void setWrongRangeItem();

    /**
     * Sets the unit that will be equipped with the test item
     */
    @Override
    public void setTestUnit() {
        sorcerer = new Sorcerer(50, 2, new Location(0, 0));
    }

    /**
     * @return the wrong item being tested
     */
    @Override
    public abstract IEquipableItem getWrongTestItem();

    /**
     * @return the item being tested
     */
    @Override
    public abstract IEquipableItem getTestItem();

    /**
     * @return a unit that can equip the item being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }

    @Test
    public void isWeaponTest() {
        assertTrue(getTestItem().isWeapon());
    }

}