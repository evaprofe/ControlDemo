

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
        infoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                showInfoAlert();
            }
        });
        
        warningButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                showWarningAlert();
            }
        });
        
        errorButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                showErrorAlert();
            }
        });
        
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                showConfirmAlert();
            }
        });
        
        inputButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                showInputDialog();
            }
        });
        
        choiceButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                showChoiceDialog();
            }
        });
    }
    
    private void showInfoAlert() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Diálogo de Información");
        alert.setHeaderText("Esta es una alerta de información");
        alert.setContentText("Esto muestra información importante.");
        alert.showAndWait();
    }
    
    private void showWarningAlert() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Diálogo de Advertencia");
        alert.setHeaderText("Esta es una alerta de advertencia");
        alert.setContentText("¡Esto advierte sobre algo importante!");
        alert.showAndWait();
    }
    
    private void showErrorAlert() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Diálogo de Error");
        alert.setHeaderText("Esta es una alerta de error");
        alert.setContentText("Algo salió mal!");
        alert.showAndWait();
    }
    
    private void showConfirmAlert() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Diálogo de Confirmación");
        alert.setHeaderText("Esta es una alerta de confirmación");
        alert.setContentText("¿Estás seguro de que quieres continuar?");
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.out.println("Usuario hizo clic en Aceptar");
        } else {
            System.out.println("Usuario hizo clic en Cancelar o cerrar el diálogo");
        }
    }
    
    private void showInputDialog() {
        TextInputDialog dialog = new TextInputDialog("valor predeterminado");
        dialog.setTitle("Diálogo de Entrada de Texto");
        dialog.setHeaderText("Este es un diálogo de entrada de texto");
        dialog.setContentText("Por favor, ingresa tu nombre:");
        
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> System.out.println("Tu nombre es: " + name));
    }
    
    private void showChoiceDialog() {
        List<String> choices = new ArrayList<>();
        choices.add("Opción 1");
        choices.add("Opción 2");
        choices.add("Opción 3");
        
        ChoiceDialog<String> dialog = new ChoiceDialog<>("Opción 1", choices);
        dialog.setTitle("Diálogo de Elección");
        dialog.setHeaderText("Este es un diálogo de elección");
        dialog.setContentText("Elige tu opción:");
        
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(choice -> System.out.println("Tu elección es: " + choice));
    }
}
