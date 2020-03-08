package model;

public class Game {

    private Field field;
    private boolean twoPlayerGame;

    public Game(int fieldSize, boolean twoPlayerGame) {
        this.field = new Field(fieldSize);
        this.twoPlayerGame = twoPlayerGame;
    }

    public Field getField() {
        return field;
    }

    public boolean isTwoPlayerGame() {
        return twoPlayerGame;
    }
}
