
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ListController {
    
    @FXML private ListView<String> listView;
    @FXML private ChoiceBox<String> choiceBox;
    @FXML private ComboBox<String> comboBox;
    @FXML private Slider slider;
    @FXML private Button showSelectionButton;
    
    @FXML
    private void initialize() {
        // Initialize ListView
        ObservableList<String> items = FXCollections.observableArrayList(
            "Item 1", "Item 2", "Item 3", "Item 4", "Item 5");
        listView.setItems(items);
        listView.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.MULTIPLE);
        
        // Initialize ChoiceBox
        choiceBox.setItems(items);
        choiceBox.setValue("Item 1");
        
        // Initialize ComboBox
        comboBox.setItems(items);
        comboBox.setValue("Item 1");
        comboBox.setEditable(true);
        
        // Initialize Slider
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(50);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(25);
        slider.setMinorTickCount(5);
        slider.setBlockIncrement(10);
        
        // Set button action
        showSelectionButton.setOnAction(e -> showSelection());
    }
    
    private void showSelection() {
        StringBuilder message = new StringBuilder();
        
        message.append("ListView selected: ");
        listView.getSelectionModel().getSelectedItems().forEach(item -> message.append(item).append(", "));
        
        message.append("\nChoiceBox selected: ").append(choiceBox.getValue());
        message.append("\nComboBox selected: ").append(comboBox.getValue());
        message.append("\nSlider value: ").append((int)slider.getValue());
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Selection Information");
        alert.setHeaderText("Current Selections");
        alert.setContentText(message.toString());
        alert.showAndWait();
    }
}