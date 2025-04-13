
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {
    
    @FXML private Button alertButton;
    @FXML private Button progressButton;
    @FXML private Button listButton;
    @FXML private Button menuButton;
    @FXML private Button dateButton;
    @FXML private Button colorButton;
    @FXML private Button mediaButton;
    
    @FXML
    private void initialize() {
        alertButton.setOnAction(e -> showWindow("Alert Demo", "alert.fxml"));
        progressButton.setOnAction(e -> showWindow("Progress Demo", "progress.fxml"));
        listButton.setOnAction(e -> showWindow("List Demo", "list.fxml"));
        menuButton.setOnAction(e -> showWindow("Menu Demo", "menu.fxml"));
        dateButton.setOnAction(e -> showWindow("DatePicker Demo", "date.fxml"));
        colorButton.setOnAction(e -> showWindow("ColorPicker Demo", "color.fxml"));
        mediaButton.setOnAction(e -> showWindow("Media Player Demo", "media.fxml"));
    }
    
    private void showWindow(String title, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + fxmlFile));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}