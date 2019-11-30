package model.items.ItemFactory;

import model.items.IEquipableItem;
import model.items.Spear;
/**
 *  class for the Spear item creation
 *  * @author Maximo Retamal
 *  * @version 1.0
 *  * @since 2.1
 */
public class SpearFactory extends AbstractFactory {
    private String name;
    private int power;
    private int maxRange;
    private int minRange;

    public SpearFactory(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public IEquipableItem create() {
        return new Spear(name,power,minRange,maxRange);
    }
}
