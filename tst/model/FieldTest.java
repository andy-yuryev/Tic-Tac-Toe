package model;

import model.exception.AlreadyOccupiedException;
import model.exception.InvalidPointException;
import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest {

    private int size = 3;

    @Test
    public void getSize() {
        Field field = new Field(size);
        assertEquals(size, field.getSize());
    }

    @Test
    public void getFigureWhenFigureIsNotSet() {
        Field field = new Field(size);
        Point inputPoint = new Point(0, 0);
        Figure actualFigure = field.getFigure(inputPoint);
        assertNull(actualFigure);
    }

    @Test
    public void setFigure() throws AlreadyOccupiedException, InvalidPointException {
        Field field = new Field(size);
        Point inputPoint = new Point(0, 0);
        Figure inputFigure = Figure.X;
        field.setFigure(inputPoint, inputFigure);
        Figure actualFigure = field.getFigure(inputPoint);
        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void setFigureWhenXIsLessThanZero() {
        Field field = new Field(size);
        Point inputPoint = new Point(-1, 0);
        try {
            field.setFigure(inputPoint, Figure.X);
            fail();
        } catch (final InvalidPointException | AlreadyOccupiedException ignored) {
        }
    }

    @Test
    public void setFigureWhenYIsLessThanZero() {
        Field field = new Field(size);
        Point inputPoint = new Point(0, -1);
        try {
            field.setFigure(inputPoint, Figure.X);
            fail();
        } catch (final InvalidPointException | AlreadyOccupiedException ignored) {
        }
    }

    @Test
    public void setFigureWhenXIsMoreThanSize() {
        Field field = new Field(size);
        Point inputPoint = new Point(field.getSize() + 1, 0);
        try {
            field.setFigure(inputPoint, Figure.X);
            fail();
        } catch (final InvalidPointException | AlreadyOccupiedException ignored) {
        }
    }

    @Test
    public void setFigureWhenYIsMoreThanSize() {
        Field field = new Field(size);
        Point inputPoint = new Point(0, field.getSize() + 1);
        try {
            field.setFigure(inputPoint, Figure.X);
            fail();
        } catch (final InvalidPointException | AlreadyOccupiedException ignored) {
        }
    }
}
