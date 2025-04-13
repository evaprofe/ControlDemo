
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.util.Duration;

public class ProgressController {
    
    @FXML private ProgressBar progressBar;
    @FXML private ProgressIndicator progressIndicator;
    @FXML private Button startButton;
    @FXML private Button resetButton;
    
    private Timeline timeline;
    
    @FXML
    private void initialize() {
        startButton.setOnAction(e -> startProgress());
        resetButton.setOnAction(e -> resetProgress());
    }
    
    private void startProgress() {
        timeline = new Timeline(
            new KeyFrame(Duration.ZERO, e -> {
                progressBar.setProgress(0);
                progressIndicator.setProgress(0);
            }),
            new KeyFrame(Duration.seconds(3), e -> {
                progressBar.setProgress(1);
                progressIndicator.setProgress(1);
            })
        );
        timeline.play();
    }
    
    private void resetProgress() {
        if (timeline != null) {
            timeline.stop();
        }
        progressBar.setProgress(0);
        progressIndicator.setProgress(0);
    }
}