package model.items.books;

import model.items.IEquipableItem;

/**
 *  This class represents an Anima Book
 *  Anima is strong against Light and non magic items and weak against Darkness
 *
 * @author  Maximo Retamal Rojas
 * @since 2.0
 */
public class Anima extends AbstractBook{
    /**
     * Constructor for a Anima kind of weapon/book.
     *
      *@param name     the name of the Book
      * @param power    the power of the item (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the Book
     * @param maxRange the maximum range of the Book
     */
    public Anima(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void attackUnit(IEquipableItem item) {
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
