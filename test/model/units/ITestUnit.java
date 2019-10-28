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

    /**
     * sets auxiliary units for testing
     */
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

    /**
     * @return the test archer
     */
    Archer getTargetArcher();

    /**
     * @return the test cleric
     */
    Cleric getTargetCleric();

    /**
     * @return the test fighter
     */
    Fighter getTargetFighter();

    /**
     * @return the test hero
     */
    Hero getTargetHero();

    /**
     * @return the test sorcerer
     */
    Sorcerer getTargetSorcerer();

    /**
     * @return the test swordMaster
     */
    SwordMaster getTargetSwordMaster();

    /**
     * tests equipping anima
     */
    @Test
    void equipAnimaTest();

    /**
     * test equipping darkness
     */
    @Test
    void equipDarknessTest();

    /**
     * test equipping light
     */
    @Test
    void equipLightTest();

    /**
     * Checks if the axe is equipped correctly to the unit
     */
    @Test
    void equipAxeTest();

    /**
     * Does testing with item that can be equipped
     *
     * @param item to be equipped
     */
    void checkEquippedItem(IEquipableItem item);

    /**
     * Does testing with item that can't be equipped
     *
     * @param item to be equipped
     */
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

    /**
     * test equipping bow
     */
    @Test
    void equipBowTest();

    /**
     * @return the test anima
     */
    Anima getAnima();

    /**
     * @return the test darkness
     */
    Darkness getDarkness();

    /**
     * @return the test bow
     */
    Bow getBow();

    /**
     * @return the test light
     */
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

    /**
     * test attack in strong attack vs strong attack scenario
     *
     * @param itemForThis test unit weapon
     * @param itemForUnit units weapon
     * @param unit        unit to attack
     */
    @Test
    void checkStrongStrongCombat(IEquipableItem itemForThis, IEquipableItem itemForUnit, IUnit unit);

    /**
     * test attack in normal attack vs normal attack scenario
     *
     * @param itemForThis test unit weapon
     * @param itemForUnit units weapon
     * @param unit        unit to attack
     */
    @Test
    void checkNormalNormalCombat(IEquipableItem itemForThis, IEquipableItem itemForUnit, IUnit unit);

    /**
     * test attack in weak attack vs normal weak scenario
     *
     * @param itemForThis test unit weapon
     * @param itemForUnit units weapon
     * @param unit        unit to attack
     */
    @Test
    void checkWeakWeakCombat(IEquipableItem itemForThis, IEquipableItem itemForUnit, IUnit unit);

    /**
     * test attack in strong attack vs weak attack scenario
     *
     * @param itemForThis test unit weapon
     * @param itemForUnit units weapon
     * @param unit        unit to attack
     */
    @Test
    void checkStrongWeakCombat(IEquipableItem itemForThis, IEquipableItem itemForUnit, IUnit unit);

    /**
     * test attack in weak attack vs strong attack scenario
     *
     * @param itemForThis test unit weapon
     * @param itemForUnit units weapon
     * @param unit        unit to attack
     */
    @Test
    void checkWeakStrongCombat(IEquipableItem itemForThis, IEquipableItem itemForUnit, IUnit unit);

    /**
     * test attack to unit that cannot defend
     *
     * @param itemForThis test unit weapon
     * @param unit        unit to attack
     */
    @Test
    void checkUnilateralCombat(IEquipableItem itemForThis, IUnit unit);

    /**
     * test attacking cleric with books
     *
     * @param itemForThis test unit weapon
     */
    @Test
    void checkMagicToClericCombat(IEquipableItem itemForThis);

    /**
     * checks exchange between units
     */
    @Test
    void checkExchange();

    /**
     * Test healing capabilities of units
     */
    @Test
    void TestHealing();
}
