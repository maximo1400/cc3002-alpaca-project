package model.items.ItemFactory;

import model.items.IEquipableItem;

public interface ItemFactory {

    IEquipableItem create();

    void setName(String name);

    void setPower(int power);

    void setMaxRange(int maxRange);

    void setMinRange(int minRange);

}


