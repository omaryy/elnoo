package eg.edu.alexu.csd.oop.game.Model.strategy;

public class Hard implements Strategy {
    @Override
    public int Speed() {
        return 10;
    }

    @Override
    public int ExtraTime() {
        return 1000;
    }

    @Override
    public int Score() {
        return 3;
    }

    @Override
    public int NoOfFallingShapes() {
        return 20;
    }

    @Override
    public int MaxHeightOfPlate() {
        return 10;
    }

    @Override
    public int GameTime() {
        return 1*60000;
    }

    @Override
    public int live()
    {
        return 2;
    }
}
