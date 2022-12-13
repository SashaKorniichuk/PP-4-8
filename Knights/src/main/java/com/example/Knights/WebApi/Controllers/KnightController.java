package com.example.Knights.WebApi.Controllers;

import com.example.Knights.Data.Entities.Knight.Knight;
import com.example.Knights.Domain.Services.KnightService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("knights.fxml")
public class KnightController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private ListView<Knight> knightList;
    @FXML
    private Button addButton;

    @FXML
    private Spinner<Integer> ageInput;
    @FXML
    private Spinner<Integer> healthInput;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField titleInput;
    private final KnightService knightService;
    private final FxWeaver fxWeaver;

    @Autowired
    public KnightController(KnightService knightService, FxWeaver fxWeaver) {
        this.knightService = knightService;
        this.fxWeaver = fxWeaver;

    }

    @FXML
    void addKnight(ActionEvent event) {
        Knight knightViewModel = new Knight();
        knightViewModel.setTitle(titleInput.getText());
        knightViewModel.setName(nameInput.getText());
        knightViewModel.setAge(ageInput.getValue());
        knightViewModel.setHitPoints(healthInput.getValue());

        var response = knightService.addKnight(knightViewModel);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Knights");

        alert.setHeaderText(null);

        if (response.getStatusCode() == HttpStatus.CREATED) {
            alert.setContentText("Knight was added!");
            this.knightList.setItems(knightService.getAllKnights());
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Knight was not added!");
        }
        alert.showAndWait();
    }

    @FXML
    void back(ActionEvent event) {
        String stylesheet = getClass().getResource("/css/styles.css").toExternalForm();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxWeaver.loadView(MainController.class));
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.knightList.setItems(knightService.getAllKnights());
    }
}
