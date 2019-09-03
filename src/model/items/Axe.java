package model.items;

import model.units.*;

/**
 * This class represents an Axe.
 * <p>
 * Axes are strong against spears but weak agains swords.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Axe extends AbstractItem {

  /**
   * Creates a new Axe item
   *
   * @param name
   *     the name of the Axe
   * @param power
   *     the damage of the axe
   * @param minRange
   *     the minimum range of the axe
   * @param maxRange
   *     the maximum range of the axe
   */
  public Axe(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }

  @Override
  public void equip(IUnit unit) {
    unit.equipAxe(this);

  }

  @Override
  public boolean canUse(IUnit unit) {
    return false;
  }

  @Override
  public void AttackUnit(IEquipableItem item) {
    item.receiveAxeAttack(this);
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
    this.getOwner().receiveWeakAttack(item);
  }

  @Override
  public void receiveSwordAttack(IEquipableItem item) {
    this.getOwner().receiveStrongAttack(item);
  }

}
