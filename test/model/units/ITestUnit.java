package model.units;


import model.items.*;
import model.items.books.Anima;
import model.items.books.Darkness;
import model.items.books.Light;
import model.map.Field;
import org.junit.jupiter.api.Test;

/**
 * Interface that defines the common behaviour of all the test for the units classes
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface ITestUnit {

  /**
   * Set up the game field
   */
  void setField();

 void setTargetUnits();

 /**
   * Set up the main unit that's going to be tested in the test set
   */
  void setTestUnit();

 /**
   * Creates a set of testing weapons
   */
  void setWeapons();

  /**
   * Checks that the constructor works properly.
   */
  @Test
  void constructorTest();

  /**
   * @return the current unit being tested
   */
  IUnit getTestUnit();

 Archer getTargetArcher();

 Cleric getTargetCleric();

 Fighter getTargetFighter();

 Hero getTargetHero();

 Sorcerer getTargetSorcerer();

 SwordMaster getTargetSwordMaster();

 @Test
  void equipAnimaTest();

  @Test
  void equipDarknessTest();

  @Test
  void equipLightTest();

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Test
  void equipAxeTest();

  /**
   * Tries to equip a weapon to the alpaca and verifies that it was not equipped
   *
   * @param item
   *     to be equipped
   */
  void checkEquippedItem(IEquipableItem item);


  void checkWrongEquippedItem(IEquipableItem item);



  /**
   * @return the test axe
   */
  Axe getAxe();

  @Test
  void equipSwordTest();

  /**
   * @return the test sword
   */
  Sword getSword();

  @Test
  void equipSpearTest();

  /**
   * @return the test spear
   */
  Spear getSpear();

  @Test
  void equipStaffTest();

  /**
   * @return the test staff
   */
  Staff getStaff();

  @Test
  void equipBowTest();

 Anima getAnima();

 Darkness getDarkness();

 /**
   * @return the test bow
   */
  Bow getBow();

 Light getLight();

 /**
   * Checks if the unit moves correctly
   */
  @Test
  void testMovement();

  /**
   * @return the test field
   */
  Field getField();

  /**
   * @return the target Alpaca
   */
  Alpaca getTargetAlpaca();

 @Test
  void checkStrongStrongCombat(IEquipableItem itemForThis, IEquipableItem itemForUnit, IUnit unit);

  @Test
 void checkNormalNormalCombat(IEquipableItem itemForThis, IEquipableItem itemForUnit, IUnit unit);

  @Test
  void checkWeakWeakCombat(IEquipableItem itemForThis, IEquipableItem itemForUnit, IUnit unit);

 void checkStrongWeakCombat(IEquipableItem itemForThis, IEquipableItem itemForUnit, IUnit unit);

 void checkWeakStrongCombat(IEquipableItem itemForThis, IEquipableItem itemForUnit, IUnit unit);

 void checkUnilateralCombat(IEquipableItem itemForThis, IUnit unit);

 // @Test
 // public abstract void checkCombat();
 //
  @Test
  void checkExchange();
}
