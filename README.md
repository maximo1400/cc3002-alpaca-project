# cc3002-alpaca-project
This project is the first step in the process of making a strategic game, for this it was used double dispatch 
as the programing pattern.
## Units 
In this endeavour it was programed several classes "Units" whose job is to  be able to move and in some 
most cases attack each other, to attack units are required also to be able to equip weapons,most weapons are only
able to be equipped by a specific class of unit, with a couple of exceptions; the units implemented are:

* Archer:  Bows.
* Fighter: Axes.
* Sword Master: Swords.
* Alpaca: Can't equip or attack.
* Cleric:  Staffs but can only heal.
* Hero: Spears.
* Sorcerer: Books (there are 3 types)

The structure of the code used for the units started with an interface that was implemented by an abstract class
which was then extended by a class for every unit class.

Every unit has 2 numbers representing life points; currentHitPoints represents the present amount of hit points and 
hitPoints represents the starting point of that unit, also the unit has an amuonts of steps it can move , position
in the game, a list of items (with a limit of 3 in al cases except of the alpaca who has no limit) and when possible
an item equipped that's used as weapon

## Items
They are the weapons that can be equipped by the units and are the ones in charge of attacking each others in the
name of their owners; for this there were the following Items:
* Axe
* Bow
* Spear
* Staff
* Sword
* Anima (Book)
* Light (Book)
* Darkness (Book)
* NullItem (The same as no item)




There were also several kind of weapons implemented 
 types of card branching frm an interface called "ICard", the first kind of card was the energy kind 
that has the ability to be played onto the other kind of card (pokemon) adding energy of a certain kind, there are 6 kinds
Fire, Water, Grass, Psychic, Fighting and Electric. The other kind of card is pokemon, pokemon has a name, an identification 
number, health points, energy points (of all mentioned classes) and different abilities, pokemon is able to attack each 
other, can die because of it and can choose abilities between an array of selections, for the abilities it was codded an 
abstract class "AbstractSkill" and it was expanded with the Attack class; this class is composed of a name, some energy 
requirements that have to be check before using, a value of base damage and some info to give the trainer enough data 
to know how to use it.  
