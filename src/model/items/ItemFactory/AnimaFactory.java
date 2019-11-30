package model.items.ItemFactory;

import model.items.IEquipableItem;
import model.items.books.Anima;

/**
 *  class for the Anima item creation
 *  * @author Maximo Retamal
 *  * @version 1.0
 *  * @since 2.1
 */
public class AnimaFactory extends AbstractFactory {
    private String name;
    private int power;
    private int maxRange;
    private int minRange;

    public AnimaFactory(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public IEquipableItem create() {
        return new Anima(name,power,minRange,maxRange);
    }
}
