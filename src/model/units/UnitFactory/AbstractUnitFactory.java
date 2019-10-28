package model.units.UnitFactory;


import model.Tactician;
import model.items.IEquipableItem;
import model.items.NullItem;
import model.map.Location;
import model.units.IUnit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.min;

public abstract class AbstractUnitFactory implements IUnitFactory {
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
     */
    protected AbstractUnitFactory(final int hitPoints, final int movement,
                                  final Location location, final int maxItems, Tactician tactician, IEquipableItem... items) {
        this.currentHitPoints = hitPoints;
        this.hitPoints = hitPoints;
        this.movement = movement;
        this.location = location;
        this.items.addAll(Arrays.asList(items).subList(0, min(maxItems, items.length)));
        this.equippedItem = new NullItem();
        this.tactician = tactician;
    }
}
