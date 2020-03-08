import model.Game;
import view.*;

public class Main {

    public static void main(String[] args) {
        GameView gameView = new ConsoleView();
        boolean twoPlayerGame = gameView.startMenu();
        Game game = new Game(3, twoPlayerGame);

        while (gameView.move(game)) {
            gameView.printField(game);
        }
    }
}
