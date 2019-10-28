package model.items.ItemFactory;

import model.items.Axe;
import model.items.IEquipableItem;

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
