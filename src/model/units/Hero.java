package model.units;

import model.items.*;
import model.items.books.AbstractBook;
import model.items.books.IBook;
import model.map.Location;

import java.awt.print.Book;

/**
 * A <i>Hero</i> is a special kind of unit, the player that defeats this unit wins the game.
 * <p>
 * This unit <b>can only use spear weapons</b>.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Hero extends AbstractUnit {

  /**
   * Creates a new Unit.
   *
   * @param hitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   */
  public Hero(final int hitPoints, final int movement, final Location location,
      IEquipableItem... items) {
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
    this.equipItem(spear);
  }

  @Override
  public void equipStaff(Staff staff) {
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
  public void giveItem(IUnit unit) {

  }

}
