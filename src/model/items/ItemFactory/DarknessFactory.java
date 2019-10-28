package model.items.ItemFactory;

import model.items.IEquipableItem;
import model.items.books.Darkness;

public class DarknessFactory extends AbstractFactory {
    private String name;
    private int power;
    private int maxRange;
    private int minRange;

    public DarknessFactory(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public IEquipableItem create() {
        return new Darkness(name,power,minRange,maxRange);
    }
}
