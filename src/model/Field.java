package model;

import model.exception.AlreadyOccupiedException;
import model.exception.InvalidPointException;

public class Field {

    private Figure[][] field;
    private int size;

    public Field(int size) {
        this.size = size;
        field = new Figure[size][size];
    }

    public int getSize() {
        return size;
    }

    public Figure getFigure(Point point) {
        return field[point.getX()][point.getY()];
    }

    public void setFigure(Point point, Figure figure) throws InvalidPointException, AlreadyOccupiedException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        if (getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field[point.getX()][point.getY()] = figure;
    }

    private boolean checkPoint(Point point) {
        return point.getX() >= 0 && point.getY() >= 0 && point.getX() < size && point.getY() < size;
    }
}
