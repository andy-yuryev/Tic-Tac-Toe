package controller;

import model.Field;
import model.Figure;
import model.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoveController {

    public static Figure currentMove(Field field) {
        int figuresCount = 0;
        for (int x = 0; x < field.getSize(); x++) {
            for (int y = 0; y < field.getSize(); y++) {
                if (field.getFigure(new Point(x, y)) != null) {
                    figuresCount++;
                }
            }
        }

        if (figuresCount == field.getSize() * field.getSize()) {
            return null;
        }
        return figuresCount % 2 == 0 ? Figure.X : Figure.O;
    }

    public static Point generateRandomMove(Field field) {
        List<Point> freeCells = new ArrayList<>();
        for (int x = 0; x < field.getSize(); x++) {
            for (int y = 0; y < field.getSize(); y++) {
                Point point = new Point(x, y);
                if (field.getFigure(point) == null) {
                    freeCells.add(point);
                }
            }
        }

        return freeCells.get(new Random().nextInt(freeCells.size()));
    }
}
