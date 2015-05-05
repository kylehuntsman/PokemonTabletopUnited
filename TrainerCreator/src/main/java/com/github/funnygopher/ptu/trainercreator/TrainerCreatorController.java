package com.github.funnygopher.ptu.trainercreator;

import com.github.funnygopher.ptu.trainer.Trainer;
import com.github.funnygopher.ptu.trainer.TrainerBuilder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class TrainerCreatorController implements Initializable {

    private TrainerBuilder trainerBuilder;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        trainerBuilder = new TrainerBuilder();
    }

    public TrainerBuilder getTrainerBuilder() {
        return trainerBuilder;
    }

    public void setStep(Node node) {
        pContent.getChildren().setAll(node);
    }

    @FXML
    public void onStep1Click() { StepNavigator.loadStep(StepNavigator.STEP1);}

    @FXML
    public void onStep2Click() { StepNavigator.loadStep(StepNavigator.STEP2);}

    //@FXML
    //public void onStep3Click() { StepNavigator.loadStep(StepNavigator.STEP3);}

    //@FXML
    //public void onStep4Click() { StepNavigator.loadStep(StepNavigator.STEP4);}

    @FXML
    public void onStep5Click() {
        StepNavigator.loadStep(StepNavigator.STEP5);
    }

    @FXML
    public void onStep6Click() { StepNavigator.loadStep(StepNavigator.STEP6);}

    //@FXML
    //public void onStep7Click() { StepNavigator.loadStep(StepNavigator.STEP7);}

    //@FXML
    //public void onStep8Click() { StepNavigator.loadStep(StepNavigator.STEP8);}
}
