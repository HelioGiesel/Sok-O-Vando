# Sok-O-Vando (Sokoban)

##### Move the JS boxes into Vando's face and feel the pleasure blocking him with the programming language who does not shall be named.<br />Careful to not make a dead end move, ortherwise Vando will laugth at your worthless and unusefull mind.

### Main Classes:<br />
	- Main
	- Game
	- Grid
	- Player
	- Box
	- Spots
	- CollisionDetector
	- Position



#### class Main:
	- creates the game
	- start the game


#### class Game:
	- creates the field, player, boxes and spots.
	- run the game until box are put in spots or game level is reseted.

	
#### class Player:
	- Respond to user commands, moving when possible.
	- move inside the field limits.
	- move boxes by pushing it into the same direction of the move.

	
#### class Box:
	- check when moved by player if the movement is possible (not into wall or another box).


#### class Grid:
	- creates the field according to the level, setting up the walls via rectangles.

	
#### class CollisionDetector:
	- receive the position and the move intended, check if the moves goes into a wall or into another box, and return a boolean.
    - Check if all spots are covered by boxes and call the level won.


#### class Position:
	- Relate the position and characteristics of the objects in the game.
	- hold the following properties of the object:.
	- x (Initial X position)
	- y (Initial Y position)
	- height
	- width

