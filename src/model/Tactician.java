package model;

import controller.GameController;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.IUnit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.max;

/**
 * Class representing the player of the game
 * @author Maximo Retamal
 * @version 1.0
 * @since 2.0
 */
public class Tactician {
    private String name;
    private List<IUnit> units;
    private GameController controller;
    private Field field;
    private IUnit selectedUnit;

    public Tactician(String name, GameController controller, Field field) {
        this.name = name;
        this.controller = controller;
        this.field = field;
        this.units = new ArrayList<>();
        this.selectedUnit = null;
    }

    /**
     * returns units info as string
     * @param unit unit to read
     * @return the info
     */
    public String unitToString(IUnit unit) {
        StringBuilder string = new StringBuilder();
        List<IEquipableItem> items = unit.getItems();
        string.append("Class: ");
        string.append(unit.getClass());
        string.append(" \nCurrent Hit Points: ");
        string.append(unit.getCurrentHitPoints());
        string.append(" \nMax Hit Points: ");
        string.append(unit.getHitPoints());
        string.append(" \n Items: \n");
        for (IEquipableItem item : items) {
            string.append(item.asString());
            string.append(" \n");
        }
        string.append(" \n");
        return string.toString();
    }

    /**
     * equip an item to a unit
     * @param unit unit to equip item
     * @param item item to equip
     */
    public void setEquippedItem(IUnit unit, IEquipableItem item) {
        unit.equipItem(item);

    }

    /**
     * makes selected unit use equipped item to target unit
     * @param target the target unit
     */
    public void useItem(IUnit target) {
        selectedUnit.attack(target);
        selectedUnit.heal(target);

    }

    /**
     * Exchanges item between 2 units
     * @param giver unit giving the item
     * @param receiver unit receiving
     * @param item the item being exchange
     */
    public void exchangeItem(IUnit giver, IUnit receiver, IEquipableItem item) {
        giver.exchange(item, receiver);
    }

    public String getName() {
        return name;
    }

    /**
     * removes a unit from the  game
     *
     * @param unit being deleted
     */
    public void deleteDeadUnit(IUnit unit) {
        units.remove(unit);
    }

    public GameController getGameController() {
        return controller;
    }

    public void setSelectUnit(IUnit unit) {
        if (unit.getTactician().equals(this))
            selectedUnit = unit;
    }

    public IUnit getSelectedUnit() {
        return selectedUnit;
    }

    /**
     * @param army adds units to the tactician
     */
    public void addUnits(IUnit... army) {
        this.units.addAll(Arrays.asList(army).subList(0, max(0, army.length)));
        for (IUnit units : units) {
            units.setTactician(this);
        }
    }
}
