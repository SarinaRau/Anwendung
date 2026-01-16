package main;



import gui.VolkshochschulkursAnwendersystem;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new VolkshochschulkursAnwendersystem(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
