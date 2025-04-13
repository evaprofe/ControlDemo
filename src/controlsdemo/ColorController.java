
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorController {
    
    @FXML private ColorPicker colorPicker;
    @FXML private Button applyColorButton;
    @FXML private Rectangle colorDisplay;
    
    @FXML
    private void initialize() {
        // Set initial color
        colorPicker.setValue(Color.BLUE);
        colorDisplay.setFill(colorPicker.getValue());
        
        // Set button action
        applyColorButton.setOnAction(e -> colorDisplay.setFill(colorPicker.getValue()));
    }
}