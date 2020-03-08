package controller;

import model.Field;
import model.Figure;
import model.Point;
import model.exception.AlreadyOccupiedException;
import model.exception.InvalidPointException;
import org.junit.Test;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    private int size = 3;

    @Test
    public void getWinnerWhenWinnerRow() throws InvalidPointException, AlreadyOccupiedException {
        for (int i = 0; i < 3; i++) {
            Field field = new Field(size);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.X, WinnerController.getWinner(field));
        }
    }

    @Test
    public void getWinnerWhenNoWinnerRow() throws InvalidPointException, AlreadyOccupiedException {
        for (int i = 0; i < 3; i++) {
            Field field = new Field(size);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);
            assertNull(WinnerController.getWinner(field));
        }
    }

    @Test
    public void getWinnerWhenWinnerColumn() throws InvalidPointException, AlreadyOccupiedException {
        for (int i = 0; i < 3; i++) {
            Field field = new Field(size);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);
            assertEquals(Figure.X, WinnerController.getWinner(field));
        }
    }

    @Test
    public void getWinnerWhenNoWinnerColumn() throws InvalidPointException, AlreadyOccupiedException {
        for (int i = 0; i < 3; i++) {
            Field field = new Field(size);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.O);
            assertNull(WinnerController.getWinner(field));
        }
    }

    @Test
    public void getWinnerWhenWinnerDiagonal1() throws InvalidPointException, AlreadyOccupiedException {
        Field field = new Field(size);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.X);
        assertEquals(Figure.X, WinnerController.getWinner(field));
    }

    @Test
    public void getWinnerWhenNoWinnerDiagonal1() throws InvalidPointException, AlreadyOccupiedException {
        Field field = new Field(size);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.O);
        assertNull(WinnerController.getWinner(field));
    }

    @Test
    public void getWinnerWhenWinnerDiagonal2() throws InvalidPointException, AlreadyOccupiedException {
        Field field = new Field(size);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.X);
        assertEquals(Figure.X, WinnerController.getWinner(field));
    }

    @Test
    public void getWinnerWhenNoWinnerDiagonal2() throws InvalidPointException, AlreadyOccupiedException {
        Field field = new Field(size);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.O);
        assertNull(WinnerController.getWinner(field));
    }
}
