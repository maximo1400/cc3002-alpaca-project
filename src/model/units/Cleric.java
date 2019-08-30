package model.units;

import model.items.*;
import model.items.books.IBook;
import model.map.Location;

/**
 * This class represents a cleric type unit. A cleric can only use staff type weapons, which means
 * that it can receive attacks but can't counter attack any of those.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Cleric extends AbstractUnit {

  /**
   * Creates a new Unit.
   *
   * @param hitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   */
  public Cleric(final int hitPoints, final int movement, final Location location,
      IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }


  @Override
  public boolean canAttack(IUnit unit) {
    return false;
  }

  @Override
  public void equipSpear(Spear spear) {
    // Method body intentionally left empty
  }

  @Override
  public void equipSword(Sword sword) {
    // Method body intentionally left empty
  }

  @Override
  public void equipBook(IBook book) {
    // Method body intentionally left empty
  }

  @Override
  public void equipAxe(Axe axe) {
    // Method body intentionally left empty
  }

  @Override
  public void equipBow(Bow bow) {
    // Method body intentionally left empty
  }

  @Override
  public void equipStaff(Staff staff) {
    this.setEquippedItem(staff);
    staff.setOwner(this);
  }


}
