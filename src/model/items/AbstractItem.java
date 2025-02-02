package model.items;

import model.units.IUnit;

/**
 * Abstract class that defines some common information and behaviour between all items.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractItem implements IEquipableItem {

    private final String name;
    private final int power;
    protected int maxRange;
    protected int minRange;
    private IUnit owner;

    /**
     * Constructor for a default item without any special behaviour.
     *
     * @param name     the name of the item
     * @param power    the power of the item (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the item
     * @param maxRange the maximum range of the item
     */
    public AbstractItem(final String name, final int power, final int minRange, final int maxRange) {
        this.name = name;
        this.power = power;
        this.minRange = Math.max(minRange, 1);
        this.maxRange = Math.max(maxRange, this.minRange);
    }

    @Override
    public IUnit getOwner() {
        return owner;
    }

    @Override
    public void setOwner(IUnit unit) {
        owner = unit;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public int getMinRange() {
        return minRange;
    }

    @Override
    public int getMaxRange() {
        return maxRange;
    }

    @Override
    public void attackUnit(IEquipableItem item) {
// Method body intentionally left empty
    }

    @Override
    public boolean isWeapon() {
        return false;
    }

    @Override
    public void useHealing(IUnit unit) {
        // Method body intentionally left empty
    }

    @Override
    public String asString() {
        StringBuilder string = new StringBuilder();
        string.append("Name: ");
        string.append(getName());
        string.append(" ");
        string.append("Power: ");
        string.append(getPower());
        string.append(" ");
        string.append("Max Range: ");
        string.append(getMaxRange());
        string.append(" ");
        string.append("Min Range: ");
        string.append(getMinRange());
        string.append(" ");
        return string.toString();

    }

}
