package model.items.books;

import model.items.IEquipableItem;

public class Anima extends AbstractBook{
    /**
     * Constructor for a default item without any special behaviour.
     *
     * @param name     the name of the item
     * @param power    the power of the item (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the item
     * @param maxRange the maximum range of the item
     */
    public Anima(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void AttackUnit(IEquipableItem item) {
        item.receiveAnimaAttack(this);
    }

    @Override
    public boolean isWeapon() {
        return true;
    }

    @Override
    public void receiveAnimaAttack(IEquipableItem item) {
        this.getOwner().receiveNormalAttack(item);
    }

    @Override
    public void receiveDarknessAttack(IEquipableItem item) {
        this.getOwner().receiveStrongAttack(item);
    }

    @Override
    public void receiveLightAttack(IEquipableItem item) {
        this.getOwner().receiveWeakAttack(item);
    }

    @Override
    public void receiveAxeAttack(IEquipableItem item) {
        this.getOwner().receiveStrongAttack(item);
    }

    @Override
    public void receiveBowAttack(IEquipableItem item) {
        this.getOwner().receiveStrongAttack(item);
    }

    @Override
    public void receiveSpearAttack(IEquipableItem item) {
        this.getOwner().receiveStrongAttack(item);
    }

    @Override
    public void receiveSwordAttack(IEquipableItem item) {
        this.getOwner().receiveStrongAttack(item);
    }
}
