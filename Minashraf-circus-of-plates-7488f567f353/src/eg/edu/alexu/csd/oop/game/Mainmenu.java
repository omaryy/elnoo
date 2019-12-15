package eg.edu.alexu.csd.oop.game;

import eg.edu.alexu.csd.oop.game.Model.strategy.Strategy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mainmenu {
    private ScreenResolution resolution;

    public Mainmenu( ScreenResolution screenResolution) {
        resolution = screenResolution;
    }

    public void start() {
        final GameEngine.GameController[] gameController = new GameEngine.GameController[1];
        Buttongenerator buttonGenerator = new Buttongenerator(gameController[0], resolution, null);
        buttonGenerator.startMenu();
        buttonGenerator.generate();
        Difficulty difficultyBox = new Difficulty(gameController[0], resolution, buttonGenerator.menuBar);
        difficultyBox.setFrame();
        buttonGenerator.setFrame(difficultyBox.getFrame());
        difficultyBox.setButtonGenerator(buttonGenerator);
        difficultyBox.generate();
    }

}
