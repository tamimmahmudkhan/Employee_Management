package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.staff.EmployeeData;
import model.staff.Position;
import model.staff.StaffManager;

import java.io.IOException;
 

public class EditMenuController
{
	/**
	 * Controller for the EditMenu.fxml. Handles editing of employee in database through the UI.
	 */
	@FXML
	private TextField fNameText;
	@FXML 
	private TextField lNameText;
	@FXML
	private DatePicker dobSelect;
	@FXML
	private VBox editMenu;
	
	private StaffManager manager = new StaffManager();
	
	@FXML
	private ComboBox<Position> positionBox;

	private StaffWindowController mainController;

	public void injectMainController(StaffWindowController mainController)
	{
		this.mainController = mainController;
	}
	
	@FXML
	private void previousMenu()
	{
		HBox parent = (HBox) editMenu.getParent();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/EmployeeDisplay.fxml"));
		try {
			Node newNode = loader.load();
			mainController.setEmployeeDisplayController(loader.getController());
			parent.getChildren().remove(0);
			parent.getChildren().add(0, newNode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void populateFields(EmployeeData data) 
	{
		System.out.println("Should Populate Fields man");
		fNameText.setText(data.getFname());
		lNameText.setText(data.getLname());
		dobSelect.getEditor().setText(data.getDob());
	}
	
	@FXML
	public void editEmployee() 
	{
		System.out.println(mainController);

	}
}
