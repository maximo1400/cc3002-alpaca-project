package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.Bow;
import model.items.Spear;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 */
public class HeroTest extends AbstractTestUnit {

  private Hero hero;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @BeforeEach
  @Override
  public void setTestUnit() {
    hero = new Hero(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return hero;
  }


  @Test
  @Override
  public void equipSpearTest() {
   checkEquippedItem(spear);
  }
  @Test
  @Override
  public void checkCombat(){
    checkStrongStrongCombat(getSpear(), getLight(),getTargetSorcerer());setUp();
    checkStrongStrongCombat(getSpear(), getDarkness(),getTargetSorcerer());setUp();
    checkStrongStrongCombat(getSpear(),getAnima(),getTargetSorcerer());setUp();
    checkNormalNormalCombat(getSpear(),getBow(),getTargetArcher());setUp();
    checkWeakStrongCombat(getSpear(),getAxe(),getTargetFighter());setUp();
    checkNormalNormalCombat(getSpear(),new Spear("Other Spear", 10, 1, 2),getTargetHero());setUp();
    checkStrongWeakCombat(getSpear(),getSword(),getTargetSwordMaster());setUp();
    checkUnilateralCombat(getSpear(),getTargetCleric());setUp();
    checkUnilateralCombat(getSpear(),getTargetAlpaca());
  }
}