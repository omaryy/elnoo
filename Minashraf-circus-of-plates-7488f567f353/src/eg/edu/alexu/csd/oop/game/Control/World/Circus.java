package eg.edu.alexu.csd.oop.game.Control.World;

import eg.edu.alexu.csd.oop.game.Control.pool.Pool;
import eg.edu.alexu.csd.oop.game.Model.state.*;
import eg.edu.alexu.csd.oop.game.Control.Snapshot.*;
import eg.edu.alexu.csd.oop.game.sound.*;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.Model.strategy.Strategy;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.Control.observer.Observer;
import eg.edu.alexu.csd.oop.game.Control.DynamicLinkage.*;
import eg.edu.alexu.csd.oop.game.object.*;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Circus implements World {

    private static int MAX_TIME;
    private int score = 0;
    private int live;
    private long startTime = System.currentTimeMillis();
    private final int width;
    private final int height;
    private Strategy difficulty;
    private ArrayList<GameObject> constant = new ArrayList<GameObject>();
    private ArrayList<GameObject> moving = new ArrayList<GameObject>();
    private ArrayList<GameObject> control = new ArrayList<GameObject>();
    private ArrayList<GameObject> controlL = new ArrayList<GameObject>();
    private ArrayList<GameObject> controlR = new ArrayList<GameObject>();
    private List<Observer> observers = new ArrayList<>();
    private static CareTaker caretaker = new CareTaker();
    private static Originator originator = new Originator();
    private int currentMementoL = 0;
    private int currentMementoR = 0;
    private ImageObject dummyL;
    private ImageObject dummyR;
    private IFacade logic;
    private int limitY;
    private int maxNum;

    public List<eg.edu.alexu.csd.oop.game.Control.observer.Observer> getObservers() {
        return observers;
    }

    public ArrayList<GameObject> getMoving() {
        return moving;
    }

    public ArrayList<GameObject> getControl() {
        return control;
    }

    public static int getMaxTime() {
        return MAX_TIME;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setControlL(ArrayList<GameObject> controlL) {
        this.controlL = controlL;
    }

    public void setControlR(ArrayList<GameObject> controlR) {
        this.controlR = controlR;
    }

    public ArrayList<GameObject> getControlL() {
        return controlL;
    }

    public ArrayList<GameObject> getControlR() {
        return controlR;
    }

    public Strategy getDifficulty() {
        return difficulty;
    }

    public int getCurrentMementoL() {
        return currentMementoL;
    }

    public int getCurrentMementoR() {
        return currentMementoR;
    }

    public static CareTaker getCaretaker() {
        return caretaker;
    }

    public void setCurrentMementoL(int currentMementoL) {
        this.currentMementoL = currentMementoL;
    }

    public void setCurrentMementoR(int currentMementoR) {
        this.currentMementoR = currentMementoR;
    }

    public static Originator getOriginator() {
        return originator;
    }

    public Circus(int width, int height, Strategy difficulty) {

        this.width = width;
        this.height = height;
        this.difficulty = difficulty;
        Circus.MAX_TIME = this.difficulty.GameTime();
        this.limitY = this.difficulty.MaxHeightOfPlate();
        this.maxNum = this.difficulty.NoOfFallingShapes();
        this.live=this.difficulty.live();
        State state;
        List<Class<?>> listofClasses = new DynamicLoading().load();
        IShape shape = null;
        state = new ConstantObject();

        try {
            shape = (IShape) listofClasses.get(0).getConstructor(String.class).newInstance("");
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }

        ImageObject bg = new ImageObject(0, 0, shape,  state);
        constant.add(bg);
        try {
            shape = (IShape) listofClasses.get(2).getConstructor(String.class).newInstance("");
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        state = new ControlableObject(width / 3, (int) (height * 0.6));
        ImageObject clown = new ImageObject(width / 3, (int) (height * 0.6), shape, state);
        try {
            shape = (IShape) listofClasses.get(4).getConstructor(String.class).newInstance("");
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        state = new ControlableObject(clown.getX() - 25, clown.getY() - 10);
        dummyL = new ImageObject(clown.getX() - 25, clown.getY() - 10, shape, state);
        state = new ControlableObject(clown.getX() + clown.getWidth() - 45, clown.getY() - 10);
        dummyR = new ImageObject(clown.getX() + clown.getWidth() - 45, clown.getY() - 10, shape,  state);
        control.add(clown);
        control.add(dummyL);
        control.add(dummyR);
        controlR.add(dummyR);
        controlL.add(dummyL);
        Sound.getInstance().stopTheme();
        Sound.getInstance().startTheme();
        Pool mpl = Pool.getInstance();
        mpl.setNum(maxNum);
        mpl.setPool(width, height);
        moving = mpl.usePool();
        logic = new Facade(this);
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return control;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public ImageObject getDummyL() {
        return dummyL;
    }

    public ImageObject getDummyR() {
        return dummyR;
    }

    @Override
    public boolean refresh() {
        logic.pooling();
        logic.iterate();
        return logic.refreshLogic();
    }

    @Override
    public String getStatus() {
        String s = "Score=" + score + "   |   Time="
                + Math.max(0, (MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000)+"   |   Live="+this.getLive();
        return s; // update status
    }

    @Override
    public int getSpeed() {
        return difficulty.Speed();
    }

    @Override
    public int getControlSpeed() {
        return 20;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public int getTime() {
        return Circus.MAX_TIME;
    }

    public int getScore() {
        return this.score;
    }

    public Circus getCircus() {
        return this;
    }

    public void setTime(int sTime) {
        MAX_TIME = sTime;
    }

    public void setScore(int score) {
        score = Math.max(score, 0);
        this.score = score;
    }

    public int getLive()
    {
        return this.live;
    }

    public void setLive(int live)
    {
        this.live=live;
    }

    public int getMaxY() {
        return this.limitY;
    }

    public int getMaxNum() {
        return this.maxNum;
    }

}
