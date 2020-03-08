package view;

import controller.*;
import model.*;
import model.exception.*;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ConsoleView implements GameView {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public boolean startMenu() {
        String mode;
        boolean twoPlayerGame;

        do {
            System.out.println("1 - One player game");
            System.out.println("2 - Two player game");
            mode = scanner.next();
        } while (!mode.equals("1") && !mode.equals("2"));

        switch (mode) {
            case "1":
                twoPlayerGame = false;
                break;
            case "2":
                twoPlayerGame = true;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + mode);
        }

        return twoPlayerGame;
    }

    @Override
    public boolean move(Game game) {
        Field field = game.getField();
        boolean twoPlayerGame = game.isTwoPlayerGame();
        Figure currentFigure = MoveController.currentMove(field);

        Figure winner = WinnerController.getWinner(field);
        if (winner != null) {
            System.out.printf("Player %s wins!\n", winner);
            return false;
        }

        if (currentFigure == null) {
            System.out.println("Draw!");
            return false;
        }

        Point point;
        if (!twoPlayerGame) {
            if (currentFigure == Figure.X) {
                point = askPoint(currentFigure);
            } else {
                point = MoveController.generateRandomMove(field);
            }
        } else {
            point = askPoint(currentFigure);
        }

        try {
            field.setFigure(point, currentFigure);
        } catch (InvalidPointException e) {
            System.out.println("Input the correct coordinates");
        } catch (AlreadyOccupiedException e) {
            System.out.println("The cell is occupied");
        }

        return true;
    }

    @Override
    public void printField(Game game) {
        Field field = game.getField();
        for (int i = 0; i < field.getSize(); i++) {
            if (i != 0) {
                printSeparator(field);
            }
            printLine(field, i);
        }
    }

    private Point askPoint(Figure figure) {
        System.out.printf("Input the coordinates for %s\n", figure);
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(String coordinate) {
        System.out.printf("Coordinate %s:", coordinate);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Only digits allowed");
            scanner.nextLine();
            return askCoordinate(coordinate);
        }
    }

    private static void printLine(Field field, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < field.getSize(); i++) {
            if (i != 0) {
                sb.append("|");
            }
            Figure figure = field.getFigure(new Point(row, i));
            sb.append(" ");
            sb.append(figure != null ? figure : " ");
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void printSeparator(Field field) {
        for (int i = 0; i < field.getSize(); i++) {
            System.out.print("---");
            if (i != field.getSize() - 1) {
                System.out.print("-");
            }
        }
        System.out.println();
    }
}
