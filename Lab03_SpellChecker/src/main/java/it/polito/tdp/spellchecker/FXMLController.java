package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;

public class FXMLController {
	
	private Dictionary dictionary;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> boxLingue;

    @FXML
    private TextArea txtFrase;

    @FXML
    private Button btnControllo;

    @FXML
    private TextArea txtResult;

    @FXML
    private Label txtErrori;

    @FXML
    private Button btnClear;

    @FXML
    private Label txtTempo;
    
    private boolean inglese;
    private boolean italiano;
    
    @FXML
    void doClearText(ActionEvent event) {
    	
    	txtResult.clear();
    	txtFrase.clear();
    	txtErrori.setText("");
    	txtTempo.setText("");

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	int errori=0;
    	
    	if (boxLingue.getValue()==null) {
    		txtResult.setText("Inserire la lingua.\n");
    		return;
    	}
    	
    	txtResult.clear();
    	
    	if (!italiano && boxLingue.getValue().equals("Italian")) {
    		dictionary.loadDictionary(boxLingue.getValue());
    		italiano = true;
    	}
    	else if (!inglese && boxLingue.getValue().equals("English")) {
    		dictionary.loadDictionary(boxLingue.getValue());
    		inglese = true;
    	}
    	
    	String testo = txtFrase.getText();
    	testo = testo.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"\\?]","");
    	testo = testo.toLowerCase();
    	String[] analisi = testo.split(" ");
    	
    	ArrayList<String> listaAnalisi = new ArrayList<String>();
    	
    	for (String s : analisi) {
    		listaAnalisi.add(s);
    	}
    	
    	long startTime = System.nanoTime();
    	List<RichWord> risultato = dictionary.spellCheckTestLinear(listaAnalisi);
    	long endTime = System.nanoTime();
    	
    	txtTempo.setText("Spell check completato in " + (endTime - startTime) + " nanosecondi");
    	
    	for (RichWord r : risultato) {
    		if (!r.isCorretta()) {
    			txtResult.appendText(r.getParola() + "\n");
    			errori++;
    		}
    	}
    	
    	txtErrori.setText("Il testo contiene " + errori + " errori");
    	
    }

    @FXML
    void initialize() {
        assert boxLingue != null : "fx:id=\"boxLingue\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtFrase != null : "fx:id=\"txtFrase\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnControllo != null : "fx:id=\"btnControllo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrori != null : "fx:id=\"txtErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'Scene.fxml'.";
        
        this.boxLingue.getItems().add("Italian");
        this.boxLingue.getItems().add("English");

        this.inglese = false;
        this.italiano = false;
    }
    
    public void setModel(Dictionary model) {
    	this.dictionary = model;
    }
}
