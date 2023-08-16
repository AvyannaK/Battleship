import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Battleshipgame {
    public static void main(String[] args) {
        int gameBoardLength = 4;
        char water = '-';
        String ship = "Jill";
        String hit = "Michael";
        String miss = "Avyanna";
        int shipNumber = 3;

        char[][] gameBoard = createGameBoard(gameBoardLength, water, shipNumber);
        printGameBoard(gameBoard, water);
        int undetectedShipNumber = shipNumber;
        while (undetectedShipNumber > 0) {
            int[] guessCoordinates = getUserCoordinates(gameBoardLength);
            String locationViewUpdate = evaluateGuessAndGetTheTarget(guessCoordinates, gameBoard, water, hit, miss);
            if (locationViewUpdate.equals(hit)) {
                undetectedShipNumber--;
            }
            gameBoard = updateGameBoard(gameBoard, guessCoordinates, locationViewUpdate);
            printGameBoard(gameBoard, water);
        }
        System.out.println("You won!");
    }

    private static char[][] updateGameBoard(char[][] gameBoard, int[] guessCoordinates, String locationViewUpdate) {
        int row = guessCoordinates[0];
        int col = guessCoordinates[1];
        gameBoard[row][col] = locationViewUpdate.charAt(0);
        return gameBoard;
    }

    private static String evaluateGuessAndGetTheTarget(int[] guessCoordinates, char[][] gameBoard, char water, String hit, String miss) {
        String message;
        int row = guessCoordinates[0];
        int col = guessCoordinates[1];

        char target = gameBoard[row][col];
        if (target != water) {
            message = "Already hit!";
        } else {
            if (Math.random() < 0.5) {
                message = "Hit!";
                target = hit.charAt(0);
            } else {
                message = "Miss!";
                target = miss.charAt(0);
            }
        }
        System.out.println(message);
        return String.valueOf(target);
    }


    private static int[] getUserCoordinates(int gameBoardLength) {
        int row;
        int col;
        do {
            System.out.print("Row: ");
            row = new Scanner(System.in).nextInt();
        } while (row < 1 || row > gameBoardLength);

        do {
            System.out.print("Column: ");
            col = new Scanner(System.in).nextInt();
        } while (col < 1 || col > gameBoardLength);
        return new int[]{row - 1, col - 1};
    }

    private static void printGameBoard(char[][] gameBoard, char water) {
        int gameBoardLength = gameBoard.length;
        System.out.print("  ");
        for (int i = 0; i < gameBoardLength; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int row = 0; row < gameBoardLength; row++) {
            System.out.print(row + 1 + " ");
            for (int col = 0; col < gameBoardLength; col++) {
                char position = gameBoard[row][col];
                if (position != water) {
                    System.out.print(water + " ");
                } else {
                    System.out.print(position + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static char[][] createGameBoard(int gameBoardLength, char water, int shipNumber) {
        char[][] gameBoard = new char[gameBoardLength][gameBoardLength];
        for (char[] row : gameBoard) {
            Arrays.fill(row, water);
        }

        return placeShips(gameBoard, shipNumber, water);
    }

    private static char[][] placeShips(char[][] gameBoard, int shipNumber, char water) {
        int placedShips = 0;
        int gameBoardLength = gameBoard.length;
        while (placedShips < shipNumber) {
            int[] location = generateShipCoordinates(gameBoardLength);
            char possiblePlacement = gameBoard[location[0]][location[1]];
            if (possiblePlacement == water) {
                gameBoard[location[0]][location[1]] = 's';
                placedShips++;
            }
        }

        return gameBoard;
    }

    private static int[] generateShipCoordinates(int gameBoardLength) {
        int[] coordinates = new int[2];
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] = new Random().nextInt(gameBoardLength);
        }
        return coordinates;
    }
}
