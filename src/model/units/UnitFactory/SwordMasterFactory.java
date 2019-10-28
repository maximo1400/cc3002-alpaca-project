package model.units.UnitFactory;

import model.Tactician;
import model.items.IEquipableItem;
import model.map.Location;
import model.units.IUnit;
import model.units.SwordMaster;

import java.util.ArrayList;
import java.util.List;

public class SwordMasterFactory extends AbstractUnitFactory {
    protected List<IEquipableItem> items = new ArrayList<>();
    private  int hitPoints;
    private int currentHitPoints;
    private  int movement;
    private IEquipableItem equippedItem;
    private Location location;
    private Tactician tactician;
    private IEquipableItem selectedItem;
    /**
     * Creates a new Unit.
     *
     * @param hitPoints the maximum amount of damage a unit can sustain
     * @param movement  the number of panels a unit can move
     * @param location  the current position of this unit on the map
     * @param maxItems  maximum amount of items this unit can carry
     * @param tactician
     * @param items
     */
    protected SwordMasterFactory(int hitPoints, int movement, Location location, int maxItems, Tactician tactician, IEquipableItem... items) {
        super(hitPoints, movement, location, maxItems, tactician, items);
    }

    @Override
    public IUnit create() {
        IUnit unit = new SwordMaster(hitPoints,movement,location);
        for (IEquipableItem item:items) {
            unit.addToInventory(item);
        }
        return unit;
    }
}
