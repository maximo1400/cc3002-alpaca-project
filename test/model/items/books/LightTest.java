package model.items.books;

import model.items.IEquipableItem;
import model.units.Sorcerer;
/**
 * Test set for Light
 *
 * @author Maximo Retamal Rojas
 * @since 2.0
 */
class LightTest extends  AbstractBookTest{
 private Light light;
 private Light wrongLight;
 private Sorcerer sorcerer;

 /**
  * Sets up a correctly implemented item that's going to be tested
  */
 @Override
 public void setTestItem() {
  expectedName = "Common Light";
  expectedPower = 10;
  expectedMinRange = 1;
  expectedMaxRange = 2;
  light = new Light(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
 }

 /**
  * Sets up an item with wrong ranges setted.
  */
 @Override
 public void setWrongRangeItem() {
  wrongLight = new Light("Wrong Light", 0, -1, -2);
 }


 @Override
 public IEquipableItem getWrongTestItem() {
  return wrongLight;
 }

 /**
  * @return the item being tested
  */
 @Override
 public IEquipableItem getTestItem() {
  return light;
 }


}