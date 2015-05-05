package com.github.funnygopher.ptu.trainercreator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Step5Controller implements Initializable {

    @FXML
    public Slider hp, attack, defense, spAttack, spDefense, speed;
    @FXML
    public TextField txtCombatStatPoints, txtPhyEvasion, txtSpEvasion, txtSpeedEvasion;
    @FXML
    public Button bContinue;

    private Slider[] sliders;

    private int combatStatPoints;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TrainerCreatorController controller = StepNavigator.getController();
        controller.bStats.setDisable(false);

        sliders = new Slider[] {
          hp, attack, defense, spAttack, spDefense, speed
        };

        updateCombatStatPoints();

        for (int i = 0; i < sliders.length; i++) {
            Slider currSlider = sliders[i];
            currSlider.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    updateCombatStatPoints();
                    if(combatStatPoints < 0) {
                        currSlider.setValue(newValue.intValue() + combatStatPoints);
                        updateCombatStatPoints();
                    }
                }
            });
        }
    }

    public void onContinueClick() {
        StepNavigator.loadStep(StepNavigator.STEP6);
    }

    private void updateCombatStatPoints() {
        combatStatPoints = 45 - (int) hp.getValue() - (int) attack.getValue()
                - (int) defense.getValue() - (int) spAttack.getValue()
                - (int) spDefense.getValue() - (int) speed.getValue();
        txtCombatStatPoints.setText(Integer.toString(combatStatPoints));

        updateEvasions();
        updateContinueButton();
    }

    private void updateEvasions() {
        txtPhyEvasion.setText(Integer.toString(getEvasion(defense.getValue())));
        txtSpEvasion.setText(Integer.toString(getEvasion(spDefense.getValue())));
        txtSpeedEvasion.setText(Integer.toString(getEvasion(speed.getValue())));
    }

    private int getEvasion(double statValue) {
        return (int) (statValue / 5);
    }

    private void updateContinueButton() {
        if (combatStatPoints == 0)
            bContinue.setDisable(false);
        else
            bContinue.setDisable(true);
    }
}
