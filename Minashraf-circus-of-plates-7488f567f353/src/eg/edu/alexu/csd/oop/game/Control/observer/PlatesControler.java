package eg.edu.alexu.csd.oop.game.Control.observer;


import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.object.ImageObject;
import eg.edu.alexu.csd.oop.game.Control.pool.Pool;
import eg.edu.alexu.csd.oop.game.Control.World.Circus;

import java.util.ArrayList;

public class PlatesControler extends Observer {
    private Circus game;
    Pool mpl = Pool.getInstance();
    ArrayList<GameObject> newControl;

    public PlatesControler(Circus game) {
        this.game = game;
        game.attach(this);
        newControl = game.getControl();
    }

    @Override
    public void update(int num) {

        if (num == 1) {
            operationL();
        } else if (num == 2) {
            operationR();
        }
    }

    private void operationL() {

        game.setCurrentMementoL(game.getCurrentMementoL() - 3);

        for (int k = 0; k < 3; k++) {
            ImageObject s = (ImageObject) game.getControlL().get(game.getControlL().size() - k - 1);
            mpl.releaseObj(s);
            newControl.remove(s);
        }
        game.setControlL((ArrayList<GameObject>) Circus.getOriginator()
                .getStateFromMemento(Circus.getCaretaker().getLeft(game.getCurrentMementoL() - 1)).clone());
        Circus.getCaretaker().removeLeft();
        Circus.getCaretaker().removeLeft();
        Circus.getCaretaker().removeLeft();
    }

    private void operationR() {

        if (game.getCurrentMementoR() >= 1) {
            game.setCurrentMementoR(game.getCurrentMementoR() - 3);
            for (int k = 0; k < 3; k++) {
                ImageObject s = (ImageObject) game.getControlR().get(game.getControlR().size() - k - 1);
                mpl.releaseObj(s);
                newControl.remove(s);
            }
            game.setControlR((ArrayList<GameObject>) Circus.getOriginator()
                    .getStateFromMemento(Circus.getCaretaker().getRight(game.getCurrentMementoR() - 1)).clone());
            Circus.getCaretaker().removeRight();
            Circus.getCaretaker().removeRight();
            Circus.getCaretaker().removeRight();
        }
    }

}

