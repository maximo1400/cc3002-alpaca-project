package model.items.ItemFactory;

import model.items.AbstractItem;
import model.items.IEquipableItem;
import model.units.IUnit;

public abstract class AbstractFactory implements ItemFactory {
    private String name;
    private int power;
    private int maxRange;
    private int minRange;

    public AbstractFactory(final String name, final int power, final int minRange, final int maxRange) {
        this.name = name;
        this.power = power;
        this.minRange = Math.max(minRange, 1);
        this.maxRange = Math.max(maxRange, this.minRange);
    }

    @Override
    public void setName(String name){
        this.name=name;
    }

    @Override
    public void setPower(int power) {
        this.power=power;
    }

    @Override
    public void setMaxRange(int maxRange){
        this.maxRange=maxRange;
    }

    @Override
    public void setMinRange(int minRange){
        this.minRange=minRange;
    }

}
