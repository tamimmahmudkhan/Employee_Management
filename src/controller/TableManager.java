package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.staff.EmployeeData;
import model.staff.StaffManager;

import java.net.URL;
import java.util.ResourceBundle;

public class TableManager implements Initializable
{
	
	@FXML
	private TableView<EmployeeData> tableWindow;
	
	@FXML
	private TableColumn<EmployeeData, String> firstNameCol;
	@FXML
	private TableColumn<EmployeeData, String> lastNameCol;
	@FXML
	private TableColumn<EmployeeData, String> positionCol;
	@FXML
	private TableColumn<EmployeeData, String> workDayCol;
	@FXML
	private TableColumn<EmployeeData, String> absentDayCol;
	@FXML
	private TableColumn<EmployeeData, String> dobCol;

	private StaffManager manager = new StaffManager();

	@FXML
	private StaffWindowController mainController;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("fname"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lname"));
		positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));
		dobCol.setCellValueFactory(new PropertyValueFactory<>("dob"));
		workDayCol.setCellValueFactory(new PropertyValueFactory<>("workDays"));
		absentDayCol.setCellValueFactory(new PropertyValueFactory<>("absentDays"));
		
		loadData();
	}

	private void loadData()
	{
		tableWindow.setItems(null);
		tableWindow.setItems(manager.getData());
	}

	@FXML
	private void onMouseClick(MouseEvent event)
	{
		if (event.getSource() instanceof EmployeeData)
		{
			EmployeeData data = (EmployeeData)event.getSource();
			mainController.setEmployeeData(data);
			System.out.println(data.toString());
		}
	}
	
}