package com.ptu.gui.player.wizard;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UpDownBox extends CustomControl {
	
	private int value = 0;
	private int minValue = Integer.MIN_VALUE;
	private int maxValue = Integer.MAX_VALUE;
	private int defaultValue = 0;
	private int delta = 1;
	
	@FXML
	private TextField textField;
	
	@FXML
	private Button upButton, downButton;

	public UpDownBox() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"UpDownBox.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
			fxmlLoader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		setText(Integer.toString(value));
	}
	
	@FXML
	protected void decrement() {
		if(value - delta >= minValue) {
			value -= delta;
			upButton.setDisable(false);
		}
		
		if(value - delta < minValue)
			downButton.setDisable(true);
		
		setText(Integer.toString(value));
	}
	
	public int getDefaultValue() {
		return defaultValue;
	}
	
	public int getDelta() {
		return delta;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public int getMinValue() {
		return minValue;
	}

	public int getValue() {
		return value;
	}

	@FXML
	protected void increment() {
		if(value + delta <= maxValue) {
			value += delta;
			downButton.setDisable(false);
		}
		
		if(value + delta > maxValue)
			upButton.setDisable(true);
		
		setText(Integer.toString(value));
	}

	public void setDefaultValue(int defaultValue) {
		this.defaultValue = defaultValue;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}
	
	private void setText(String text) {
		textField.setText(text);
	}
}
