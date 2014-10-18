package com.ptu.gui.player.wizard;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane page = (AnchorPane) FXMLLoader.load(Main.class.getResource("CharacterCreationWizard.fxml"));
	        Scene scene = new Scene(page);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Character Creation Wizard");
	        primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
