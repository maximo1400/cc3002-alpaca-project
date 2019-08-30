package model.units;

import model.items.*;
import model.items.books.IBook;
import model.map.Location;

/**
 * This class represents a fighter type unit.
 * A fighter is a unit that can only use axe type weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Fighter extends AbstractUnit {

  public Fighter(final int hitPoints, final int movement, final Location location,
      IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
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
    this.setEquippedItem(axe);
    axe.setOwner(this);
  }

  @Override
  public void equipBow(Bow bow) {
    // Method body intentionally left empty
  }

  @Override
  public void equipStaff(Staff staff) {
    // Method body intentionally left empty
  }


}
