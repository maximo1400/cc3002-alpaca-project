package model.units;

import model.items.*;
import model.items.books.IBook;
import model.map.Location;

import java.util.List;

/**
 * This interface represents all units in the game.
 * <p>
 * The signature of all the common methods that a unit can execute are defined here. All units
 * except some special ones can carry at most 3 weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface IUnit {

  /**
   * Sets the currently equipped item of this unit.
   *
   * @param item
   *     the item to equip
   */
  void setEquippedItem(IEquipableItem item);



  /**
   * @return hit points of the unit
   */
  int getCurrentHitPoints();

 /**
  * @param life Life to be set as currentHitPoints to unit
  */
  void setCurrentHitPoints(int life);

  /**
   * @return the items carried by this unit
   */
  List<IEquipableItem> getItems();

 /**
   * @return the currently equipped item
   */
  IEquipableItem getEquippedItem();


  /**
   * @return the current location of the unit
   */
  Location getLocation();

  /**
   * Sets a new location for this unit,
   */
  void setLocation(final Location location);

  /**
   * @return the number of cells this unit can move
   */
  int getMovement();

  /**
   * Moves this unit to another location.
   * <p>
   * If the other location is out of this unit's movement range, the unit doesn't move.
   */
  void moveTo(Location targetLocation);


 /**
  * attacks an unit
  * @param unit unit to be attacked
  */
  void attack(IUnit unit);

 /**
  * checks if the attack checks the requirements
  * @param unit unit to be attacked
  * @return true if the attack can happen false if not
  */
  boolean canAttack(IUnit unit);

 /**
  * checks if 2 units can exchange items
  * @param unit unit to exchange item
  * @return true if they can
  */
  boolean canExchange(IUnit unit);

 /**
  * tries to exchange an item
  * @param item item to be exchanged
  * @param unit unit that receives item
  */
  void exchange(IEquipableItem item, IUnit unit);

 /**
  * removes item from inventory (but doesn't check if it's equioped)=
  * @param item item to be removed
  */
  void removeFromInventory(IEquipableItem item);

 /**
  * adds item to inventory
  * @param item item to be added
  */
 void addToInventory(IEquipableItem item);

 /**
  * starts process to equip item
  * @param item the item to be equipped
  */
 void equipItem(IEquipableItem item);

 /**
  * tries to equip spear
  * @param spear the spear to be equipped
  */
  void equipSpear(Spear spear);

 /**
  * tries to equip sword
  * @param sword the sword to be equipped
  */
  void equipSword(Sword sword);

 /**
  * tries to equip book
  * @param book the book to be equipped
  */
  void equipBook(IBook book);

 /**
  * tries to equip axe
  * @param axe the axe to be equipped
  */
  void equipAxe(Axe axe);

 /**
  * tries to equip bow
  * @param bow the bow to be equipped
  */
  void equipBow(Bow bow);

 /**
  * tries to equip staff
  * @param staff the staff to be equipped
  */
  void equipStaff(Staff staff);

 /**
  * checks if unit can receive item
  * @return true if unit can receive item
  */
  boolean canReceiveItem();

 /**
  * takes 1.5 times the power of the item to the life of the unit
  * @param item the attacking item
  */
  void receiveStrongAttack(IEquipableItem item);
 /**
  * takes the power of the item to the life of the unit
  * @param item the attacking item
  */
  void receiveNormalAttack(IEquipableItem item);
 /**
  * takes  the power of the item -20 to the life of the unit
  * @param item the attacking item
  */
  void receiveWeakAttack(IEquipableItem item);

 /**
  * Heals if possible target unit
  * @param unit the unit to be healed
  */
 void heal(IUnit unit);
}
