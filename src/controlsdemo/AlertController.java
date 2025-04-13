
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlertController {
    
    @FXML private Button infoButton;
    @FXML private Button warningButton;
    @FXML private Button errorButton;
    @FXML private Button confirmButton;
    @FXML private Button inputButton;
    @FXML private Button choiceButton;
    
    @FXML
    private void initialize() {
        infoButton.setOnAction(e -> showInfoAlert());
        warningButton.setOnAction(e -> showWarningAlert());
        errorButton.setOnAction(e -> showErrorAlert());
        confirmButton.setOnAction(e -> showConfirmAlert());
        inputButton.setOnAction(e -> showInputDialog());
        choiceButton.setOnAction(e -> showChoiceDialog());
    }
    
    private void showInfoAlert() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("This is an information alert");
        alert.setContentText("This shows some important information.");
        alert.showAndWait();
    }
    
    private void showWarningAlert() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText("This is a warning alert");
        alert.setContentText("This warns about something important!");
        alert.showAndWait();
    }
    
    private void showErrorAlert() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("This is an error alert");
        alert.setContentText("Something went wrong!");
        alert.showAndWait();
    }
    
    private void showConfirmAlert() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("This is a confirmation alert");
        alert.setContentText("Are you sure you want to proceed?");
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.out.println("User clicked OK");
        } else {
            System.out.println("User clicked Cancel or closed the dialog");
        }
    }
    
    private void showInputDialog() {
        TextInputDialog dialog = new TextInputDialog("default value");
        dialog.setTitle("Text Input Dialog");
        dialog.setHeaderText("This is a text input dialog");
        dialog.setContentText("Please enter your name:");
        
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> System.out.println("Your name is: " + name));
    }
    
    private void showChoiceDialog() {
        List<String> choices = new ArrayList<>();
        choices.add("Option 1");
        choices.add("Option 2");
        choices.add("Option 3");
        
        ChoiceDialog<String> dialog = new ChoiceDialog<>("Option 1", choices);
        dialog.setTitle("Choice Dialog");
        dialog.setHeaderText("This is a choice dialog");
        dialog.setContentText("Choose your option:");
        
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(choice -> System.out.println("Your choice is: " + choice));
    }
}