package model.items.books;

import model.units.IUnit;

public class Light extends AbstractBook {
    /**
     * Constructor for a default item without any special behaviour.
     *
     * @param name     the name of the item
     * @param power    the power of the item (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the item
     * @param maxRange
     */
    public Light(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void AttackUnit(IUnit unit) {

    }

    @Override
    public boolean isWeapon() {
        return true;
    }
}
