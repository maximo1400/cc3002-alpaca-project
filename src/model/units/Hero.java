package model.units;

import model.items.IEquipableItem;
import model.items.Spear;
import model.map.Location;

/**
 * A <i>Hero</i> is a special kind of unit, the player that defeats this unit wins the game.
 * <p>
 * This unit <b>can only use spear weapons</b>.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Hero extends AbstractUnit {

    /**
     * Creates a new Unit.
     *
     * @param hitPoints the maximum amount of damage a unit can sustain
     * @param movement  the number of panels a unit can move
     * @param location  the current position of this unit on the map
     * @param items     maximum amount of items this unit can carry
     */
    public Hero(final int hitPoints, final int movement, final Location location,
                IEquipableItem... items) {
        super(hitPoints, movement, location, 3, items);
    }

    @Override
    public void equipSpear(Spear spear) {
        this.setEquippedItem(spear);
        spear.setOwner(this);
    }

    @Override
    public void setCurrentHitPoints(int life) {
        if (life < 0) {
            life = 0;
            this.getTactician().deleteDeadUnit(this);
            this.getTactician().getGameController().removeTactician(this.getTactician().getName());
        }

        this.currentHitPoints = life;
    }

}
