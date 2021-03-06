package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane mainLayout;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage  = primaryStage;
		this.primaryStage.setTitle("Payroll Management App");
		
		showWelcome();
	}
	
	public void showWelcome() throws IOException {
		FXMLLoader loader  =new FXMLLoader();
		loader.setLocation(Main.class.getResource("welcome.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
		
	public static void main(String[] args) {
		
		launch(args);
	}
}
