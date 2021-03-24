package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {

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

    @FXML
    void doClearText(ActionEvent event) {

    }

    @FXML
    void doSpellCheck(ActionEvent event) {

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

    }
}
