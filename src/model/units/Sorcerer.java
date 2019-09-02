package model.units;

import model.items.*;
import model.map.Location;
import model.items.books.*;

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
    public void equipBook(IBook book) {
        this.setEquippedItem(book);
        book.setOwner(this);
    }




    @Override
    public void receiveAnimaAttack(Anima anima) {

    }

    @Override
    public void receiveDarknessAttack(Darkness darkness) {

    }

    @Override
    public void receiveLightAttack(Light light) {

    }

    @Override
    public void receiveAxeAttack(Axe axe) {

    }

    @Override
    public void receiveBowAttack(Bow bow) {

    }

    @Override
    public void receiveSpearAttack(Spear spear) {

    }

    @Override
    public void receiveSwordAttack(Sword sword) {

    }

    @Override
    public void equipSword(Sword sword) {
        // Method body intentionally left empty
    }



}
