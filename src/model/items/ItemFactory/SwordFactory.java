package model.items.ItemFactory;

import model.items.IEquipableItem;
import model.items.Sword;

public class SwordFactory extends AbstractFactory {
    private String name;
    private int power;
    private int maxRange;
    private int minRange;


    public SwordFactory(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public IEquipableItem create() {
        return new Sword(name,power,minRange,maxRange);
    }
}
