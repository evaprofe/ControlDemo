
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class DateController {
    
    @FXML private DatePicker datePicker;
    @FXML private Button showDateButton;
    @FXML private Label dayLabel;
    @FXML private Label monthLabel;
    @FXML private Label yearLabel;
    
    @FXML
    private void initialize() {
        // Set initial date to today
        datePicker.setValue(LocalDate.now());
        
        // Set button action
        showDateButton.setOnAction(e -> showDateDetails());
    }
    
    private void showDateDetails() {
        LocalDate selectedDate = datePicker.getValue();
        
        if (selectedDate != null) {
            dayLabel.setText(String.valueOf(selectedDate.getDayOfMonth()));
            monthLabel.setText(String.valueOf(selectedDate.getMonthValue()));
            yearLabel.setText(String.valueOf(selectedDate.getYear()));
        } else {
            dayLabel.setText("-");
            monthLabel.setText("-");
            yearLabel.setText("-");
        }
    }
}