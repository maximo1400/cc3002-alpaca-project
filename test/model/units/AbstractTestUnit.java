package model.units;

import model.items.*;
import model.items.books.Anima;
import model.items.books.Darkness;
import model.items.books.Light;
import model.map.Field;
import model.map.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractTestUnit implements ITestUnit {

 protected Bow bow;
 protected Field field;
 protected Axe axe;
 protected Sword sword;
 protected Staff staff;
 protected Spear spear;
 protected Anima anima;
 protected Darkness darkness;
 protected Light light;
 protected NullItem nullItem;

 public SwordMaster targetSwordMaster;
 public Sorcerer targetSorcerer;
 public Hero targetHero;
 public Fighter targetFighter;
 public Archer targetArcher;
 public Cleric targetCleric;
 public Alpaca targetAlpaca;


 /**
  * Sets up the units and weapons to be tested
  */
 @BeforeEach
 public void setUp() {
  setField();
  setTestUnit();
  setTargetUnits();
  setWeapons();
 }

 /**
  * Set up the game field
  */
 @Override
 public void setField() {
  this.field = new Field();
  this.field.addCells(true, new Location(0, 0), new Location(0, 1), new Location(0, 2),
          new Location(1, 0), new Location(1, 1), new Location(1, 2), new Location(2, 0),
          new Location(2, 1), new Location(2, 2));
 }

 /**
  * sets auxiliary units for testing
  */
 @Override
 public void setTargetUnits(){
  targetAlpaca = new Alpaca(50, 2, field.getCell(0, 2));
  targetArcher = new Archer(50, 2, field.getCell(0, 2));
  targetCleric = new Cleric(50, 2, field.getCell(0, 2));
  targetFighter = new Fighter(50, 2, field.getCell(0, 2));
  targetHero = new Hero(50, 2, field.getCell(0, 2));
  targetSorcerer = new Sorcerer(50, 2, field.getCell(0, 2));
  targetSwordMaster = new SwordMaster(50, 2, field.getCell(0, 2));
 }

 /**
  * Set up the main unit that's going to be tested in the test set
  */
 @Override
 public abstract void setTestUnit();

 /**
  * Creates a set of testing weapons
  */
 @Override
 public void setWeapons() {
  this.axe = new Axe("Axe", 10, 1, 2);
  this.sword = new Sword("Sword", 10, 1, 2);
  this.spear = new Spear("Spear", 10, 1, 2);
  this.staff = new Staff("Staff", 10, 1, 2);
  this.bow = new Bow("Bow", 10, 2, 3);
  this.anima = new Anima("AnimaBook", 10, 1, 3);
  this.darkness = new Darkness("DarknessBook", 10, 1, 3);
  this.light = new Light("LightBook", 10, 1, 3);
  this.nullItem= new NullItem();
 }

 /**
  * Checks that the constructor works properly.
  */
 @Override
 @Test
 public void constructorTest() {
  assertEquals(50, getTestUnit().getCurrentHitPoints());
  assertEquals(2, getTestUnit().getMovement());
  assertEquals(new Location(0, 0), getTestUnit().getLocation());
  assertTrue(getTestUnit().getItems().isEmpty());
 }

 /**
  * @return the current unit being tested
  */
 @Override
 public abstract IUnit getTestUnit();


 /**
  * Does testing with item that can be equipped
  *
  * @param item
  *     to be equipped
  */
 @Override
 public void checkEquippedItem(IEquipableItem item) {
  assertEquals(getTestUnit().getEquippedItem().getClass(),nullItem.getClass());
  getTestUnit().equipItem(item);
  assertEquals(getTestUnit().getEquippedItem().getClass(),nullItem.getClass());
  getTestUnit().addToInventory(item);
  getTestUnit().equipItem(item);
  assertEquals(getTestUnit().getEquippedItem().getClass(),item.getClass());
  getTestUnit().removeFromInventory(item);
  getTestUnit().setEquippedItem(nullItem);
 }
 /**
  * Does testing with item that can't be equipped
  *
  * @param item
  *     to be equipped
  */
 @Override
 public void checkWrongEquippedItem(IEquipableItem item){
  assertEquals(getTestUnit().getEquippedItem().getClass(),nullItem.getClass());
  getTestUnit().equipItem(item);
  assertEquals(getTestUnit().getEquippedItem().getClass(),nullItem.getClass());
  getTestUnit().addToInventory(item);
  getTestUnit().equipItem(item);
  assertEquals(getTestUnit().getEquippedItem().getClass(),nullItem.getClass());
  getTestUnit().removeFromInventory(item);
  getTestUnit().setEquippedItem(nullItem);
 }

 /**
  * @return the test axe
  */
 @Override
 public Axe getAxe() {
  return axe;
 }

 /**
  * @return the test sword
  */
 @Override
 public Sword getSword() {
  return sword;
 }

 /**
  * @return the test spear
  */
 @Override
 public Spear getSpear() {
  return spear;
 }

 /**
  * @return the test staff
  */
 @Override
 public Staff getStaff() {
  return staff;
 }

 /**
  * @return the test bow
  */
 @Override
 public Bow getBow() {
  return bow;
 }
 /**
  * @return the test anima
  */
 @Override
 public Anima getAnima() {
  return anima;
 }

 /**
  * @return the test darkness
  */
 @Override
 public Darkness getDarkness() {
  return darkness;
 }

 /**
  * @return the test light
  */
 @Override
 public Light getLight() {
  return light;
 }

 /**
  * Checks if the unit moves correctly
  */
 @Override
 @Test
 public void testMovement() {
  getTestUnit().moveTo(getField().getCell(2, 2));
  assertEquals(new Location(0, 0), getTestUnit().getLocation());

  getTestUnit().moveTo(getField().getCell(0, 2));
  assertEquals(new Location(0, 2), getTestUnit().getLocation());

  getField().getCell(0, 1).setUnit(getTargetAlpaca());
  getTestUnit().moveTo(getField().getCell(0, 1));
  assertEquals(new Location(0, 2), getTestUnit().getLocation());
 }

 /**
  * @return the test field
  */
 @Override
 public Field getField() {
  return field;
 }

 /**
  * @return the target Alpaca
  */
 @Override
 public Alpaca getTargetAlpaca() {
  return targetAlpaca;
 }

 /**
  * @return the test archer
  */
 @Override
 public Archer getTargetArcher() {
  return targetArcher;
 }

 /**
  * @return the test cleric
  */
 @Override
 public Cleric getTargetCleric() {
  return targetCleric;
 }

 /**
  * @return the test fighter
  */
 @Override
 public Fighter getTargetFighter() {
  return targetFighter;
 }

 /**
  * @return the test hero
  */
 @Override
 public Hero getTargetHero() {
  return targetHero;
 }

 /**
  * @return the test sorcerer
  */
 @Override
 public Sorcerer getTargetSorcerer() {
  return targetSorcerer;
 }

 /**
  * @return the test swordMaster
  */
 @Override
 public SwordMaster getTargetSwordMaster() {
  return targetSwordMaster;
 }


 /**
  * tests equipping anima
  */
 @Override
 @Test
 public void equipAnimaTest() {
  checkWrongEquippedItem(anima);
 }

 /**
  * test equipping darkness
  */
 @Override
 @Test
 public void equipDarknessTest() {
  checkWrongEquippedItem(darkness);
 }

 /**
  * test equipping light
  */
 @Override
 @Test
 public void equipLightTest() {
  checkWrongEquippedItem(light);
 }

 /**
  * tests equipping axe
  */
 @Override
 @Test
 public void equipAxeTest() {
  checkWrongEquippedItem(axe);
 }

 /**
  * test equipping bow
  */
 @Override
 @Test
 public void equipBowTest() {
  checkWrongEquippedItem(bow);
 }

 /**
  * tests equipping spear
  */
 @Override
 @Test
 public void equipSpearTest() {
  checkWrongEquippedItem(spear);
 }

 /**
  * test equipping staff
  */
 @Override
 @Test
 public void equipStaffTest() {
  checkWrongEquippedItem(staff);
 }

 /**
  * tests equiping sword
  */
 @Override
 @Test
 public void equipSwordTest() {
  checkWrongEquippedItem(sword);
 }


 /**
  * test attack in normal attack vs normal attack scenario
  * @param itemForThis test unit weapon
  * @param itemForUnit units weapon
  * @param unit unit to attack
  */
 public void checkNormalNormalCombat(IEquipableItem itemForThis, IEquipableItem itemForUnit, IUnit unit){
  int victimsLife= unit.getCurrentHitPoints();
  int thisLife=getTestUnit().getCurrentHitPoints();

  getTestUnit().attack(unit);
  assertEquals(thisLife,getTestUnit().getCurrentHitPoints());
  assertEquals(victimsLife,unit.getCurrentHitPoints());

  getTestUnit().addToInventory(itemForThis);
  getTestUnit().equipItem(itemForThis);

  getTestUnit().attack(unit);
  assertEquals(thisLife,getTestUnit().getCurrentHitPoints());
  assertEquals(victimsLife-itemForThis.getPower(),unit.getCurrentHitPoints());
  victimsLife=unit.getCurrentHitPoints();

  unit.addToInventory(itemForUnit);
  unit.equipItem(itemForUnit);

  getTestUnit().attack(unit);
  assertEquals(thisLife-itemForUnit.getPower(),getTestUnit().getCurrentHitPoints());
  assertEquals(victimsLife-itemForThis.getPower(),unit.getCurrentHitPoints());

  getTestUnit().removeFromInventory(itemForThis);
  getTestUnit().setEquippedItem(nullItem);
  unit.removeFromInventory(itemForUnit);
  unit.setEquippedItem(nullItem);
 }
 /**
  * test attack in strong attack vs strong attack scenario
  * @param itemForThis test unit weapon
  * @param itemForUnit units weapon
  * @param unit unit to attack
  */
 @Override
 public void checkStrongStrongCombat(IEquipableItem itemForThis, IEquipableItem itemForUnit, IUnit unit){
  int victimsLife= unit.getCurrentHitPoints();
  int thisLife=getTestUnit().getCurrentHitPoints();

  getTestUnit().attack(unit);
  assertEquals(thisLife,getTestUnit().getCurrentHitPoints());
  assertEquals(victimsLife,unit.getCurrentHitPoints());

  getTestUnit().addToInventory(itemForThis);
  getTestUnit().equipItem(itemForThis);

  getTestUnit().attack(unit);
  assertEquals(thisLife,getTestUnit().getCurrentHitPoints());
  assertEquals(victimsLife-itemForThis.getPower(),unit.getCurrentHitPoints());
  victimsLife=unit.getCurrentHitPoints();

  unit.addToInventory(itemForUnit);
  unit.equipItem(itemForUnit);

  getTestUnit().attack(unit);
  assertEquals((int)(thisLife-itemForUnit.getPower()*1.5),getTestUnit().getCurrentHitPoints());
  assertEquals((int)(victimsLife-itemForThis.getPower()*1.5),unit.getCurrentHitPoints());

  getTestUnit().removeFromInventory(itemForThis);
  getTestUnit().setEquippedItem(nullItem);
  unit.removeFromInventory(itemForUnit);
  unit.setEquippedItem(nullItem);
 }
 @Override
 /**
  * test attack in weak attack vs normal weak scenario
  * @param itemForThis test unit weapon
  * @param itemForUnit units weapon
  * @param unit unit to attack
  */
 public void checkWeakWeakCombat(IEquipableItem itemForThis, IEquipableItem itemForUnit, IUnit unit){
  int victimsLife= unit.getCurrentHitPoints();
  int thisLife=getTestUnit().getCurrentHitPoints();

  getTestUnit().attack(unit);
  assertEquals(thisLife,getTestUnit().getCurrentHitPoints());
  assertEquals(victimsLife,unit.getCurrentHitPoints());

  getTestUnit().addToInventory(itemForThis);
  getTestUnit().equipItem(itemForThis);

  getTestUnit().attack(unit);
  assertEquals(thisLife,getTestUnit().getCurrentHitPoints());
  assertEquals(victimsLife-itemForThis.getPower()+20,unit.getCurrentHitPoints());
  victimsLife=unit.getCurrentHitPoints();

  unit.addToInventory(itemForUnit);
  unit.equipItem(itemForUnit);

  getTestUnit().attack(unit);
  assertEquals(thisLife-itemForUnit.getPower()+20,getTestUnit().getCurrentHitPoints());
  assertEquals(victimsLife-itemForThis.getPower()+20,unit.getCurrentHitPoints());

  getTestUnit().removeFromInventory(itemForThis);
  getTestUnit().setEquippedItem(nullItem);
  unit.removeFromInventory(itemForUnit);
  unit.setEquippedItem(nullItem);
 }
 @Override
 /**
  * test attack in weak attack vs strong attack scenario
  * @param itemForThis test unit weapon
  * @param itemForUnit units weapon
  * @param unit unit to attack
  */
 public void checkWeakStrongCombat(IEquipableItem itemForThis, IEquipableItem itemForUnit, IUnit unit){
  int victimsLife= unit.getCurrentHitPoints();
  int thisLife=getTestUnit().getCurrentHitPoints();

  getTestUnit().attack(unit);
  assertEquals(thisLife,getTestUnit().getCurrentHitPoints());
  assertEquals(victimsLife,unit.getCurrentHitPoints());

  getTestUnit().addToInventory(itemForThis);
  getTestUnit().equipItem(itemForThis);

  getTestUnit().attack(unit);
  assertEquals(thisLife,getTestUnit().getCurrentHitPoints());
  assertEquals(victimsLife-itemForThis.getPower(),unit.getCurrentHitPoints());
  victimsLife=unit.getCurrentHitPoints();

  unit.addToInventory(itemForUnit);
  unit.equipItem(itemForUnit);

  getTestUnit().attack(unit);
  assertEquals((int)(thisLife-itemForUnit.getPower()*1.5),getTestUnit().getCurrentHitPoints());
  assertEquals(victimsLife-(itemForThis.getPower()-20),unit.getCurrentHitPoints());

  getTestUnit().removeFromInventory(itemForThis);
  getTestUnit().setEquippedItem(nullItem);
  unit.removeFromInventory(itemForUnit);
  unit.setEquippedItem(nullItem);
 }
 /**
  * test attack in strong attack vs weak attack scenario
  * @param itemForThis test unit weapon
  * @param itemForUnit units weapon
  * @param unit unit to attack
  */
 @Override
 public void checkStrongWeakCombat(IEquipableItem itemForThis, IEquipableItem itemForUnit, IUnit unit){
  int victimsLife= unit.getCurrentHitPoints();
  int thisLife=getTestUnit().getCurrentHitPoints();

  getTestUnit().attack(unit);
  assertEquals(thisLife,getTestUnit().getCurrentHitPoints());
  assertEquals(victimsLife,unit.getCurrentHitPoints());

  getTestUnit().addToInventory(itemForThis);
  getTestUnit().equipItem(itemForThis);

  getTestUnit().attack(unit);
  assertEquals(thisLife,getTestUnit().getCurrentHitPoints());
  assertEquals(victimsLife-itemForThis.getPower(),unit.getCurrentHitPoints());
  victimsLife=unit.getCurrentHitPoints();

  unit.addToInventory(itemForUnit);
  unit.equipItem(itemForUnit);

  getTestUnit().attack(unit);
  assertEquals(thisLife-(itemForUnit.getPower()-20),getTestUnit().getCurrentHitPoints());
  assertEquals((int)(victimsLife-itemForThis.getPower()*1.5),unit.getCurrentHitPoints());

  getTestUnit().removeFromInventory(itemForThis);
  getTestUnit().setEquippedItem(nullItem);
  unit.removeFromInventory(itemForUnit);
  unit.setEquippedItem(nullItem);
 }
 /**
  * test attack to unit that cannot defend
  * @param itemForThis test unit weapon
  * @param unit unit to attack
  */
 @Override
 public void checkUnilateralCombat(IEquipableItem itemForThis, IUnit unit){
  int victimsLife= unit.getCurrentHitPoints();
  int thisLife=getTestUnit().getCurrentHitPoints();

  getTestUnit().attack(unit);
  assertEquals(thisLife,getTestUnit().getCurrentHitPoints());
  assertEquals(victimsLife,unit.getCurrentHitPoints());

  getTestUnit().addToInventory(itemForThis);
  getTestUnit().equipItem(itemForThis);

  getTestUnit().attack(unit);
  assertEquals(thisLife,getTestUnit().getCurrentHitPoints());
  assertEquals(victimsLife-itemForThis.getPower(),unit.getCurrentHitPoints());
 }
 /**
  * test attacking cleric with books
  * @param itemForThis test unit weapon
  */
 @Override
 public void checkMagicToClericCombat(IEquipableItem itemForThis) {
  int victimsLife = targetCleric.getCurrentHitPoints();
  int thisLife = getTestUnit().getCurrentHitPoints();

  getTestUnit().attack(targetCleric);
  assertEquals(thisLife, getTestUnit().getCurrentHitPoints());
  assertEquals(victimsLife, targetCleric.getCurrentHitPoints());

  getTestUnit().addToInventory(itemForThis);
  getTestUnit().equipItem(itemForThis);
  targetCleric.addToInventory(getStaff());
  targetCleric.equipItem(getStaff());

  getTestUnit().attack(targetCleric);
  assertEquals(thisLife, getTestUnit().getCurrentHitPoints());
  assertEquals((int) (victimsLife - itemForThis.getPower() * 1.5), targetCleric.getCurrentHitPoints());
 }

 /**
  * test that combat works as desired
  */
 @Test
 public abstract void checkCombat();

 /**
  * checks exchange between units
  */
 @Test
 @Override
 public void checkExchange(){
  targetAlpaca.moveTo(getField().getCell(0,0));
  getTestUnit().moveTo(getField().getCell(0,2));


  targetAlpaca.addToInventory(getAnima());
  targetAlpaca.addToInventory(getAxe());
  targetAlpaca.addToInventory(getBow());
  targetAlpaca.addToInventory(getDarkness());
  targetAlpaca.addToInventory(getLight());
  targetAlpaca.addToInventory(getSpear());
  targetAlpaca.addToInventory(getStaff());
  targetAlpaca.addToInventory(getSword());

  targetAlpaca.exchange(getAnima(),getTestUnit());
  assertFalse(getTestUnit().getItems().contains(getAnima()));

  targetAlpaca.moveTo(getField().getCell(0,0));
  getTestUnit().moveTo(getField().getCell(0,1));
  assertTrue(targetAlpaca.getLocation().distanceTo(getTestUnit().getLocation())<=1);



  targetAlpaca.exchange(getAnima(),getTestUnit());
  targetAlpaca.exchange(getAxe(),getTestUnit());
  targetAlpaca.exchange(getBow(),getTestUnit());
  targetAlpaca.exchange(getDarkness(),getTestUnit());
  targetAlpaca.exchange(getLight(),getTestUnit());
  targetAlpaca.exchange(getSpear(),getTestUnit());
  targetAlpaca.exchange(getStaff(),getTestUnit());
  targetAlpaca.exchange(getSword(),getTestUnit());

  assertTrue(getTestUnit().getItems().contains(getAnima()));
  assertTrue(getTestUnit().getItems().contains(getAxe()));
  assertTrue(getTestUnit().getItems().contains(getBow()));
  assertFalse(getTestUnit().getItems().contains(getDarkness()));
  assertFalse(getTestUnit().getItems().contains(getLight()));
  assertFalse(getTestUnit().getItems().contains(getSpear()));
  assertFalse(getTestUnit().getItems().contains(getStaff()));
  assertFalse(getTestUnit().getItems().contains(getSword()));
 }

 @Override
 @Test
 public void TestHealing(){
  targetAlpaca.moveTo(getField().getCell(0,0));
  getTestUnit().moveTo(getField().getCell(0,1));
  int life=targetAlpaca.getCurrentHitPoints();
  getTestUnit().heal(targetAlpaca);
  assertEquals(life,targetAlpaca.getCurrentHitPoints());
  getTestUnit().addToInventory(staff);
  getTestUnit().equipItem(staff);
  getTestUnit().heal(targetAlpaca);
  assertEquals(life,targetAlpaca.getCurrentHitPoints());
 }


}
