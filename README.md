# Bee-Rush
This is my grade 12 computer science culminating project! 

The game is designed with object-oriented programming and graphical user interface. It's played by dragging the bees to the hive without them colliding.

To play the game, download the BeeRush.jar file. Your computer might not open the file as it may be read as an unidentified developer. In that case, you can go to your security & privacy settings to allow access to the jar file.

-----------------------------------------------------------------------
How To Play:
Help the bees rebuild their hive! Click anywhere on the bee and drag it to its home(the hive).
Beware the bees can only be dragged so fast. To reset the bee's path, click the bee again.

Lead the bees towards the black & yellow beehive to rank up points

Avoid causing the bees to splat by them colliding into each other. 

-----------------------------------------------------------------------
* NOTE: THE GAME IS DESIGNED ON MACOS. Since the code significantly uses mouse events (such as mousepressed and mousedragged), 
different operating systems will read the input at different speeds. Therefore, playing on a different operating system other than macOS (ex. Windows) could cause unexpected results (such as clicking on the bee might more difficult). Sorry for the inconvenience.

-----------------------------------------------------------------------
Description of each file:

Bee.java > creates the Bee object

BeeHive.java > creates the BeeHive object

Welcome.java > Is the opening window the includes the tutorial and leads the player into the game

BeeGame.java > Is the window that the game is played in, which implements Bee.java and BeeHive.java into the file. It also incorporates the score and levels. 

