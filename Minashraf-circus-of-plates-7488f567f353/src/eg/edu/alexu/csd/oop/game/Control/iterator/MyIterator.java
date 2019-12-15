package eg.edu.alexu.csd.oop.game.Control.iterator;

import java.util.ArrayList;

public class MyIterator implements StartIterator {
    private ArrayList<?>  arrayList;

    public MyIterator(ArrayList<?> temp)
    {
        this.arrayList=temp;
    }
    @Override
    public Iterator CreateIterator() {
        return new IteratorConcrete();
    }
    private class IteratorConcrete implements Iterator
    {
        private int index=0;
        @Override
        public boolean hasNext() {
            return index<arrayList.size();
        }

        @Override
        public Object next() {
            if(this.hasNext())
                return arrayList.get(index++);
            return null;
        }
    }
}
