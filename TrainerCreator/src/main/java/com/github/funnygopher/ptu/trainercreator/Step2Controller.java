package com.github.funnygopher.ptu.trainercreator;

import com.github.funnygopher.ptu.Skill;
import com.github.funnygopher.ptu.trainer.Background;
import com.github.funnygopher.ptu.trainer.Trainer;
import com.github.funnygopher.ptu.trainer.TrainerBuilder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Step2Controller implements Initializable {

    private TrainerBuilder trainerBuilder;

    @FXML
    TextField txtBackgroundName;
    ChoiceBox<Skill> ddPathetic1, ddPathetic2, ddPathetic3;
    ChoiceBox<Skill> ddAdept, ddNovice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TrainerCreatorController controller = StepNavigator.getController();
        controller.bBackground.setDisable(false);

        trainerBuilder = controller.getTrainerBuilder();
        txtBackgroundName.setText(trainerBuilder.getBackground().getName());
    }

    @FXML
    public void onContinueClick() {
        List<Skill> patheticSkills = new ArrayList<Skill>(
                Arrays.asList(
                        //ddPathetic1.getValue(), ddPathetic2.getValue(), ddPathetic3.getValue()
                )
        );
        Background background = new Background(txtBackgroundName.getText(), "", patheticSkills, Skill.ADEPT, Skill.NOVICE);
        trainerBuilder.background(background);
        StepNavigator.loadStep(StepNavigator.STEP5);
    }
}
