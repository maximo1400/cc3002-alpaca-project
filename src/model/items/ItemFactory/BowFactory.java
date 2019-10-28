package model.items.ItemFactory;

import model.items.Bow;
import model.items.IEquipableItem;

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
