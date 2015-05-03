package com.github.funnygopher.ptu.trainercreator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TrainerCreatorMain extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Trainer Creator");
        primaryStage.setScene(createScene(loadMainPane()));
        primaryStage.show();
	}

    private AnchorPane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        AnchorPane mainPane = loader.load(getClass().getResourceAsStream(StepNavigator.MAIN));
        TrainerCreator2Controller controller = loader.getController();
        StepNavigator.setController(controller);
        StepNavigator.loadStep(StepNavigator.STEP1);

        return mainPane;
    }

    private Scene createScene(AnchorPane mainPane) {
        Scene scene = new Scene(mainPane);
        return scene;
    }
}
