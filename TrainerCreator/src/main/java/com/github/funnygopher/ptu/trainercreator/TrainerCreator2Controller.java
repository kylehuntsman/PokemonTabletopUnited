package com.github.funnygopher.ptu.trainercreator;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class TrainerCreator2Controller {

    @FXML
    private AnchorPane pContent;
    public Button bTrainerConcept;
    public Button bBackground;
    public Button bEdges;
    public Button bFeatures;
    public Button bStats;
    public Button bDescription;
    public Button bPokemon;
    public Button bMoneyItems;

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
