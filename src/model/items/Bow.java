package model.items;

import model.units.IUnit;

/**This class represents an bow.
 * <p>
 * bows are srong against magical items
 *
 * @author Ignacio Slater Muñoz
 * @since
 */
public class Bow extends AbstractItem {

  /**
   * Creates a new bow.
   * <p>
   * Bows are weapons that can't attack adjacent units, so it's minimum range must me greater than
   * one.
   *
   * @param name
   *     the name of the bow
   * @param power
   *     the damage power of the bow
   * @param minRange
   *     the minimum range of the bow
   * @param maxRange
   *     the maximum range of the bow
   */
  public Bow(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
    this.minRange = Math.max(minRange, 2);
    this.maxRange = Math.max(maxRange, this.minRange);
  }
  @Override
  public void equip(IUnit unit) {
    unit.equipBow(this);

  }


 @Override
  public void attackUnit(IEquipableItem item) {
    item.receiveBowAttack(this);
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
