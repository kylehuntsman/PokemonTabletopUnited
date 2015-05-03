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
    public void onStep1Click() { StepNavigator.loadStep(StepNavigator.STEP1);}

    @FXML
    public void onStep2Click() { StepNavigator.loadStep(StepNavigator.STEP2);}

    @FXML
    public void onStep3Click() { StepNavigator.loadStep(StepNavigator.STEP3);}

    @FXML
    public void onStep4Click() { StepNavigator.loadStep(StepNavigator.STEP4);}

    @FXML
    public void onStep5Click() { StepNavigator.loadStep(StepNavigator.STEP5);}

    @FXML
    public void onStep6Click() { StepNavigator.loadStep(StepNavigator.STEP6);}

    @FXML
    public void onStep7Click() { StepNavigator.loadStep(StepNavigator.STEP7);}

    @FXML
    public void onStep8Click() { StepNavigator.loadStep(StepNavigator.STEP8);}
}
