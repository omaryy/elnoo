package eg.edu.alexu.csd.oop.game.Model.state;

public class ControlableObject implements State {
    private int x;
    private int y;

    public ControlableObject(int x , int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void setX(int x) {
        this.x=x;
    }

    @Override
    public void setY(int y) {

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
