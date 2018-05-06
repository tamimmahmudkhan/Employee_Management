 package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.staff.EmployeeData;

import java.io.IOException;

public class EmployeeDisplayController 
{
	@FXML
	private Label nameLabel;
	@FXML
	private Label dobLabel;
	@FXML
	private Label positionLabel;
	@FXML
	private Label workDayLabel;
	@FXML
	private Label absentDayLabel;
	@FXML
	private VBox employeeDisplay;

	private EditMenuController editMenuController = new EditMenuController();

	
	@FXML
	private StaffWindowController mainController;
	
	public void init(StaffWindowController controller) 
	{
		mainController= controller;
	}

	// Event Listener on Button[#editButton].onAction
	@FXML
	public void editMenu(ActionEvent event) 
	{
		HBox parent = (HBox) employeeDisplay.getParent();
		parent.getChildren().remove(employeeDisplay);
		parent.getChildren().add(0, displayEditor());
	}
	
	private Node displayEditor()
	{
		try {
			FXMLLoader loader = new FXMLLoader();
			editMenuController.injectMainController(mainController);
			loader.setController(editMenuController);
			return loader.load(getClass().getResource("/view/EditMenu.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void setLabels(EmployeeData data) 
	{
		nameLabel.setText("Name: " + data.getFname() + " " + data.getLname());
		dobLabel.setText("Date of Birth: " + data.getDob());
		positionLabel.setText("Position: " + data.getPosition());
		workDayLabel.setText("Worked Days: " + data.getWorkDays());
		absentDayLabel.setText("Absent Days: " + data.getAbsentDays());
	}
}
