package model.units;

import model.items.*;
import model.items.books.IBook;
import model.map.Location;



public class NullUnit extends AbstractUnit {
    /**
     * Creates a new Unit.
     *
     */
    protected NullUnit() {
        super(0, 0, null, Integer.MAX_VALUE, null);
    }

    @Override
    public void equipSpear(Spear spear) {
        // Method body intentionally left empty
    }

    @Override
    public void equipSword(Sword sword) {
// Method body intentionally left empty
    }

    @Override
    public void equipBook(IBook book) {
// Method body intentionally left empty
    }

    @Override
    public void equipAxe(Axe axe) {
// Method body intentionally left empty
    }

    @Override
    public void equipBow(Bow bow) {
// Method body intentionally left empty
    }

    @Override
    public void equipStaff(Staff staff) {
// Method body intentionally left empty
    }
}
