package model.items.ItemFactory;

import model.items.Axe;
import model.items.IEquipableItem;
/**
 *  class for the Axe item creation
 *  * @author Maximo Retamal
 *  * @version 1.0
 *  * @since 2.1
 */
public class AxeFactory extends AbstractFactory {
    private String name;
    private int power;
    private int maxRange;
    private int minRange;

    public AxeFactory(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public IEquipableItem create() {
        return new Axe(name,power,minRange,maxRange);
    }
}
