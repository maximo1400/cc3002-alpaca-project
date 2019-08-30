package model.units;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.items.IEquipableItem;
import model.map.Location;

/**
 * This class represents an abstract unit.
 * <p>
 * An abstract unit is a unit that cannot be used in the
 * game, but that contains the implementation of some of the methods that are common for most
 * units.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractUnit implements IUnit {

  protected final List<IEquipableItem> items = new ArrayList<>();
  private final int currentHitPoints;
  private final int movement;
  protected IEquipableItem equippedItem;
  private Location location;

  /**
   * Creates a new Unit.
   *
   * @param hitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   * @param location
   *     the current position of this unit on the map
   * @param maxItems
   *     maximum amount of items this unit can carry
   */
  protected AbstractUnit(final int hitPoints, final int movement,
      final Location location, final int maxItems, final IEquipableItem... items) {
    this.currentHitPoints = hitPoints;
    this.movement = movement;
    this.location = location;
    this.items.addAll(Arrays.asList(items).subList(0, min(maxItems, items.length)));
  }

  @Override
  public int getCurrentHitPoints() {
    return currentHitPoints;
  }

  @Override
  public List<IEquipableItem> getItems() {
    return List.copyOf(items);
  }

  @Override
  public IEquipableItem getEquippedItem() {
    return equippedItem;
  }

  @Override
  public void setEquippedItem(final IEquipableItem item) {
    this.equippedItem = item;
  }

  @Override
  public void removeItem(IEquipableItem item){
    this.items.remove(item);
  }

  @Override
  public Location getLocation() {
    return location;
  }

  @Override
  public void setLocation(final Location location) {
    this.location = location;
  }

  @Override
  public int getMovement() {
    return movement;
  }

  @Override
  public void moveTo(final Location targetLocation) {
    if (getLocation().distanceTo(targetLocation) <= getMovement()
        && targetLocation.getUnit() == null) {
      setLocation(targetLocation);
    }
  }
  @Override
  public void equipItem(IEquipableItem item){
    item.equip(this);
  }

    @Override
    public boolean canExchange(IUnit unit) {
      return unit.canReceiveItem() && this.getLocation().distanceTo(unit.getLocation()) == 1;
    }
    @Override
    public boolean canReceiveItem(){
      return this.getItems().size()<=3;
    }


    @Override
    public void exchange(IEquipableItem item, IUnit unit){
      if(this.canExchange(unit)){
        item.setOwner(unit);
        this.removeItem(item);
      }
    }
    @Override
    public boolean canAttack(IUnit unit){
      if(getEquippedItem()!=null && this.getCurrentHitPoints()>0 && unit.getCurrentHitPoints()>0)
        return this.getEquippedItem().isWeapon();
      return false;
    }
    @Override
  public void attack(IUnit unit){
      if(this.canAttack(unit))
        this.getEquippedItem().AttackUnit(unit);
      if(unit.canAttack(this))
        unit.getEquippedItem().AttackUnit(this);
    }
}
