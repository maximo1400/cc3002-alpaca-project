package model.items.books;

import model.items.AbstractItem;
import model.units.*;

public abstract class AbstractBook extends AbstractItem implements IBook {
    /**
     * Constructor for a default item without any special behaviour.
     *
     * @param name     the name of the item
     * @param power    the power of the item (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the item
     * @param maxRange
     */
    public AbstractBook(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void equip(IUnit unit) {
        unit.equipBook(this);
    }


}
