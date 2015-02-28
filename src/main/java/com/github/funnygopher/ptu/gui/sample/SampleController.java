package com.github.funnygopher.ptu.gui.sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class SampleController {
	
	public TextField textField1;
	
	public void sayHelloWorld(ActionEvent event) {
		textField1.setText("Hello World!");
	}
}
