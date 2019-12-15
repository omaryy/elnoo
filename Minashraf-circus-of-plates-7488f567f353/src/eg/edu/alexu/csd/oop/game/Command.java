package eg.edu.alexu.csd.oop.game;

import javax.swing.*;

public abstract class Command {
    protected GameEngine.GameController gameController;
    protected ScreenResolution resolution;
    protected JMenuBar menuBar;

    public Command(GameEngine.GameController gameController, ScreenResolution resolution, JMenuBar menuBar) {
        this.gameController = gameController;
        this.resolution = resolution;
        this.menuBar = menuBar;
    }
    public abstract void generate();
}
