package model.units;

import model.items.*;
import model.map.Location;
import model.items.books.*;
import java.awt.print.Book;

/**
 *
 */
public class Sorcerer extends AbstractUnit{
    /**
     * Creates a new Unit.
     *
     * @param hitPoints the maximum amount of damage a unit can sustain
     * @param movement  the number of panels a unit can move
     * @param location  the current position of this unit on the map
     * @param items
     */
    protected Sorcerer(final int hitPoints, final int movement, final Location location, IEquipableItem... items) {
        super(hitPoints, movement, location, 3, items);
    }

    @Override
    public void equipAxe(Axe axe) {
        // Method body intentionally left empty
    }

    @Override
    public void equipBow(Bow bow) {
        // Method body intentionally left empty
    }

    @Override
    public void equipSpear(Spear spear) {
        // Method body intentionally left empty
    }

    @Override
    public void equipStaff(Staff staff) {
        // Method body intentionally left empty
    }

    @Override
    public void equipSword(Sword sword) {
        // Method body intentionally left empty
    }

    @Override
    public void equipBook(IBook book) {
        this.equipItem(book);
    }

    @Override
    public void giveItem(IUnit unit) {

    }

}
