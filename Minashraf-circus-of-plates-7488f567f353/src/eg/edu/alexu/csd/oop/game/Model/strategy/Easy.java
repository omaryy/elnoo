package eg.edu.alexu.csd.oop.game.Model.strategy;

public class Easy implements Strategy {
    @Override
    public int Speed() {
        return 30;
    }

    @Override
    public int ExtraTime() {
        return 3000;
    }

    @Override
    public int Score() {
        return 10;
    }

    @Override
    public int NoOfFallingShapes() {
        return 30;
    }

    @Override
    public int MaxHeightOfPlate() {
        return 20;
    }

    @Override
    public int GameTime() {
        return 5*60000;
    }

    @Override
    public int live()
    {
        return 5;
    }
}
