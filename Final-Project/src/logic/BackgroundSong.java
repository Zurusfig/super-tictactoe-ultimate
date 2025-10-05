package logic;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;

public class BackgroundSong {

    private MediaPlayer musicPlayer;
    private static BackgroundSong instance = null;

    public void playBackgroundMusic() {
        String mediaPath = "/res/media/themesong3.wav";
        URL mediaURL = getClass().getResource(mediaPath);
        assert mediaURL != null;
        Media media = new Media(mediaURL.toString());
        musicPlayer = new MediaPlayer(media);



        Thread thread = new Thread(() -> {
            musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            musicPlayer.play();
        });
        thread.start();
//        musicPlayer.setOnReady(() -> {
//            musicPlayer.play();
//        });


    }

    public void stopBackgroundMusic() {
        if (musicPlayer != null) {
            musicPlayer.stop();
        }
    }

    public static BackgroundSong getInstance() {
        if(instance == null) {
            instance = new BackgroundSong();
        }
        return instance;
    }
}
