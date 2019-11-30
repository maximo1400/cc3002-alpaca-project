package model.items.ItemFactory;

import model.items.IEquipableItem;
import model.items.books.Darkness;
/**
 *  class for the Darkness item creation
 *  * @author Maximo Retamal
 *  * @version 1.0
 *  * @since 2.1
 */
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
