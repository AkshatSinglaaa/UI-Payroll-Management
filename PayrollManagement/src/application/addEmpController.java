package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class addEmpController {

	private Stage stage;
	private Scene scene;
	
	@FXML
	private TextField addEmpId;
	
	@FXML
	private TextField empFirstname;
	
	@FXML
	private TextField empLastname;
	
	@FXML
	private TextField empGender;
	
	@FXML
	private TextField empPhone;
	
	@FXML
	private TextField empEmail;
	
	@FXML
	private TextField empAddress;
	
	@FXML
	private TextField empPostalcode;
	
	@FXML
	private TextField empMartialStat;
	
	@FXML
	private TextField empDept;
	
	@FXML
	private TextField empPosition;
	
	public void gotoEmpTable(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("employee.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	PreparedStatement prp;
	
	public void insert(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {

		// SOmethigns will be done to add the data to the database.
		String eeid = addEmpId.getText();
		String efname = empFirstname.getText();
		String elname = empLastname.getText();
		String egender = empGender.getText();
		String ephone = empPhone.getText();
		String eemail = empEmail.getText();
		String eaddress = empAddress.getText();
		String epostal = empPostalcode.getText();
		String emarital = empMartialStat.getText();
		String edept = empDept.getText();
		String epos = empPosition.getText();
		
		String addEmployee = "insert into employee (empid , fname , lname ,gender, phoneno, email, street_address, postalcode, marital_status, positiontitle, dept) "
							+ " values (" + eeid + "," + efname + "," + elname + "," + egender + "," + ephone + "," + eemail 
										 + "," + eaddress + "," + epostal + "," + emarital + "," + epos + "," + edept +");";
		String addEmployeetry = "insert into employee (empid , fname , lname ,gender, phoneno, email, street_address, postalcode, marital_status, positiontitle, deptid) values (?,?,?,?,?,?,?,?,?,?,?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		sqlConnection connectNow = new sqlConnection();
		Connection connectDB = connectNow.getConnection();
		
		prp = connectDB.prepareStatement(addEmployeetry);
		prp.setString(1, eeid);
		prp.setString(2, efname);
		prp.setString(3, elname);
		prp.setString(4, egender);
		prp.setString(5, ephone);
		prp.setString(6, eemail);
		prp.setString(7, eaddress);
		prp.setString(8, epostal);
		prp.setString(9, emarital);
		prp.setString(11, edept);
		prp.setString(10, epos);
		int rows = prp.executeUpdate();
		
		if(rows == 1) {
			JOptionPane.showMessageDialog(null, "Record Addede");
		}else {
			JOptionPane.showMessageDialog(null, "Record Failed");
		}
		
		connectDB.close();
		
		Parent root = FXMLLoader.load(getClass().getResource("employee.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
