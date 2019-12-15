package eg.edu.alexu.csd.oop.game;

import eg.edu.alexu.csd.oop.game.Control.World.Circus;
import eg.edu.alexu.csd.oop.game.Model.strategy.Easy;
import eg.edu.alexu.csd.oop.game.Model.strategy.Hard;
import eg.edu.alexu.csd.oop.game.Model.strategy.Medium;
import eg.edu.alexu.csd.oop.game.Model.strategy.Strategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttongenerator extends Command {

    private Strategy strategy;
    private Button e,m,h;
    private JFrame frame;
    private Menubar menuBarGenerator;

    public Menubar getMenuBarGenerator() {
        return menuBarGenerator;
    }

    public void startMenu(){
        menuBar = new JMenuBar();
        JMenuItem newgame = new JMenuItem("New");
        newgame.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                gameController.changeWorld( new Circus(resolution.getWidth(),resolution.getHeight(), strategy));
            }});
        JMenu menu = new JMenu("File");
        JMenuItem  exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JMenuItem pauseMenuItem = new JMenuItem("Pause");
        JMenuItem resumeMenuItem = new JMenuItem("Resume");
        menuBar.add(menu);
        pauseMenuItem.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                gameController.pause();
            }
        });
        resumeMenuItem.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                gameController.resume();
            }
        });
        menu.add(newgame);
        menu.addSeparator();
        menu.add(pauseMenuItem);
        menu.add(resumeMenuItem);
        menu.addSeparator();
        menu.add(exitMenuItem);
        menuBar.add(menu);
    }

    public void setMenuBarGenerator(Menubar menuBarGenerator) {
        this.menuBarGenerator = menuBarGenerator;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public GameEngine.GameController getControl() {
        return this.gameController;
    }

    public Buttongenerator(GameEngine.GameController gameController, ScreenResolution resolution, JMenuBar menuBar) {
        super(gameController, resolution, menuBar);
    }

    public void generate(){
        //easy Button
        e = new Button();
        e.setSize(100,100);
        e.setLabel("EASY");
        e.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                setStrategy(1);
                frame.setVisible(false);
                gameController = GameEngine.start("Circus of plates", new Circus(resolution.getWidth(),resolution.getHeight(),strategy), menuBar, Color.BLACK);
            }});
        //normal Button
        m = new Button();
        m.setSize(100,100);
        m.setLabel("MEDIUM");
        m.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                setStrategy(2);
                frame.setVisible(false);
                gameController = GameEngine.start("Circus of plates", new Circus(resolution.getWidth(),resolution.getHeight(), strategy), menuBar, Color.BLACK);
            }});
        //hard Button
        h = new Button();
        h.setSize(100,100);
        h.setLabel("HARD");
        h.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                setStrategy(3);
                frame.setVisible(false);
                gameController = GameEngine.start("Circus of plates"
                        , new Circus(resolution.getWidth(),resolution.getHeight(), strategy)
                        , menuBar, Color.BLACK);
            }});
//        return  strategy;
    }

    public void setStrategy(int x){
        if(x==1){
            strategy=new Easy();
        }else if(x==2){
            strategy = new Medium();
        }else if(x==3){
            strategy = new Hard();
        }
    }

    public Strategy getStrategy() {
        return strategy;
    }


    public Button getE() {
        return e;
    }

    public Button getM() {
        return m;
    }

    public Button getH() {
        return h;
    }

}
