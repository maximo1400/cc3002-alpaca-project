package model.items.books;

import model.items.IEquipableItem;
import model.units.Sorcerer;

/**
 * Test set for Anima
 *
 * @author Maximo Retamal Rojas
 * @since 2.0
 */
class AnimaTest  extends  AbstractBookTest{
 private Anima anima;
 private Anima wrongAnima;
 private Sorcerer sorcerer;
 /**
  * Sets up a correctly implemented item that's going to be tested
  */
 @Override
 public void setTestItem() {
  expectedName = "Common Anima";
  expectedPower = 10;
  expectedMinRange = 1;
  expectedMaxRange = 2;
  anima = new Anima(expectedName, expectedPower, expectedMinRange, expectedMaxRange);

 }

 /**
  * Sets up an item with wrong ranges setted.
  */
 @Override
 public void setWrongRangeItem() {
  wrongAnima = new Anima("wrong Anima", 0, -1, -2);

 }


 @Override
 public IEquipableItem getWrongTestItem() {
  return wrongAnima;
 }

 /**
  * @return the item being tested
  */
 @Override
 public IEquipableItem getTestItem() {
  return anima;
 }

}