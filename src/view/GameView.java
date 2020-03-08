package view;

import model.Game;

public interface GameView {

    boolean startMenu();

    boolean move(Game game);

    void printField(Game game);
}
