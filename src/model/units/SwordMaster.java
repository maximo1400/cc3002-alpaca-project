package model.units;

import model.items.*;
import model.items.books.IBook;
import model.map.Location;

/**
 * This class represents a <i>SwordMaster</i> type unit.
 * <p>
 * A <i>SwordMaster</i> is a unit that <b>can only use sword type weapons</b>.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class SwordMaster extends AbstractUnit {

  public SwordMaster(final int hitPoints, final int movement, final Location location, IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
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
  public void equipSpear(Spear spear) {
    // Method body intentionally left empty

  }

  @Override
  public void equipStaff(Staff staff) {
// Method body intentionally left empty
  }

  @Override
  public void equipSword(Sword sword) {
    this.setEquippedItem(sword);
    sword.setOwner(this);
  }

  @Override
  public void equipBook(IBook book) {
// Method body intentionally left empty
  }

}
