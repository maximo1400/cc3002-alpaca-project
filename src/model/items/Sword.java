package model.items;

import model.units.IUnit;

/**
 * This class represents a sword type item.
 * <p>
 * Swords are strong against axes and magical items but weak against spears.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Sword extends AbstractItem {

    /**
     * Creates a new Sword.
     *
     * @param name     the name that identifies the weapon
     * @param power    the base damage pf the weapon
     * @param minRange the minimum range of the weapon
     * @param maxRange the maximum range of the weapon
     */
    public Sword(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void equip(IUnit unit) {
        unit.equipSword(this);
    }


    @Override
    public void attackUnit(IEquipableItem item) {
        item.receiveSwordAttack(this);
    }

    @Override
    public boolean isWeapon() {
        return true;
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
        this.getOwner().receiveWeakAttack(item);
    }

    @Override
    public void receiveBowAttack(IEquipableItem item) {
        this.getOwner().receiveNormalAttack(item);
    }

    @Override
    public void receiveSpearAttack(IEquipableItem item) {
        this.getOwner().receiveStrongAttack(item);
    }

    @Override
    public void receiveSwordAttack(IEquipableItem item) {
        this.getOwner().receiveNormalAttack(item);
    }

    @Override
    public void getUsed(IUnit target) {
        this.getOwner().attack(target);
    }

}
