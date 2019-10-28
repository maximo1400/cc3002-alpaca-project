package model.items.ItemFactory;

import model.items.IEquipableItem;
import model.items.Spear;

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
