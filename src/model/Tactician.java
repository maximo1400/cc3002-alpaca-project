package model;

import controller.GameController;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.IUnit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.max;

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

    public void setEquippedItem(IUnit unit, IEquipableItem item) {
        unit.equipItem(item);

    }

    public void useItem(IUnit target) {
        selectedUnit.attack(target);
        selectedUnit.heal(target);

    }

    public void exchangeItem(IUnit giver, IUnit receiver, IEquipableItem item) {
        giver.exchange(item, receiver);
    }

    public String getName() {
        return name;
    }

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

    public void addUnits(IUnit... army) {
        this.units.addAll(Arrays.asList(army).subList(0, max(0, army.length)));
        for (IUnit units : units) {
            units.setTactician(this);
        }
    }
}
