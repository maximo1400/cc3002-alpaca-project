package model.items.ItemFactory;

import model.items.IEquipableItem;
import model.items.Staff;
/**
 *  class for the Staff item creation
 *  * @author Maximo Retamal
 *  * @version 1.0
 *  * @since 2.1
 */
public class StaffFactory extends AbstractFactory {
    private String name;
    private int power;
    private int maxRange;
    private int minRange;

    public StaffFactory(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public IEquipableItem create() {
        return new Staff(name,power,minRange,maxRange);
    }
}
