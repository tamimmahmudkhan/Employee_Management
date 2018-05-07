package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.staff.Position;
import model.staff.StaffManager;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class LoginController implements Initializable 
{
	/**
	 * Handles Login to application and addition of new employee.
	 */
	
	@FXML
	private TextField emailText;
	
	@FXML
	private PasswordField passText;
	
	
	@FXML
	private ComboBox<Position> positionBox;
	@FXML
	private Label promptLabel;
	
	private StaffManager manager = new StaffManager();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		ObservableList<Position> list = FXCollections.observableArrayList();
		list.addAll(Position.Admin, Position.Employee);
		positionBox.setItems(list);
	}
	
	@FXML
	private void login(ActionEvent event) throws SQLException
	{
		Window window = ((Button)event.getSource()).getScene().getWindow();

		if (positionBox.getSelectionModel().getSelectedItem() == Position.Admin) {
			if (manager.isEmployee(emailText.getText(), passText.getText())) 
			{
				launchWindow((Stage)window,	"/view/StaffWindow.fxml");
			}else {
				promptLabel.setText("Unauthorized User: Admin");
			}
		}else {
			if (manager.isEmployee(emailText.getText(), passText.getText())) 
			{
				launchWindow((Stage)window, "/view/StaffWindow.fxml");
			}else {
				promptLabel.setText("Unauthorized User: Employee");
			}
		}
	}
	
	@FXML
	private void newAccount(ActionEvent event)
	{
		Window window = ((Button)event.getSource()).getScene().getWindow();
		launchWindow((Stage) window, "/view/RegistrationPanel.fxml");
	}

	private void launchWindow(Stage stage, String fxml) 
	{
		stage.close();
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource(fxml));
			Scene scene = new Scene(root, 1280, 720);

			Stage newStage = new Stage();

			newStage.setTitle("Inventory Management");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.setMaximized(true);

			newStage.show();
		} catch (IOException e) {
			// DONT READ THIS
			e.printStackTrace();
		}
	}
}
