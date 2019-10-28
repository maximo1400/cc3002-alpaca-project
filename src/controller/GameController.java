package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.Location;
import model.units.IUnit;

/**
 * Controller of the game.
 * The controller manages all the input received from de game's GUI.
 *
 * @author Ignacio Slater Muñoz
 * @version 2.0
 * @since 2.0
 */
public class GameController {
    private List<Tactician> tacticians;
    private int turnOwner;
    private Field field;
    private int roundNumber;
    private int maxRounds;
    private int numberOfPlayers;

    /**
     * Creates the controller for a new game.
     *
     * @param numberOfPlayers the number of players for this game
     * @param mapSize         the dimensions of the map, for simplicity, all maps are squares
     */
    public GameController(int numberOfPlayers, int mapSize) {
        this.field = new Field();
        this.field.setSize(mapSize);
        this.tacticians = new ArrayList<>();
        this.roundNumber = 0;
        this.maxRounds = 0;
        this.numberOfPlayers=numberOfPlayers;
        resetTacticians(numberOfPlayers);

//        for (int i = 0; i < numberOfPlayers; i++)
//            this.tacticians.add(new Tactician("Player " + i, this, field));
        for (int i = 0; i < field.getMapSize(); i++)
            for (int j = 0; j < field.getMapSize(); j++)
                field.addCells(false, new Location(i, j));

    }

    /**
     * @return the list of all the tacticians participating in the game.
     */
    public List<Tactician> getTacticians() {
        return List.copyOf(tacticians);
    }

    /**
     * @return the map of the current game
     */
    public Field getGameMap() {
        return field;
    }

    /**
     * @return the tactician that's currently playing
     */
    public Tactician getTurnOwner() {
        return tacticians.get(turnOwner);
    }

    /**
     * @return the number of rounds since the start of the game.
     */
    public int getRoundNumber() {
        return roundNumber;
    }

    /**
     * @return the maximum number of rounds a match can last
     */
    public int getMaxRounds() {
        return maxRounds;
    }

    /**
     * Finishes the current player's turn.
     */
    public void endTurn() {
        if (turnOwner==0){
            Tactician lastPlayer = getTacticians().get(0);
            while(lastPlayer.getName().equals(getTacticians().get(0)))
                Collections.shuffle(tacticians);
        }
        this.turnOwner++;
        if (turnOwner == tacticians.size()) {
            turnOwner = 0;
            roundNumber++;
        }

    }

    /**
     * Removes a tactician and all of it's units from the game.
     *
     * @param tactician the player to be removed
     */
    public void removeTactician(String tactician) {
        List<Tactician> toDelete = new ArrayList<>();
        for (Tactician tactician1 : tacticians)
            if (tactician1.getName().equals(tactician))
                toDelete.add(tactician1);
        tacticians.removeAll(toDelete);
    }

    /**
     * Starts the game.
     *
     * @param maxTurns the maximum number of turns the game can last
     */
    public void initGame(final int maxTurns) {
        this.maxRounds = maxTurns;
        this.roundNumber = 1;
        resetTacticians(numberOfPlayers);
    }

    /**
     * Starts a game without a limit of turns.
     */
    public void initEndlessGame() {
        initGame(-1);
    }

    /**
     * @return the winner of this game, if the match ends in a draw returns a list of all the winners
     */
    public List<String> getWinners() {
        if (roundNumber <= maxRounds || (tacticians.size() > 1 && maxRounds == -1))
            return null;
        List<String> string = new ArrayList<>();
        for (Tactician t : tacticians)
            string.add(t.getName());
        return string;
    }

    /**
     * @return the current player's selected unit
     */
    public IUnit getSelectedUnit() {
        return getTurnOwner().getSelectedUnit();
    }

    /**
     * Selects a unit in the game map
     *
     * @param x horizontal position of the unit
     * @param y vertical position of the unit
     */
    public void selectUnitIn(int x, int y) {
        getTurnOwner().setSelectUnit(field.getCell(x, y).getUnit());
    }

    /**
     * @return the inventory of the currently selected unit.
     */
    public List<IEquipableItem> getItems() {
        return getSelectedUnit().getItems();
    }

    /**
     * Equips an item from the inventory to the currently selected unit.
     *
     * @param index the location of the item in the inventory.
     */
    public void equipItem(int index) {
        getSelectedUnit().equipItem(getItems().get(index));
    }

    /**
     * Uses the equipped item on a target
     *
     * @param x horizontal position of the target
     * @param y vertical position of the target
     */
    public void useItemOn(int x, int y) {
        IUnit target = field.getCell(x, y).getUnit();
    }

    /**
     * Selects an item from the selected unit's inventory.
     *
     * @param index the location of the item in the inventory.
     */
    public void selectItem(int index) {
        IEquipableItem item = getSelectedUnit().getItems().get(index);
        getSelectedUnit().setSelectedItem(item);
    }

    /**
     * Gives the selected item to a target unit.
     *
     * @param x horizontal position of the target
     * @param y vertical position of the target
     */
    public void giveItemTo(int x, int y) {
        getSelectedUnit().exchange(getSelectedUnit().getSelectedItem(), field.getCell(x, y).getUnit());
    }
    public void resetTacticians(int numberOfPlayers){
        if (tacticians.size()>0)
            tacticians.removeAll(getTacticians());
        for (int i = 0; i < numberOfPlayers; i++)
            this.tacticians.add(new Tactician("Player " + i, this, field));
    }
}
