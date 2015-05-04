package com.github.funnygopher.ptu.trainercreator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Step2Controller implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TrainerCreator2Controller controller = StepNavigator.getController();
        controller.bBackground.setDisable(false);
    }

    @FXML
    public void onContinueClick() {
        StepNavigator.loadStep(StepNavigator.STEP5);
    }
}
