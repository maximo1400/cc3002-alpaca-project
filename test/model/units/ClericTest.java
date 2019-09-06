package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ignacio Slater Muñoz
 */
public class ClericTest extends AbstractTestUnit {

  private Cleric cleric;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    cleric = new Cleric(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return cleric;
  }

  @Test
  @Override
  public void equipStaffTest() {
    checkEquippedItem(staff);
  }

  @Test
  @Override
  public void checkCombat() {
    // Method body intentionally left empty
  }
  @Override
  @Test
  public void TestHealing(){
    targetAlpaca.moveTo(getField().getCell(0,0));
    getTestUnit().moveTo(getField().getCell(0,1));
    int life=targetAlpaca.getCurrentHitPoints();
    getTestUnit().heal(targetAlpaca);
    assertEquals(life,targetAlpaca.getCurrentHitPoints());
    getTestUnit().addToInventory(staff);
    getTestUnit().equipItem(staff);
    getTestUnit().heal(targetAlpaca);
    assertEquals(life+staff.getPower(),targetAlpaca.getCurrentHitPoints());
  }

}