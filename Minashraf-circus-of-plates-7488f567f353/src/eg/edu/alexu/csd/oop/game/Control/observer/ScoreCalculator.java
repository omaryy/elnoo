package eg.edu.alexu.csd.oop.game.Control.observer;

import eg.edu.alexu.csd.oop.game.Control.World.Circus;
import eg.edu.alexu.csd.oop.game.Model.strategy.Strategy;

public class ScoreCalculator extends Observer {
    Circus game;
    private Strategy strategy;

    public ScoreCalculator(Circus game) {
        this.game = game;
        this.strategy=game.getDifficulty();
        game.attach(this);
    }

    @Override
    public void update(int num) {
        game.setScore(game.getScore() + strategy.Score());
    }
}
