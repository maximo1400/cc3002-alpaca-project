package model.items.books;

import model.items.AbstractItem;
import model.units.IUnit;
/**
 * Abstract class that defines some common information and behaviour between all Books.
 *
 * @author Maximo Retamal Rojas
 * @since 2.0
 */
public abstract class AbstractBook extends AbstractItem implements IBook {
    /**
     * Constructor for a default item without any special behaviour.
     *
     * @param name     the name of the item
     * @param power    the power of the item (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the item
     * @param maxRange the maximum range of the item
     */
    public AbstractBook(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void equip(IUnit unit) {
        unit.equipBook(this);
    }


}
