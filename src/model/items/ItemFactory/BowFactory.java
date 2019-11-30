package model.items.ItemFactory;

import model.items.Bow;
import model.items.IEquipableItem;
/**
 *  class for the Bow item creation
 *  * @author Maximo Retamal
 *  * @version 1.0
 *  * @since 2.1
 */
public class BowFactory extends AbstractFactory {
    private String name;
    private int power;
    private int maxRange;
    private int minRange;

    public BowFactory(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public IEquipableItem create() {
        return new Bow(name,power,minRange,maxRange);
    }
}
