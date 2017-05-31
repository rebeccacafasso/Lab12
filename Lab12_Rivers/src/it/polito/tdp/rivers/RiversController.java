package it.polito.tdp.rivers;



/**
 * Sample Skeleton for 'Rivers.fxml' Controller Class
 */


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.rivers.model.Evento;
import it.polito.tdp.rivers.model.Flow;
import it.polito.tdp.rivers.model.River;
import it.polito.tdp.rivers.model.Simulator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RiversController {
	Simulator simulator = new Simulator();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxRiver"
    private ComboBox<River> boxRiver; // Value injected by FXMLLoader

    @FXML // fx:id="txtStartDate"
    private TextField txtStartDate; // Value injected by FXMLLoader

    @FXML // fx:id="txtEndDate"
    private TextField txtEndDate; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumMeasurements"
    private TextField txtNumMeasurements; // Value injected by FXMLLoader

    @FXML // fx:id="txtFMed"
    private TextField txtFMed; // Value injected by FXMLLoader

    @FXML // fx:id="txtK"
    private TextField txtK; // Value injected by FXMLLoader

    @FXML // fx:id="btnSimula"
    private Button btnSimula; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    
    @FXML
    void doPopola(ActionEvent event) {
    	
    	
    	River river = boxRiver.getValue();
    	simulator.misurazionePerFiume(river);
    	txtStartDate.setText(river.getPrima().getData()+"\n");
    	txtEndDate.setText(river.getUltima().getData()+"\n");
    	txtNumMeasurements.setText(river.getNumeroMisurazioni()+"\n");
    	txtFMed.setText(river.getPortataMedio()+"\n");

    }

    @FXML
    void doSimula(ActionEvent event) {
    	
    	River river = boxRiver.getValue();
    	
    	List <Flow> lista = new ArrayList <Flow>(river.getMisurazioni().values());
    	for (Flow f : lista){
    		simulator.addEvento(f);
    	}
    	
    	String numero = txtFMed.getText();
    	double f_med = Double.parseDouble(numero);
    	
    	String kappa = txtK.getText();
    	double k = Double.parseDouble(kappa);
    	
    	String num = txtNumMeasurements.getText();
    	int num_simulazioni = Integer.parseInt(num);
    
    	simulator.setParametri(f_med, k, num_simulazioni);
    		
    	simulator.run();
    	
    	txtResult.appendText("Giorni in cui non viene erogato il servizio: "+simulator.getGiorniInsoddisfatti()+"\n"+
    	"Capacità media "+simulator.getOccupazioneMedia()+"\n");

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxRiver != null : "fx:id=\"boxRiver\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtStartDate != null : "fx:id=\"txtStartDate\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtEndDate != null : "fx:id=\"txtEndDate\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtNumMeasurements != null : "fx:id=\"txtNumMeasurements\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtFMed != null : "fx:id=\"txtFMed\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtK != null : "fx:id=\"txtK\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Rivers.fxml'.";

    }

	public void setModel(Simulator m) {
		this.simulator = m;
		boxRiver.getItems().addAll(simulator.getFiumi());
		
	}
}

