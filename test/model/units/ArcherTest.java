package model.units;

import model.items.Bow;
import org.junit.jupiter.api.Test;

/**
 * Test set for the Archer unit.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class ArcherTest extends AbstractTestUnit {

    private Archer archer;

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    @Override
    public void setTestUnit() {
        archer = new Archer(50, 2, field.getCell(0, 0));
    }

    /**
     * @return the current unit being tested
     */
    @Override
    public IUnit getTestUnit() {
        return archer;
    }

    /**
     * Checks if the bow is equipped correctly to the unit
     */
    @Test
    @Override
    public void equipBowTest() {
        checkEquippedItem(bow);
    }

    @Test
    @Override
    public void checkCombat() {
        checkStrongStrongCombat(getBow(), getLight(), getTargetSorcerer());
        setUp();
        checkStrongStrongCombat(getBow(), getDarkness(), getTargetSorcerer());
        setUp();
        checkStrongStrongCombat(getBow(), getAnima(), getTargetSorcerer());
        setUp();
        checkNormalNormalCombat(getBow(), new Bow("Other Bow", 8, 2, 4), getTargetArcher());
        setUp();
        checkNormalNormalCombat(getBow(), getAxe(), getTargetFighter());
        setUp();
        checkNormalNormalCombat(getBow(), getSpear(), getTargetHero());
        setUp();
        checkNormalNormalCombat(getBow(), getSword(), getTargetSwordMaster());
        setUp();
        targetCleric.addToInventory(getStaff());
        targetCleric.equipItem(getStaff());
        checkUnilateralCombat(getBow(), getTargetCleric());
        setUp();
        checkUnilateralCombat(getBow(), getTargetAlpaca());

    }
}