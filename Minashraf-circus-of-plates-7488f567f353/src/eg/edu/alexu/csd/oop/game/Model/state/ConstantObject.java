package eg.edu.alexu.csd.oop.game.Model.state;

public class ConstantObject implements State {
    private int x;
    private int y;
    @Override
    public void setX(int x) {
        return;
    }

    @Override
    public void setY(int y) {
        return;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }
}
