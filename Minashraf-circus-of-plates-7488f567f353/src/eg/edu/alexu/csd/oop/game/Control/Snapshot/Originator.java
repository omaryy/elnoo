package eg.edu.alexu.csd.oop.game.Control.Snapshot;

import java.util.ArrayList;

public class Originator {
    private ArrayList<?> state;

    public void setState(ArrayList<?> state){
        this.state = (ArrayList<?>) state.clone();
    }


    public Memento saveStateToMemento(){
        return new Memento((ArrayList<?>)state.clone());
    }

    public ArrayList<?> getStateFromMemento(Memento memento){
        state = (ArrayList<?>)memento.getState().clone();
        return (ArrayList<?>) state.clone();
    }

}
