package model.items.ItemFactory;

import model.items.IEquipableItem;
import model.items.books.Light;

public class LightFactory extends AbstractFactory {
    private String name;
    private int power;
    private int maxRange;
    private int minRange;

    public LightFactory(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public IEquipableItem create() {
        return new Light(name,power,minRange,maxRange);
    }
}
