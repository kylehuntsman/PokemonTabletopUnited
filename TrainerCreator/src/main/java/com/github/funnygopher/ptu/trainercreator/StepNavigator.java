package com.github.funnygopher.ptu.trainercreator;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class StepNavigator {

    public static final String MAIN = "/gui/TrainerCreator2.fxml";
    public static final String STEP1 = "/gui/Step1.fxml";
    public static final String STEP2 = "/gui/Step2.fxml";
    public static final String STEP3 = "/gui/Step3.fxml";
    public static final String STEP4 = "/gui/Step4.fxml";
    public static final String STEP5 = "/gui/Step5.fxml";
    public static final String STEP6 = "/gui/Step6.fxml";
    public static final String STEP7 = "/gui/Step7.fxml";
    public static final String STEP8 = "/gui/Step8.fxml";

    public static final String[] STEPS = new String[] {
            STEP1, STEP2, STEP3, STEP4, STEP5, STEP6, STEP7, STEP8
    };

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
