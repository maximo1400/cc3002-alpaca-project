package model.items.ItemFactory;

import model.items.IEquipableItem;
import model.items.Staff;

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
