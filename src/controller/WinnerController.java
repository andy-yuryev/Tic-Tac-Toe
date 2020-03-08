package controller;

import model.Field;
import model.Figure;
import model.Point;

public class WinnerController {

    public static Figure getWinner(Field field) {
        Figure winner;

        winner = checkRows(field);
        if (winner != null) return winner;

        winner = checkColumns(field);
        if (winner != null) return winner;

        winner = checkDiagonals(field);
        if (winner != null) return winner;

        return null;
    }

    private static Figure checkRows(Field field) {
        for (int x = 0; x < field.getSize(); x++) {
            Figure winner = field.getFigure(new Point(x, 0));
            if (winner != null) {
                for (int y = 1; y < field.getSize(); y++) {
                    if (field.getFigure(new Point(x, y)) == winner) {
                        if (field.getSize() - y == 1) {
                            return winner;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        return null;
    }

    private static Figure checkColumns(Field field) {
        for (int y = 0; y < field.getSize(); y++) {
            Figure winner = field.getFigure(new Point(0, y));
            if (winner != null) {
                for (int x = 1; x < field.getSize(); x++) {
                    if (field.getFigure(new Point(x, y)) == winner) {
                        if (field.getSize() - x == 1) {
                            return winner;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        return null;
    }

    public static Figure checkDiagonals(Field field) {
        Figure winner;

        winner = field.getFigure(new Point(0, 0));
        if (winner != null) {
            for (int i = 1; i < field.getSize(); i++) {
                if (field.getFigure(new Point(i, i)) == winner) {
                    if (field.getSize() - i == 1) {
                        return winner;
                    }
                } else {
                    break;
                }
            }
        }

        winner = field.getFigure(new Point(0, 2));
        if (winner != null) {
            for (int x = 1; x < field.getSize(); x++) {
                int y = field.getSize() - x - 1;
                if (field.getFigure(new Point(x, y)) == winner) {
                    if (field.getSize() - x == 1) {
                        return winner;
                    }
                } else {
                    break;
                }
            }
        }

        return null;
    }
}
