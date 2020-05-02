package com.enbw.tictactoe;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class GameButtonController implements Initializable {
	@FXML
    private Button button;
	
	private int x,y;
	private Spielklasse spielklasse;

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

	public void setID(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	
	public void setSpielklasse(Spielklasse spielklasse) {
		this.spielklasse = spielklasse;
	}
	
	@FXML
    void onClicked(ActionEvent event) {
		String spieler = spielklasse.clicked(x, y);
		button.setText(spieler);
    }
	
	

	
	
	
}
