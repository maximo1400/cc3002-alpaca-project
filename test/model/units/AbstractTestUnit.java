package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import model.items.*;
import model.items.books.Anima;
import model.items.books.Darkness;
import model.items.books.Light;
import model.map.Field;
import model.map.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractTestUnit implements ITestUnit {

  protected Alpaca targetAlpaca;
  protected Bow bow;
  protected Field field;
  protected Axe axe;
  protected Sword sword;
  protected Staff staff;
  protected Spear spear;
  protected Anima anima;
  protected Darkness darkness;
  protected Light light;
  protected NullItem nullItem;

  @Override
  public void setTargetAlpaca() {
    targetAlpaca = new Alpaca(50, 2, field.getCell(1, 0));
  }

  /**
   * Sets up the units and weapons to be tested
   */
  @BeforeEach
  public void setUp() {
    setField();
    setTestUnit();
    setTargetAlpaca();
    setWeapons();
  }

  /**
   * Set up the game field
   */
  @Override
  public void setField() {
    this.field = new Field();
    this.field.addCells(true, new Location(0, 0), new Location(0, 1), new Location(0, 2),
        new Location(1, 0), new Location(1, 1), new Location(1, 2), new Location(2, 0),
        new Location(2, 1), new Location(2, 2));
  }

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public abstract void setTestUnit();

  /**
   * Creates a set of testing weapons
   */
  @Override
  public void setWeapons() {
    this.axe = new Axe("Axe", 10, 1, 2);
    this.sword = new Sword("Sword", 10, 1, 2);
    this.spear = new Spear("Spear", 10, 1, 2);
    this.staff = new Staff("Staff", 10, 1, 2);
    this.bow = new Bow("Bow", 10, 2, 3);
    this.anima = new Anima("AnimaBook", 10, 1, 3);
    this.darkness = new Darkness("DarknessBook", 10, 1, 3);
    this.light = new Light("LightBook", 10, 1, 3);
    this.nullItem= new NullItem();
  }

  /**
   * Checks that the constructor works properly.
   */
  @Override
  @Test
  public void constructorTest() {
    assertEquals(50, getTestUnit().getCurrentHitPoints());
    assertEquals(2, getTestUnit().getMovement());
    assertEquals(new Location(0, 0), getTestUnit().getLocation());
    assertTrue(getTestUnit().getItems().isEmpty());
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public abstract IUnit getTestUnit();

//  /**
//   * Checks if the axe is equipped correctly to the unit
//   */
//

  /**
   * Tries to equip a weapon to the alpaca and verifies that it was not equipped
   *
   * @param item
   *     to be equipped
   */
  @Override
  public void checkEquippedItem(IEquipableItem item) {
    assertEquals(getTestUnit().getEquippedItem().getClass(),nullItem.getClass());
    getTestUnit().equipItem(item);
    assertEquals(getTestUnit().getEquippedItem().getClass(),nullItem.getClass());
    item.setOwner(getTestUnit());
    getTestUnit().getItems().add(item);
    getTestUnit().equipItem(item);
    assertEquals(getTestUnit().getEquippedItem().getClass(),nullItem.getClass());
    item.setOwner(null);
    getTestUnit().setEquippedItem(nullItem);
  }
  @Override
  public void checkWrongEquippedItem(IEquipableItem item){
    assertEquals(getTestUnit().getEquippedItem().getClass(),nullItem.getClass());
    getTestUnit().equipItem(item);
    assertEquals(getTestUnit().getEquippedItem().getClass(),nullItem.getClass());
    item.setOwner(getTestUnit());
    getTestUnit().getItems().add(item);
    getTestUnit().equipItem(item);
    assertEquals(getTestUnit().getEquippedItem().getClass(),nullItem.getClass());
    item.setOwner(null);
    getTestUnit().setEquippedItem(nullItem);
  }

  /**
   * @return the test axe
   */
  @Override
  public Axe getAxe() {
    return axe;
  }

  /**
   * @return the test sword
   */
  @Override
  public Sword getSword() {
    return sword;
  }

  /**
   * @return the test spear
   */
  @Override
  public Spear getSpear() {
    return spear;
  }

  /**
   * @return the test staff
   */
  @Override
  public Staff getStaff() {
    return staff;
  }

  /**
   * @return the test bow
   */
  @Override
  public Bow getBow() {
    return bow;
  }

  /**
   * Checks if the unit moves correctly
   */
  @Override
  @Test
  public void testMovement() {
    getTestUnit().moveTo(getField().getCell(2, 2));
    assertEquals(new Location(0, 0), getTestUnit().getLocation());

    getTestUnit().moveTo(getField().getCell(0, 2));
    assertEquals(new Location(0, 2), getTestUnit().getLocation());

    getField().getCell(0, 1).setUnit(getTargetAlpaca());
    getTestUnit().moveTo(getField().getCell(0, 1));
    assertEquals(new Location(0, 2), getTestUnit().getLocation());
  }

  /**
   * @return the test field
   */
  @Override
  public Field getField() {
    return field;
  }

  /**
   * @return the target Alpaca
   */
  @Override
  public Alpaca getTargetAlpaca() {
    return targetAlpaca;
  }


  @Override
  @Test
  public void equipAnimaTest() {
    checkWrongEquippedItem(anima);
  }
  @Override
  @Test
  public void equipDarknessTest() {
    checkWrongEquippedItem(darkness);
  }
  @Override
  @Test
  public void equipLightTest() {
    checkWrongEquippedItem(light);
  }
  @Override
  @Test
  public void equipAxeTest() {
    checkWrongEquippedItem(axe);
  }
  @Override
  @Test
  public void equipBowTest() {
    checkWrongEquippedItem(bow);
  }
  @Override
  @Test
  public void equipSpearTest() {
    checkWrongEquippedItem(spear);
  }
  @Override
  @Test
  public void equipStaffTest() {
    checkWrongEquippedItem(staff);
  }
  @Override
  @Test
  public void equipSwordTest() {
    checkWrongEquippedItem(sword);
  }


}
