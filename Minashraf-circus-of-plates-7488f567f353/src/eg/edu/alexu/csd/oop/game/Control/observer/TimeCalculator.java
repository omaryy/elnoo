package eg.edu.alexu.csd.oop.game.Control.observer;

import eg.edu.alexu.csd.oop.game.Control.World.Circus;
import eg.edu.alexu.csd.oop.game.Model.strategy.Strategy;

public class TimeCalculator extends Observer {
    private Circus game;
    private Strategy strategy;

    public TimeCalculator(Circus game) {
        this.game = game;
        this.strategy=game.getDifficulty();
        game.attach(this);
    }

    @Override
    public void update(int num) {
        // TODO this must be called from strategy
        game.setTime(game.getTime() + strategy.ExtraTime());
    }
}
