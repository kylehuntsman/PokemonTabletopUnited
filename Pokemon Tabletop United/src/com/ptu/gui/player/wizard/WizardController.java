package com.ptu.gui.player.wizard;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;

import com.ptu.trainer.Attribute;

public class WizardController implements Initializable {
	
	public Accordion accordian;
	public Button btnStep0, btnStep1, btnStep2;
	public TitledPane paneStep0, paneStep1, paneStep2, paneStep3;
	public TitledPane currentPane;
	
	public Label lblBody, lblMind, lblSpirit;
	public Slider body, mind, spirit;
	public TextField txtPoints;
	public int attributePoints;
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		currentPane = paneStep0;
		accordian.setExpandedPane(paneStep0);
		
		updateBodyLabel();
		updateMindLabel();
		updateSpiritLabel();
		updateAttributePoints();
		updatePointsLabel();
		
		body.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov,
					Number old_val, Number new_val) {
				
				updateBodyLabel();
				updateAttributePoints();
				
				if(attributePoints < 0) {
					body.setValue(new_val.intValue() + attributePoints);
					updateAttributePoints();
				}
				
				updatePointsLabel();
			}
		});
		
		mind.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov,
					Number old_val, Number new_val) {
				
				updateMindLabel();
				updateAttributePoints();
				
				if(attributePoints < 0) {
					mind.setValue(new_val.intValue() + attributePoints);
					updateAttributePoints();
				}
				
				updatePointsLabel();
			}
		});
		
		spirit.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov,
					Number old_val, Number new_val) {
				
				updateSpiritLabel();
				updateAttributePoints();
				
				if(attributePoints < 0) {
					spirit.setValue(new_val.intValue() + attributePoints);
					updateAttributePoints();
				}
				
				updatePointsLabel();
			}
		});
	}
	
	private void updateAttributePoints() {
		attributePoints = 5 - (int) body.getValue() - (int) mind.getValue() - (int) spirit.getValue();
		updateBtnStep2();
	}
	
	private void updatePointsLabel() {
		txtPoints.setText(Integer.toString(attributePoints));
	}
	
	private void updateBodyLabel() {
		int bodyValue = (int) body.getValue();
		lblBody.setText(Attribute.getString(bodyValue));
	}
	
	private void updateMindLabel() {
		int mindValue = (int) mind.getValue();
		lblMind.setText(Attribute.getString(mindValue));
	}
	
	private void updateSpiritLabel() {
		int spiritValue = (int) spirit.getValue();
		lblSpirit.setText(Attribute.getString(spiritValue));
	}
	
	private void goToPane(TitledPane pane) {
		pane.setDisable(false);
		accordian.setExpandedPane(pane);
		currentPane.setDisable(true);
		currentPane = pane;
	}
	
	public void toStep1(ActionEvent event) {
		goToPane(paneStep1);
		
	}
	
	public void toStep2(ActionEvent event) {
		goToPane(paneStep2);
	}
	
	public void toStep3(ActionEvent event) {
		goToPane(paneStep3);
	}
	
	private void updateBtnStep2() {
		if(attributePoints == 0)
			btnStep2.setDisable(false);
		else
			btnStep2.setDisable(true);
	}
}
