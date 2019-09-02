package model.items;

import model.units.IUnit;

public class NullItem extends AbstractItem {
    /**
     * Constructor for a default item without any special behaviour.
     */
    public NullItem() {
        super("Null Object", 0, 0, 0);
    }

    /**
     * Equips this item to a unit.
     *
     * @param unit the unit that will be quipped with the item
     */
    @Override
    public void equip(IUnit unit) {
        // Method body intentionally left empty
    }

    @Override
    public boolean canUse(IUnit unit) {
        return false;
    }

    @Override
    public void AttackUnit(IUnit unit) {
        // Method body intentionally left empty
    }

    @Override
    public boolean isWeapon() {
        return false;
    }
}
