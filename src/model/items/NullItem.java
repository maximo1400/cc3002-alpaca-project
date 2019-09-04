package model.items;

import model.units.IUnit;

public class NullItem extends AbstractItem {
    /**
     * Constructor for a default item without any special behaviour.

     */
    public NullItem() {
        super("Null Item", 0, 0, 0);
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
    public void AttackUnit(IEquipableItem item) {
        // Method body intentionally left empty
    }

    @Override
    public boolean isWeapon() {
        return false;
    }

    @Override
    public void receiveAnimaAttack(IEquipableItem item) {
        this.getOwner().receiveNormalAttack(item);
    }

    @Override
    public void receiveDarknessAttack(IEquipableItem item) {
        this.getOwner().receiveNormalAttack(item);
    }

    @Override
    public void receiveLightAttack(IEquipableItem item) {
        this.getOwner().receiveNormalAttack(item);
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

}
