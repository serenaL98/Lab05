package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Calcola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Calcola calcola;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtRisultatoOk;

    @FXML
    private TextArea txtRisultatoErr;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	
    	txtRisultatoOk.clear();
    	txtRisultatoErr.clear();
    	
    	try {
    	String inserita = txtParola.getText();
    	
    	//in txtRisultatoOk metto gli anagrammi presenti nel dizionario
    	String elencoOk = "";
    	//in txtRisultatoErr metto tutti gli altri casi
    	String elencoErr = "";
    	if(this.calcola.isCorrect(inserita) == true) {

        	List<String> noDopp = this.calcola.soluzioneOk(calcola.anagramma(inserita));
        	
    		for(String s: noDopp) {
    			if(this.calcola.isCorrect(s) == true) {
    				elencoOk += s+"\n";
    			}
    			else
    				elencoErr +=s+"\n";
    		}
    	}
    	
    	txtRisultatoOk.setText(elencoOk);
    	txtRisultatoErr.setText(elencoErr);
    	
    	}catch(RuntimeException e) {
    		txtRisultatoOk.setText("Errore!");
    	}
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtParola.clear();
    	txtRisultatoOk.clear();
    	txtRisultatoErr.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultatoOk != null : "fx:id=\"txtRisultatoOk\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultatoErr != null : "fx:id=\"txtRisultatoErr\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setCalcola(Calcola calcola) {
    	this.calcola = calcola;
    }
}
