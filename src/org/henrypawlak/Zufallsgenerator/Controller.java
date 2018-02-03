package org.henrypawlak.Zufallsgenerator;

import java.net.URL;
import java.util.ResourceBundle;

import org.henrypawlak.Zufallsgenerator.Zentrale.Zentrale;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

public class Controller implements Initializable{
	Zentrale z = new Zentrale(this);
	Type type = null;
	@FXML
	RadioButton rbZahl;
	@FXML
	RadioButton rbBuchstabe;
	@FXML
	RadioButton rbJN;
	@FXML
	Label lbOut;
	@FXML
	Button btGenerieren;
	@FXML
	TextField tfInput;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		rbZahl.setSelected(true);
		type = Type.NUMBER;
				rbZahl.setOnAction(e->{
					type = Type.NUMBER;
					rbJN.setSelected(false);
					rbBuchstabe.setSelected(false);
				});
				rbBuchstabe.setOnAction(e->{
					type = Type.LETTER;
					rbBuchstabe.setSelected(false);
					rbZahl.setSelected(false);
				});
				rbJN.setOnAction(e->{
					type = Type.BOOL;
					rbBuchstabe.setSelected(false);
					rbZahl.setSelected(false);
				});
				btGenerieren.setOnAction(e->{
					switch (type) {
					case NUMBER:
						try {
							int bound = Integer.parseInt(tfInput.getText());
							writeMsg(""+z.generateRandomNumber(bound));
						}catch(NumberFormatException ex) {
							tfInput.requestFocus();
						}
						break;
						
					case LETTER:
						writeMsg(""+z.generateRandomChar());
						break;
					case BOOL:
						if(z.generateRandomBool()) {
							writeMsg("Ja");
						}else {
							writeMsg("Nein");
						}
						break;
					case UNDEFINED:
						writeMsg("No type selected!");
						break;
					}
				});
	}
	
	public void writeMsg(String text) {
		lbOut.setText(text);
	}
	
	
	
}
