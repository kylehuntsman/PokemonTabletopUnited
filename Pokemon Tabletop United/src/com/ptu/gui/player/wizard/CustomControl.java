package com.ptu.gui.player.wizard;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class CustomControl extends Region {
	
	private final String resourcePath = "%s.fxml";
	
	@FXML private TextField textField;

    public CustomControl() {
        this.loadFXML();
    }
    
    private void loadFXML() {
    	FXMLLoader loader = new FXMLLoader();
    	
    	loader.setController(this);
    	loader.setLocation(this.getViewURL());

        try {
            Node root = (Node) loader.load();
            setMaxSize(root);
            this.getChildren().add(root);
        } catch (IOException exception) {
            Logger.getLogger(CustomControl.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
    
    private String getViewPath() {
    	return String.format(resourcePath,  this.getClass().getSimpleName());
    }
    
    private URL getViewURL() {
    	return this.getClass().getResource(this.getViewPath());
    }
    
    
    @Override
	protected void layoutChildren() {
		for(Node node : getChildren()) {
			layoutInArea(node, 0, 0, getWidth(), getHeight(), 0, HPos.LEFT, VPos.TOP);
		}
	}
    
    private void setMaxSize(Node node) {
    	if (node != null && node instanceof Region) {
            Region region = (Region) node;
            region.setMaxWidth(Double.MAX_VALUE);
            region.setMaxHeight(Double.MAX_VALUE);
        }
    }
}
