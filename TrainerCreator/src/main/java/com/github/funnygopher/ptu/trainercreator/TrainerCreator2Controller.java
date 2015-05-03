package com.github.funnygopher.ptu.trainercreator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TrainerCreator2Controller {

    @FXML
    AnchorPane pContent;

    public void setStep(Node node) {
        pContent.getChildren().setAll(node);
    }

    @FXML
    public void onStep1Click() {
        StepNavigator.loadStep(StepNavigator.STEP1);
    }

    @FXML
    public void onStep2Click() {
        StepNavigator.loadStep(StepNavigator.STEP2);
    }
}
