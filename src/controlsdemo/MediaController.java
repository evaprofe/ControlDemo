
import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MediaController {
    
    @FXML private MediaView mediaView;
    @FXML private Button playButton;
    @FXML private Button pauseButton;
    @FXML private Button stopButton;
    @FXML private Slider volumeSlider;
    
    private MediaPlayer mediaPlayer;
    
    @FXML
    private void initialize() {
        // Load media file (replace with your own media file)
        String mediaPath = new File("src/resources/media/sample.mp4").toURI().toString();
        Media media = new Media(mediaPath);
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        
        // Set initial volume
        mediaPlayer.setVolume(volumeSlider.getValue());
        
        // Set button actions
        playButton.setOnAction(e -> mediaPlayer.play());
        pauseButton.setOnAction(e -> mediaPlayer.pause());
        stopButton.setOnAction(e -> {
            mediaPlayer.stop();
            mediaPlayer.seek(mediaPlayer.getStartTime());
        });
        
        // Bind volume slider to media player volume
        volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            mediaPlayer.setVolume(newValue.doubleValue());
        });
    }
}