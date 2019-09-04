package model.units;

import model.items.Bow;
import model.items.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Ignacio Slater Muñoz
 */
public class SwordMasterTest extends AbstractTestUnit {

  private SwordMaster swordMaster;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    swordMaster = new SwordMaster(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return swordMaster;
  }

  @Test
  @Override
  public void equipSwordTest() {
   checkEquippedItem(sword);
  }
  @Test
  @Override
  public void checkCombat(){
    checkStrongStrongCombat(getSword(), getLight(),getTargetSorcerer());setUp();
    checkStrongStrongCombat(getSword(), getDarkness(),getTargetSorcerer());setUp();
    checkStrongStrongCombat(getSword(),getAnima(),getTargetSorcerer());setUp();
    checkNormalNormalCombat(getSword(),getBow(),getTargetArcher());setUp();
    checkStrongWeakCombat(getSword(),getAxe(),getTargetFighter());setUp();
    checkWeakStrongCombat(getSword(),getSpear(),getTargetHero());setUp();
    checkNormalNormalCombat(getSword(),new Sword("Other sword", 10, 1, 2),getTargetSwordMaster());setUp();
    checkUnilateralCombat(getSword(),getTargetCleric()); setUp();
    checkUnilateralCombat(getSword(),getTargetAlpaca());
  }
}