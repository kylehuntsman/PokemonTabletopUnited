package com.github.funnygopher.ptu.trainercreator;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class StepNavigator {

    public static final String MAIN = "/gui/TrainerCreator2.fxml";
    public static final String STEP1 = "/gui/Step1.fxml";
    public static final String STEP2 = "/gui/Step2.fxml";

    private static TrainerCreator2Controller trainerCreator2Controller;

    public static void setController(TrainerCreator2Controller controller) {
        StepNavigator.trainerCreator2Controller = controller;
    }

    public static void loadStep(String fxml) {
        try {
            trainerCreator2Controller.setStep(FXMLLoader.load(StepNavigator.class.getResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TrainerCreator2Controller getController() {
        return trainerCreator2Controller;
    }
}
