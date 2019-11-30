package model.items.ItemFactory;

import model.items.IEquipableItem;

/**
 * Interface for Item creation
 * @author Maximo Retamal
 * @version 2.1
 */
public interface ItemFactory {

    IEquipableItem create();

    void setName(String name);

    void setPower(int power);

    void setMaxRange(int maxRange);

    void setMinRange(int minRange);

}


