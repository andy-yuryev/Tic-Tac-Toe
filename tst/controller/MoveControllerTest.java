package controller;

import model.Field;
import model.Figure;
import model.Point;
import model.exception.AlreadyOccupiedException;
import model.exception.InvalidPointException;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveControllerTest {

    private int size = 3;

    @Test
    public void testCurrentMoveWhenNextMoveIsX() throws InvalidPointException, AlreadyOccupiedException {
        for (int i = 0; i < 3; i++) {
            Field field = new Field(size);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.O);
            assertEquals(Figure.X, MoveController.currentMove(field));
        }
    }

    @Test
    public void testCurrentMoveWhenNextMoveIsO() throws InvalidPointException, AlreadyOccupiedException {
        for (int i = 0; i < 3; i++) {
            Field field = new Field(size);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.O);
            field.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.O, MoveController.currentMove(field));
        }
    }

    @Test
    public void testCurrentMoveWhenNoNextMove() throws InvalidPointException, AlreadyOccupiedException {
        Field field = new Field(size);
        for (int x = 0; x < field.getSize(); x++) {
            for (int y = 0; y < field.getSize(); y++) {
                field.setFigure(new Point(x, y), Figure.X);
            }
        }
        assertNull(MoveController.currentMove(field));
    }
}
