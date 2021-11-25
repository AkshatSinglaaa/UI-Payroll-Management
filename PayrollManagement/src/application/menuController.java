package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class menuController {

	private Stage stage;
	private Scene scene;
	
	public void gotoEmp(ActionEvent event) throws IOException, SQLException {
		
		//Read and populate the table in the Employee Page
		sqlConnection connectNow = new sqlConnection();
		Connection connectDB = connectNow.getConnection();
		
		ResultSet ResultSet = connectDB.createStatement().executeQuery("select * from employee");
		
		Parent root = FXMLLoader.load(getClass().getResource("employee.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void gotoDep(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("department.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void gotoSal(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("salary.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void gotoLeave(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("leave.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void gotoPayroll(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("payroll.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
