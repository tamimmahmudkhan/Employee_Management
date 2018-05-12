package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.staff.EmployeeData;
import model.staff.StaffManager;

import java.io.IOException;

public class RegistrationPanelController 
{
	@FXML
	private TextField fNameText;
	@FXML 
	private TextField lNameText;
	@FXML
	private DatePicker dobSelect;
	@FXML
	private TextField emailText;
	@FXML
	private PasswordField passText;
	@FXML
	private Label successLabel;
	
	private StaffManager manager = new StaffManager();
	
	@FXML
	private void newAccount(ActionEvent event)
	{
		EmployeeData data = new EmployeeData.Builder()
				.fname(fNameText.getText())
				.lname(lNameText.getText())
				.dob(dobSelect.getEditor().getText())
				.email(emailText.getText())
				.password(passText.getText())
				.build();
		if (manager.addEmployee(data)) {
			successLabel.setText("New Account Created!");
		}else {
			successLabel.setText("New Account Creation Failed!");
		}
	}
	
	@FXML
	private void previousWindow(ActionEvent event)
	{
		Stage oldStage = (Stage)(((Button)event.getSource()).getScene().getWindow());
		oldStage.close();
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
			
			Scene scene = new Scene(root, 300, 300);
			
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Inventory Login");
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
