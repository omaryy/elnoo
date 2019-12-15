package eg.edu.alexu.csd.oop.game.Model.flyweight;

import eg.edu.alexu.csd.oop.game.Control.DynamicLinkage.DynamicLoading;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.Model.state.MovableObject;
import eg.edu.alexu.csd.oop.game.Model.state.State;
import eg.edu.alexu.csd.oop.game.object.IShape;
import eg.edu.alexu.csd.oop.game.object.ImageObject;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FlyWeight {
    ArrayList<GameObject> shapes = new ArrayList<GameObject>();
    List<Class<?>> listofClasses;
    private static final HashMap classMap = new HashMap<>();
    private int max;

    public FlyWeight(int num) {
        DynamicLoading x = new DynamicLoading();
        this.listofClasses = x.load();
        max = num;
    }

    public ArrayList<GameObject> createPlates(int width, int height) {

        for (int i = 0; i < max; ++i) {
            State state = new MovableObject();
            shapes.add(new ImageObject((int) (Math.random() * width), (int) (Math.random() * -1 * height),
                    getRandomshape(), state));

        }
        return shapes;
    }

    private IShape getRandomshape() {
        IShape shape = null;
        String color;
        int num1 = (1 + (int) (Math.random() * 3));
        int num2 = (1 + (int) (Math.random() * 5));
        if (num2 == 1) {
            color = "black";
        } else if (num2 == 2) {
            color = "blue";
        } else if(num2==3) {
            color = "green";
        }else if(num2==4) {
            color = "red";
        }else {
            color = "yellow";
        }

        if (num1 == 1) {
            if (classMap.get(color + "Plate") == null) {
                try {
                    classMap.put(color + "Plate", listofClasses.get(4).getConstructor(String.class).newInstance(color));
                    shape = (IShape) classMap.get(color + "Plate");
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                    e.printStackTrace();
                }
            } else {
                shape = (IShape)classMap.get(color + "Plate");
            }
        } else if(num1==2) {
            if (classMap.get(color + "Pot") == null) {
                try {
                    classMap.put(color + "Pot", listofClasses.get(5).getConstructor(String.class).newInstance(color));
                    shape = (IShape) classMap.get(color + "Pot");
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                    e.printStackTrace();
                }
            } else {
                shape = (IShape)classMap.get(color + "Pot");
            }
        }else
        {
            if (classMap.get("Bomb") == null) {
                try {
                    classMap.put("Bomb", listofClasses.get(1).getConstructor(String.class).newInstance("0"));
                    shape = (IShape) classMap.get("Bomb");
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                    e.printStackTrace();
                }
            } else {
                shape = (IShape)classMap.get("Bomb");
            }
        }
        return shape;
    }
}
