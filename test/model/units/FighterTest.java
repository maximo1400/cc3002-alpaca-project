package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.Axe;
import model.items.Bow;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 */
public class FighterTest extends AbstractTestUnit {

  private Fighter fighter;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    fighter = new Fighter(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return fighter;
  }

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipAxeTest() {
    checkEquippedItem(axe);
  }
  @Test
  @Override
  public void checkCombat() {
    checkStrongStrongCombat(getAxe(), getLight(), getTargetSorcerer());
    setUp();
    checkStrongStrongCombat(getAxe(), getDarkness(), getTargetSorcerer());
    setUp();
    checkStrongStrongCombat(getAxe(), getAnima(), getTargetSorcerer());
    setUp();
    checkNormalNormalCombat(getAxe(), getBow(), getTargetArcher());
    setUp();
    checkNormalNormalCombat(getAxe(), new Axe("Other Axe", 10, 1, 2), getTargetFighter());
    setUp();
    checkStrongWeakCombat(getAxe(), getSpear(), getTargetHero());
    setUp();
    checkWeakStrongCombat(getAxe(), getSword(), getTargetSwordMaster());
    setUp();
    checkUnilateralCombat(getAxe(), getTargetCleric());
    setUp();
    checkUnilateralCombat(getAxe(), getTargetAlpaca());
  }
}