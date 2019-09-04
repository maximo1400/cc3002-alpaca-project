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
    public void equipBook(IBook book) {
        this.setEquippedItem(book);
        book.setOwner(this);
    }

}
