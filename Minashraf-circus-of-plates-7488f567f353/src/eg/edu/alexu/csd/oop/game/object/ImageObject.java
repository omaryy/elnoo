package eg.edu.alexu.csd.oop.game.object;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.Model.state.State;

import java.awt.image.BufferedImage;

public class ImageObject implements GameObject {
    private State state;
    private BufferedImage[] SpriteImage=new BufferedImage[1];
    private boolean visible;
    private String color;

    public ImageObject(int x, int y, IShape image, State state)
    {
        this.state=state;
        this.state.setX(x);
        this.state.setY(y);
        this.visible=true;
        color=image.getColor();
        SpriteImage[0]=image.getImage();
    }
    @Override
    public int getX() {
        return state.getX();
    }

    @Override
    public void setX(int x) {
        state.setX(x);
    }

    @Override
    public int getY() {
        return state.getY();
    }

    @Override
    public void setY(int y) {
        state.setY(y);
    }

    @Override
    public int getWidth() {
        return SpriteImage[0].getWidth();
    }

    @Override
    public int getHeight() {
        return SpriteImage[0].getHeight();
    }

    @Override
    public boolean isVisible() {
        return this.visible;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return SpriteImage;
    }
    public void setState(State state)
    {
        state.setX(this.state.getX());
        state.setY(this.state.getY());
        this.state=state;
    }
    public String getColor()
    {
        return this.color;
    }
}
