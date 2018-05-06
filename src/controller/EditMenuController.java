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
	private VBox parentNode;
	
	private StaffManager manager = new StaffManager();
	
	@FXML
	private StaffWindowController staffController;
	
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
		HBox parent = (HBox) parentNode.getParent();
		
		FXMLLoader loader = new FXMLLoader();
		try {
			Node newNode = loader.load(getClass().getResource("/view/EmployeeDisplay.fxml"));
			parent.getChildren().remove(0);
			parent.getChildren().add(0, newNode);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void populateFields(EmployeeData data) 
	{
		fNameText.setText(data.getFname());
		lNameText.setText(data.getLname());
		dobSelect.getEditor().setText(data.getDob());
	}
	
	@FXML
	public void editEmployee() 
	{
		System.out.println(mainController);
//		EmployeeData newData = new EmployeeData(fNameText.getText(), 
//				lNameText.getText(),
//				dobSelect.getEditor().getText(),
//				positionBox.getSelectionModel().getSelectedItem().toString(),
//				3, 4, user, pass);
	}
}
