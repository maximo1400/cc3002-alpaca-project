package model.items;

import model.units.IUnit;

/**
 * This interface represents the <i>weapons</i> that the units of the game can use.
 * <p>
 * The signature for all the common methods of the weapons are defined here. Every weapon have a
 * base damage and is strong or weak against other type of weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface IEquipableItem {

    /**
     * Equips this item to a unit.
     *
     * @param unit the unit that will be quipped with the item
     */
    void equip(IUnit unit);

    /**
     * @return the unit that has currently equipped this item
     */
    IUnit getOwner();

    /**
     * Sets the unit that has currently equipped this item
     *
     * @param unit the unit that the item is equipped onto
     */
    void setOwner(IUnit unit);

    /**
     * @return the name of the item
     */
    String getName();

    /**
     * @return the power of the item
     */
    int getPower();

    /**
     * @return the minimum range of the item
     */
    int getMinRange();

    /**
     * @return the maximum range of the item
     */
    int getMaxRange();


    /**
     * Attacks an unit through its equipped item
     *
     * @param item the item equipped by the attacked
     */
    void attackUnit(IEquipableItem item);

    /**
     * @return true if the item can attack (only weapons can attack)
     */
    boolean isWeapon();

    /**
     * the owner receives an anima attack by the item
     *
     * @param item the attacking item
     */
    void receiveAnimaAttack(IEquipableItem item);

    /**
     * the owner receives an anima attack by the item
     *
     * @param item the attacking item
     */
    void receiveDarknessAttack(IEquipableItem item);

    /**
     * the owner receives an darkness attack by the item
     *
     * @param item the attacking item
     */
    void receiveLightAttack(IEquipableItem item);

    /**
     * the owner receives an light attack by the item
     *
     * @param item the attacking item
     */
    void receiveAxeAttack(IEquipableItem item);

    /**
     * the owner receives an bow attack by the item
     *
     * @param item the attacking item
     */
    void receiveBowAttack(IEquipableItem item);

    /**
     * the owner receives an spear attack by the item
     *
     * @param item the attacking item
     */
    void receiveSpearAttack(IEquipableItem item);

    /**
     * the owner receives an sword attack by the item
     *
     * @param item the attacking item
     */
    void receiveSwordAttack(IEquipableItem item);

    /**
     * Heals unit if used by healing item
     *
     * @param unit Unit to be healed
     */
    void useHealing(IUnit unit);

    String asString();

    void getUsed(IUnit target);
}
