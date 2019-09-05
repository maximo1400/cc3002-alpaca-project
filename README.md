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

As for the structure of this code it was started with an interface common for all items which was implemented by an
abstract class that was later extended by all non book classes, in the books case it was started with an interface that
extended the original one, then an abstract class implemented this new interface while also extending the abstract class
common for the other Items, later the abstract class of the books was extended with the 3 books.

Every item has a name, an amount representing their power and two numbers representing their range Limits.

To equip items it was used double dispatch so only the correct unit could equip each item kind


## Combat

The combat requires to start a unit with a weapon equipped and another unit in thier weapon's range and if the 
second unit has a weapon an counterattack follows.

when an attack happens the victim losses hitPoints equal to the power of the attacking weapon except when the 
combination of weapons makes a strong attack(1.5 times the power) or a weak attack(the power -20)  the combination 
between non magical weapons is:


Item | Weak Against | Strong Against    
:-----:|:-----:|:-----:|
Axe | Sword | Spear 
Sword | Spear | Axe
Spear | Axe | Sword

And between Magical weapons (Books) the table is:

Item    | Weak Against    | Strong Against    
:-----:|:-----:|:-----:|
Anima | Darkness | Light 
Darkness | Light | Anima
Light | Anima | Darkness

Also every attack between a magical item and a non magical item is strong.

## Exchange

Two units next to each other if they are next to each other in the map and the receiver has less than 3 items 
(this limit does not apply to the alpaca)


