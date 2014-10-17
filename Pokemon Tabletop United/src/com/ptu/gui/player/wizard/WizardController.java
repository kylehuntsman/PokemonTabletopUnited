package com.ptu.gui.player.wizard;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TitledPane;

import com.ptu.trainer.Attribute;

public class WizardController implements Initializable {
	
	public Accordion accordian;
	public Button btnStep0;
	public TitledPane paneStep0, paneStep1, paneStep2;
	
	public Label lblBody, lblMind, lblSpirit;
	public Slider body, mind, spirit;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		int bodyValue = (int) body.getValue();
		lblBody.setText(Attribute.valueOf(bodyValue));
	}
	
	public void toStep1(ActionEvent event) {
		accordian.setExpandedPane(paneStep1);
	}
	
	public void toStep2(ActionEvent event) {
		accordian.setExpandedPane(paneStep2);
	}
}
