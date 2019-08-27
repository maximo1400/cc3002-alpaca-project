package model.items.books;

import model.units.*;

public class Light extends AbstractBook {
    /**
     * Constructor for a default item without any special behaviour.
     *
     * @param name     the name of the item
     * @param power    the power of the item (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the item
     * @param maxRange
     */
    public Light(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void equipToAlpaca(Alpaca alpaca) {

    }

    @Override
    public void equipToArcher(Archer archer) {

    }

    @Override
    public void equipToCleric(Cleric cleric) {

    }

    @Override
    public void equipToFighter(Fighter fighter) {

    }

    @Override
    public void equipToHero(Hero hero) {

    }

    @Override
    public void equipToSwordMaster(SwordMaster swordMaster) {

    }

    @Override
    public boolean canUse(IUnit unit) {
        return false;
    }

    @Override
    public void AttackUnit(IUnit unit) {

    }

    @Override
    public void chooseAttackStrength(IUnit unit) {

    }
}
