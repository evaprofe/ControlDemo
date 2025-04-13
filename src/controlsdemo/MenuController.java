


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;

public class MenuController {
    
    // Elementos del menú
    @FXML private MenuItem newMenuItem;
    @FXML private MenuItem openMenuItem;
    @FXML private MenuItem saveMenuItem;
    @FXML private MenuItem exitMenuItem;
    @FXML private MenuItem cutMenuItem;
    @FXML private MenuItem copyMenuItem;
    @FXML private MenuItem pasteMenuItem;
    @FXML private MenuItem aboutMenuItem;

    // Elementos del toolbar
    @FXML private Button btnNew;
    @FXML private Button btnOpen;
    @FXML private Button btnSave;
    @FXML private Button btnCut;
    @FXML private Button btnCopy;
    @FXML private Button btnPaste;

    @FXML
    private void initialize() {
        // Configurar menús
        newMenuItem.setOnAction(e -> showAlert("New", "Creating new file"));
        openMenuItem.setOnAction(e -> showAlert("Open", "Opening file"));
        saveMenuItem.setOnAction(e -> showAlert("Save", "Saving file"));
        exitMenuItem.setOnAction(e -> System.exit(0));
        cutMenuItem.setOnAction(e -> showAlert("Cut", "Cutting to clipboard"));
        copyMenuItem.setOnAction(e -> showAlert("Copy", "Copying to clipboard"));
        pasteMenuItem.setOnAction(e -> showAlert("Paste", "Pasting from clipboard"));
        aboutMenuItem.setOnAction(e -> showAlert("About", "JavaFX Controls Demo\nVersion 1.0"));

        // Configurar botones del toolbar
        btnNew.setOnAction(e -> showAlert("New", "Creating new file"));
        btnOpen.setOnAction(e -> showAlert("Open", "Opening file"));
        btnSave.setOnAction(e -> showAlert("Save", "Saving file"));
        btnCut.setOnAction(e -> showAlert("Cut", "Cutting to clipboard"));
        btnCopy.setOnAction(e -> showAlert("Copy", "Copying to clipboard"));
        btnPaste.setOnAction(e -> showAlert("Paste", "Pasting from clipboard"));
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}