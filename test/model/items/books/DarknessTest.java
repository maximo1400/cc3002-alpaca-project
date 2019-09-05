package model.items.books;

import model.items.IEquipableItem;
import model.units.Sorcerer;
/**
 * Test set for Darkness
 *
 * @author Maximo Retamal Rojas
 * @since 2.0
 */
class DarknessTest extends  AbstractBookTest {
 private Darkness darkness;
 private Darkness wrongDarkness;
 private Sorcerer sorcerer;
 /**
  * Sets up a correctly implemented item that's going to be tested
  */
 @Override
 public void setTestItem() {
  expectedName = "Common Darkness";
  expectedPower = 10;
  expectedMinRange = 1;
  expectedMaxRange = 2;
  darkness = new Darkness(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
 }

 /**
  * Sets up an item with wrong ranges setted.
  */
 @Override
 public void setWrongRangeItem() {
  wrongDarkness = new Darkness("wrong Darkness", 0, -1, -2);
 }


 @Override
 public IEquipableItem getWrongTestItem() {
  return wrongDarkness;
 }

 /**
  * @return the item being tested
  */
 @Override
 public IEquipableItem getTestItem() {
  return darkness;
 }


}