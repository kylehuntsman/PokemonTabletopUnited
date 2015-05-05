package com.github.funnygopher.ptu.trainercreator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Step6Controller implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TrainerCreatorController controller = StepNavigator.getController();
        controller.bDescription.setDisable(false);
    }

    @FXML
    public void onContinueClick() {
        //StepNavigator.loadStep(StepNavigator.STEP7);
    }
}
