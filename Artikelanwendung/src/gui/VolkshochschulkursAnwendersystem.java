package gui;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Volkshochschulkurs;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;
public class VolkshochschulkursAnwendersystem {
	
	 //---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblKursname 				= new Label("Kursname:");
    private Label lblKursbeitrag   		 	= new Label("Kursbeitrag:");
    private Label lblWochentag  	 		= new Label("Wochentag:");
    private Label lblStartuhrzeit   		= new Label("Startuhrzeit:");
    private Label lblVorkenntnisse  		= new Label("Vorkenntnisse:");
    private TextField txtKursname 	 		= new TextField();
    private TextField txtKursbeitrag		= new TextField();
    private TextField txtWochentag			= new TextField();
    private TextField txtStartuhrzeit		= new TextField();
    private TextField txtVorkenntnisse	 	= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
    //-------Ende Attribute der grafischen Oberflaeche-------
    
 // speichert temporaer ein Objekt vom Typ Volkshochschule
    
    private Volkshochschulkurs volkshochschulkurs;
    
    public VolkshochschulkursAnwendersystem(Stage primaryStage){
    	Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Stadtfuehrungen");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
    }
    
    
    private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblKursname.setLayoutX(20);
    	lblKursname.setLayoutY(90);
    	lblKursbeitrag.setLayoutX(20);
    	lblKursbeitrag.setLayoutY(130);
    	lblWochentag.setLayoutX(20);
    	lblWochentag.setLayoutY(170);
    	lblStartuhrzeit.setLayoutX(20);
    	lblStartuhrzeit.setLayoutY(210);
    	lblVorkenntnisse.setLayoutX(20);
    	lblVorkenntnisse.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblKursname, lblKursbeitrag, lblWochentag,
       		lblStartuhrzeit, lblVorkenntnisse);
    
    	// Textfelder
     	txtKursname.setLayoutX(170);
    	txtKursname.setLayoutY(90);
    	txtKursname.setPrefWidth(200);
    	txtKursbeitrag.setLayoutX(170);
    	txtKursbeitrag.setLayoutY(130);
    	txtKursbeitrag.setPrefWidth(200);
    	txtWochentag.setLayoutX(170);
    	txtWochentag.setLayoutY(170);
    	txtWochentag.setPrefWidth(200);
      	txtStartuhrzeit.setLayoutX(170);
    	txtStartuhrzeit.setLayoutY(210);
    	txtStartuhrzeit.setPrefWidth(200);
    	txtVorkenntnisse.setLayoutX(170);
    	txtVorkenntnisse.setLayoutY(250);
    	txtVorkenntnisse.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtKursname, txtKursbeitrag, txtWochentag,
     		txtStartuhrzeit, txtVorkenntnisse);
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
    
    void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        	   nehmeVolkshochschuleAuf();
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            zeigeVolkshochschuleAn();
	        } 
   	    });
	    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	       	 	leseAusDatei("csv");
	    	}
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		     	leseAusDatei("txt");
		    }
    	});
	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				schreibeVolkshochschuleInCsvDatei();
			}	
	    });
    }
    
    private void nehmeVolkshochschuleAuf(){
    	try{ 
    		this.volkshochschulkurs = new Volkshochschulkurs(
    			txtKursname.getText(), 
   	            Integer.parseInt(txtKursbeitrag.getText()),
   	            txtWochentag.getText(),
   	            Float.parseFloat(txtStartuhrzeit.getText()),
    		    txtVorkenntnisse.getText().split(";"));
    		zeigeInformationsfensterAn("Die Volkshochschule wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
    private void zeigeVolkshochschuleAn(){
    	if(this.volkshochschulkurs != null){
    		txtAnzeige.setText(
    			this.volkshochschulkurs.gibVolkshochschuleZurueck(' '));
    	}
    	else{
    		zeigeInformationsfensterAn("Bisher wurde keine Stadtfuehrung aufgenommen!");
    	}
    }  
    
    private void leseAusDatei(String typ){
    	try {
      		if("csv".equals(typ)){
      			BufferedReader ein = new BufferedReader(new FileReader("Stadtfuehrung.csv"));
      			String[] zeile = ein.readLine().split(";");
      			this.volkshochschulkurs = new Volkshochschulkurs(zeile[0], 
      				Integer.parseInt(zeile[1]), 
      				zeile[2], 
      				Float.parseFloat(zeile[3]), 
      				zeile[4].split("_"));
      				ein.close();
      	  			zeigeInformationsfensterAn(
      	  	   			"Das Stadtfuehrung wurde gelesen!");
      		}
       		else{
	   			zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
		
	private void schreibeVolkshochschuleInCsvDatei() {
		try {
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("StadtfuehrungenAusgabe.csv", true));
			aus.write(volkshochschulkurs.gibVolkshochschuleZurueck(';'));
			aus.close();
   			zeigeInformationsfensterAn(
	   			"Die Volkshochschule wurden gespeichert!");
		}	
		catch(IOException exc){
			zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}

    private void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
    		"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
    void zeigeFehlermeldungsfensterAn(String meldung){
       	new MeldungsfensterAnzeiger(AlertType.ERROR,
        	"Fehler", meldung).zeigeMeldungsfensterAn();
    }

}
    


