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
	/**
	 * Controller strictly in charge of displaying full employee information. Responsible for launching EditMenu.
	 */
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

	private EditMenuController editMenuController;

	
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
		if (editMenuController != null)
		{
			mainController.setEditMenu(editMenuController);
		}
	}
	
	private Node displayEditor()
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/EditMenu.fxml"));

		Node pane = null;
		try {
			pane = loader.load();
			editMenuController = loader.getController();
		} catch (IOException e) {
			e.printStackTrace();
		}
		editMenuController.injectMainController(mainController);
		System.out.println(editMenuController);
		return pane;
	}
	
	public void setLabels(EmployeeData data) 
	{
		nameLabel.setText("Name: " + data.getFname() + " " + data.getLname());
		dobLabel.setText("Date of Birth: " + data.getDob());
		positionLabel.setText("Position: " + data.getPosition());
		workDayLabel.setText("Worked Days: " + data.getWorkDays());
		absentDayLabel.setText("Absent Days: " + data.getAbsentDays());
	}

	public EditMenuController getEditMenuController()
	{
		return editMenuController;
	}
}
