package model.units;

import model.items.IEquipableItem;
import model.items.books.IBook;
import model.map.Location;

/**
 * This class represents a Sorcerer type unit.
 *  * A sorcerer is a unit that can only use book type weapons.
 *  *
 *  * @author Maximo Retamal Rojas
 *  * @since 2.0
 *
 */
public class Sorcerer extends AbstractUnit{
    /**
     * Creates a new Sorcerer.
     *
     * @param hitPoints the maximum amount of damage a unit can sustain
     * @param movement  the number of panels a unit can move
     * @param location  the current position of this unit on the map
     * @param items     maximum amount of items this unit can carry
     */
    public Sorcerer(final int hitPoints, final int movement, final Location location, IEquipableItem... items) {
        super(hitPoints, movement, location, 3, items);
    }

    @Override
    public void equipBook(IBook book) {
        this.setEquippedItem(book);
        book.setOwner(this);
    }

}
