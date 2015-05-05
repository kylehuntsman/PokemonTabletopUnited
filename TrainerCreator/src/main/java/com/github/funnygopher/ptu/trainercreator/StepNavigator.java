package com.github.funnygopher.ptu.trainercreator;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class StepNavigator {

    public static final String MAIN = "/gui/TrainerCreator.fxml";
    public static final String STEP1 = "/gui/Step1.fxml";
    public static final String STEP2 = "/gui/Step2.fxml";
    //public static final String STEP3 = "/gui/Step3.fxml";
    //public static final String STEP4 = "/gui/Step4.fxml";
    public static final String STEP5 = "/gui/Step5.fxml";
    public static final String STEP6 = "/gui/Step6.fxml";
    //public static final String STEP7 = "/gui/Step7.fxml";
    //public static final String STEP8 = "/gui/Step8.fxml";

    private static TrainerCreatorController trainerCreatorController;

    public static void setController(TrainerCreatorController controller) {
        StepNavigator.trainerCreatorController = controller;
    }

    public static void loadStep(String fxml) {
        try {
            trainerCreatorController.setStep(FXMLLoader.load(StepNavigator.class.getResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TrainerCreatorController getController() {
        return trainerCreatorController;
    }
}
