# Battleship
Battleship Game README

Welcome to the "Battleship Game" README. This document will guide you through the functionality of the code and provide instructions on how to run the game.

How the Code Should Function

The "Battleship Game" is a console-based implementation of the classic game Battleship, where you, as the player, try to locate and sink hidden battleships on a game board. The game operates as follows:

Initialization: The game starts by creating a game board with a specified length. Characters are used to represent various elements:

'-' represents water
'B' represents battleships
'H' represents a successful hit
'M' represents a miss
Battleship Placement: Hidden battleships are randomly placed on the game board. Each battleship is represented by the character 'B'.

Guessing Phase: You will be prompted to input your guess coordinates, representing a row and a column on the game board.

Guess Evaluation: The code evaluates your guess and provides feedback:

If your guess corresponds to a battleship ('B'), you'll receive a "Hit!" message, and the battleship location will be marked as 'H'.
If your guess corresponds to water ('-'), you'll receive a "Miss!" message, and the location will be marked as 'M'.
If you guess a location that has already been guessed before, you'll receive an "Already hit!" message.
Game Progress: The game continues until you successfully hit all the battleships ('B').

The number of undetected battleships is tracked using the undetectedShipNumber variable.
Game Completion: Once you successfully hit all battleships, the game displays a "You won!" message, indicating your victory.

How to Run the Code in IntelliJ

Follow these steps to run the "Battleship Game" using IntelliJ IDEA:

Install IntelliJ IDEA: If you haven't already, download and install IntelliJ IDEA from the official website (https://www.jetbrains.com/idea/).

Import the Project:

Launch IntelliJ IDEA.
From the welcome screen, select "Open" and navigate to the directory containing the Battleshipgame.java file.
Select the file and click "Open."
Compile and Run:

Once the project is loaded, open the Battleshipgame.java file.
In the code editor, right-click within the code area and select "Run 'Battleshipgame.main()'."
Gameplay:

The IntelliJ IDEA console will open within the bottom pane.
You will be prompted to enter the row and column coordinates for your guesses. Follow the on-screen instructions to play the game.
Winning:

Continue guessing until you successfully hit all the battleships and receive the "You won!" message.
Please note that the game's behavior involves randomness, as indicated by the use of Math.random(). This means you may not always get a perfectly balanced distribution of hits and misses.

Enjoy playing the "Battleship Game" within the comfort of the IntelliJ IDEA development environment!

Keep in mind that this implementation is a basic text-based version and does not include the more advanced features found in commercial versions of Battleship.