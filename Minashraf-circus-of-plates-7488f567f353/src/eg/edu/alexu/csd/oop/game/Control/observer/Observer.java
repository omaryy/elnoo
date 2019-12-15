package eg.edu.alexu.csd.oop.game.Control.observer;

import eg.edu.alexu.csd.oop.game.Control.World.Circus;

public abstract class Observer {
    protected Circus world;
    public abstract void update(int num);

}
