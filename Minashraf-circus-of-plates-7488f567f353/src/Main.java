import eg.edu.alexu.csd.oop.game.Mainmenu;
import eg.edu.alexu.csd.oop.game.ScreenResolution;

public class Main {
    public static void main(String[] args) {

        ScreenResolution resolution = new ScreenResolution();
        Mainmenu mainMenu = new Mainmenu(resolution);
        mainMenu.start();

    }
}
