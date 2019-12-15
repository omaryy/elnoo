package eg.edu.alexu.csd.oop.game.Control.Snapshot;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<Memento> mementoListRight = new ArrayList<Memento>();
    private List<Memento> mementoListLeft = new ArrayList<Memento>();

    public void addRight(Memento state){
        mementoListRight.add(state);
    }

    public Memento getRight(int index){
        return mementoListRight.get(index);
    }

    public Memento removeRight()
    {
        return mementoListRight.remove(mementoListRight.size()-1);
    }

    public void addLeft(Memento state){
        mementoListLeft.add(state);
    }

    public Memento getLeft(int index){
        return mementoListLeft.get(index);
    }

    public Memento removeLeft()
    {
        return mementoListLeft.remove(mementoListLeft.size()-1);
    }
}
