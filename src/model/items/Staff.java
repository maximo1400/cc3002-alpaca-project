package model.items;

import model.units.IUnit;

/**
 * This class represents a <i>Staff</i> type item.
 * <p>
 * A staff is an item that can heal other units nut cannot counter any attack
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Staff extends AbstractItem {

    /**
     * Creates a new Staff item.
     *
     * @param name     the name of the staff
     * @param power    the healing power of the staff
     * @param minRange the minimum range of the staff
     * @param maxRange the maximum range of the staff
     */
    public Staff(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void equip(IUnit unit) {
        unit.equipStaff(this);
    }


    @Override
    public void receiveAnimaAttack(IEquipableItem item) {
        this.getOwner().receiveStrongAttack(item);
    }

    @Override
    public void receiveDarknessAttack(IEquipableItem item) {
        this.getOwner().receiveStrongAttack(item);
    }

    @Override
    public void receiveLightAttack(IEquipableItem item) {
        this.getOwner().receiveStrongAttack(item);
    }

    @Override
    public void receiveAxeAttack(IEquipableItem item) {
        this.getOwner().receiveNormalAttack(item);
    }

    @Override
    public void receiveBowAttack(IEquipableItem item) {
        this.getOwner().receiveNormalAttack(item);
    }

    @Override
    public void receiveSpearAttack(IEquipableItem item) {
        this.getOwner().receiveNormalAttack(item);
    }

    @Override
    public void receiveSwordAttack(IEquipableItem item) {
        this.getOwner().receiveNormalAttack(item);
    }

    @Override
    public void useHealing(IUnit unit) {
        double dist = unit.getLocation().distanceTo(this.getOwner().getLocation());
        if (unit.getLocation().distanceTo(this.getOwner().getLocation()) <= this.getMaxRange() &&
                unit.getLocation().distanceTo(this.getOwner().getLocation()) >= this.getMinRange()) {
            int newCurrentHitPoints = unit.getCurrentHitPoints() + this.getPower();
            unit.setCurrentHitPoints(newCurrentHitPoints);
        }

    }

    @Override
    public void getUsed(IUnit target) {
        this.getOwner().heal(target);
    }

}
