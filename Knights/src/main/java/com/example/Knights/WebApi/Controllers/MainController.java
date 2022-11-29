package com.example.Knights.WebApi.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Component
@FxmlView("menu.fxml")
public class MainController {
    @FXML
    private Button ammunitionButton;

    @FXML
    private Button knightsButton;

    @FXML
    private Button shopButton;

    private final FxWeaver fxWeaver;

    @Autowired
    public MainController(FxWeaver _fxWeaver) {
        this.fxWeaver=_fxWeaver;
    }

    @FXML
    void ammunition(ActionEvent event) {

    }

    @FXML
    void knights(ActionEvent event) throws IOException {

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxWeaver.loadView(KnightController.class));
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void shop(ActionEvent event) {

    }
}
