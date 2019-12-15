package eg.edu.alexu.csd.oop.game;

import eg.edu.alexu.csd.oop.game.Control.World.Circus;
import eg.edu.alexu.csd.oop.game.Model.strategy.Strategy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menubar extends Command {

        private Strategy strategy;

        public void setStrategy(Strategy strategy) {
            this.strategy = strategy;
        }

        public Menubar(GameEngine.GameController gameController, ScreenResolution resolution, JMenuBar menuBar) {
            super(gameController, resolution, menuBar);
        }

        public void generate() {
            menuBar = new JMenuBar();
            JMenuItem newgame = new JMenuItem("New");
            newgame.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameController.changeWorld(new Circus(resolution.getWidth(), resolution.getHeight(), strategy));
                }
            });
            JMenu menu = new JMenu("File");
            JMenuItem exitMenuItem = new JMenuItem("Exit");
            exitMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            JMenuItem pauseMenuItem = new JMenuItem("Pause");
            JMenuItem resumeMenuItem = new JMenuItem("Resume");
            menuBar.add(menu);
            pauseMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameController.pause();
                }
            });
            resumeMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
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

        public JMenuBar getMenuBar() {
            return this.menuBar;
        }

        public void setControl(GameEngine.GameController control) {
            this.gameController = control;
        }
    }


