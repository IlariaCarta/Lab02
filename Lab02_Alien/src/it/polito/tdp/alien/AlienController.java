package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private AlienDictionary alienDictionary = new AlienDictionary();
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	
    	txtResult.clear();
    	
    	String riga = txtWord.getText().toLowerCase();
    	
    	// controllo se l'input è valido
    	if(riga == null || riga.length()==0) {
    		txtResult.appendText("Inserire una o due parole");
    	}
    	
    	String st[] = riga.split(" ");
    	String alienWord = st[0];
    	
    	if(st.length>2) {
    		txtResult.appendText("Inserire una o due parole");
    	}
    	
    	if(st.length==2) {
    		String translation = st[1];
    		if(!alienWord.matches("[a-zA-Z]*") || !translation.matches("[a-zA-Z]*")) {
        		txtResult.appendText("Inserire solo caratteri alfabetici");
        		return;
        	}
        	
        	alienDictionary.addWord(alienWord, translation);
        	txtResult.setText("La parola: \"" + alienWord + "\", con traduzione: \"" + translation + "\", è stata inserita nel dizionario.");
        }
    	else if(st.length==1) {
    		if(!alienWord.matches("[a-zA-Z]*") ) {
    			txtResult.appendText("Inserire solo caratteri alfabetici");
    			return;
    		}
    		String trad = alienDictionary.translateWord(alienWord);
    		if(trad!= null)
    			txtResult.appendText(trad);
    		else
    			txtResult.appendText("La parola cercata non esiste nel dizionario");
    	}
    }
    	
    
    
    @FXML
    void doReset(ActionEvent event) {
    	
    	txtWord.clear();;
    	txtResult.clear();
    }
    
}
