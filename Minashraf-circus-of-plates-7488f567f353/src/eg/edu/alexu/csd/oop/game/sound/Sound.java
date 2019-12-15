package eg.edu.alexu.csd.oop.game.sound;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {

    private static Sound sound ;

    private Clip Theme, gameOver, tickTock, Gotcha, Two,Boom;
    private static boolean finished = false, almost = false;

    private Sound() {
    }

    public static Sound getInstance() {
        if(sound==null)
            sound=new Sound();
        return sound;
    }

    public void startTheme() {
        try {
            URL url = Sound.class.getResource("/Theme.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Theme = AudioSystem.getClip();
            Theme.open(audioIn);
            FloatControl gainControl = (FloatControl) Theme.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-12.0f);
            Theme.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopTheme() {
        if(Theme!=null)
            Theme.stop();
    }

    public void gameOver() {
        if (!finished) {
            try {
                finished = true;
                URL url = Sound.class.getResource("/GameOver.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                gameOver = AudioSystem.getClip();
                gameOver.open(audioIn);
                gameOver.start();
                if(tickTock!=null)
                    tickTock.stop();
                Theme.stop();
                Gotcha.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void almostDone() {
        if (!almost) {
            try {
                almost = true;
                URL url = Sound.class.getResource("/TimeFinishing.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                tickTock = AudioSystem.getClip();
                tickTock.open(audioIn);
                tickTock.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void boom() {
        try {
            URL url = Sound.class.getResource("/Boom.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Boom = AudioSystem.getClip();
            Boom.open(audioIn);
            Boom.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void caught() {
        try {
            URL url = Sound.class.getResource("/Caught.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Gotcha = AudioSystem.getClip();
            Gotcha.open(audioIn);
            Gotcha.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void two() {
        try {
            URL url = Sound.class.getResource("/Fall.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Two = AudioSystem.getClip();
            Two.open(audioIn);
            Two.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
