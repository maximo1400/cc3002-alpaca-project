package model.units;

import model.items.*;
import model.map.Location;

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
     * @param maxItems
     * @param items
     */
    protected Sorcerer(int hitPoints, int movement, Location location, int maxItems, IEquipableItem... items) {
        super(hitPoints, movement, location, 3, items);
    }

    /**
     * Sets the currently equipped item of this unit.
     *
     * @param item the item to equip
     */
    @Override
    public void equipItem(IEquipableItem item) {

    }

    @Override
    public void equipAxe(Axe axe) {

    }

    @Override
    public void equipBow(Bow bow) {

    }

    @Override
    public void equipSpear(Spear spear) {

    }

    @Override
    public void equipStaff(Staff staff) {

    }

    @Override
    public void equipSword(Sword sword) {

    }

    @Override
    public void equipBook(Book book) {

    }

    @Override
    public void attack(IUnit unit) {

    }

    @Override
    public boolean canAttack() {
        return false;
    }

    @Override
    public void giveItem(IUnit unit) {

    }

    @Override
    public void receiveWeakAttack() {

    }

    @Override
    public void receiveStrongAttack() {

    }
}
