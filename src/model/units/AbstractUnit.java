package model.units;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.items.*;
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
  private final int hitPoints;
  private  int currentHitPoints;
  private final int movement;
  private IEquipableItem equippedItem;
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
    this.hitPoints=hitPoints;
    this.movement = movement;
    this.location = location;
    this.items.addAll(Arrays.asList(items).subList(0, min(maxItems, items.length)));
    this.equippedItem=new NullItem();
    this.equippedItem.setOwner(this);
  }

  @Override
  public int getCurrentHitPoints() {
    return currentHitPoints;
  }

  @Override
  public void setCurrentHitPoints(int life) {
     this.currentHitPoints=life;
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
    if (item.getOwner().equals(this))
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
    Location victim = unit.getLocation();
    double distance= StrictMath.abs(victim.distanceTo(this.getLocation()));
    if(getEquippedItem()!=null && this.getCurrentHitPoints()>0 && unit.getCurrentHitPoints()>0 &&
            this.getEquippedItem().getMaxRange()>=distance && this.getEquippedItem().getMinRange()<=distance)
      return this.getEquippedItem().isWeapon();
    return false;
  }
    @Override
  public void attack(IUnit unit){
      if(this.canAttack(unit)) {
        this.getEquippedItem().AttackUnit(unit.getEquippedItem());
        if (unit.canAttack(this))
          unit.getEquippedItem().AttackUnit(this.getEquippedItem());
      }
    }

    @Override
  public void receiveStrongAttack(IEquipableItem item){
    int life = (int) (this.getCurrentHitPoints()-item.getPower()*1.5);
    this.setCurrentHitPoints(life);
    }

  @Override
  public void receiveNormalAttack(IEquipableItem item){
    int life = this.getCurrentHitPoints()-item.getPower();
    this.setCurrentHitPoints(life);
  }

  @Override
  public void receiveWeakAttack(IEquipableItem item){
    int life =this.getCurrentHitPoints()-(item.getPower()-20);
    this.setCurrentHitPoints(life);
  }
}
