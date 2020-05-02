package com.enbw.tictactoe;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Effect;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class MainController  implements Initializable {

    @FXML
    private GridPane gamefield;
    @FXML
    private Label overviewLabel;
    @FXML
    private Node overviewPane;

    private Spielklasse spielklasse;
    
	public void initialize(URL arg0, ResourceBundle arg1) {
		spielklasse = new Spielklasse(this);
		setButtons();
	}
    
	private void setButtons() {
		for(int x=0; x<3; x++)
			for(int y =0; y<3; y++) {
				try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gameButtonGUI.fxml"));
				Button filmCard;
				filmCard = fxmlLoader.load();
				GameButtonController gameButtonController  = fxmlLoader.getController();
				gameButtonController.setID(x, y);
				gameButtonController.setSpielklasse(spielklasse);
				gamefield.add(filmCard,x,y);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
	}
	
	public void endSpiel(boolean sieg) {
		if(sieg)
			overviewLabel.setText("Sieg");
		else 
			overviewLabel.setText("Unentscheiden");
		overviewPane.toFront();
		gamefield.setEffect(new BoxBlur());
		
	}
	
    
}
