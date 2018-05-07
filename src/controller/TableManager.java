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
	/**
	 * The name is self-explanatory. This class handles any and all things related to the TableView.
	 */
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
	
	public void init(StaffWindowController mainController)
	{
		this.mainController = mainController;
	}

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
		if((event.getClickCount() == 2 ) && (event.getSource() instanceof TableView) )
		{
			EmployeeData data = tableWindow.getSelectionModel().getSelectedItem();
			System.out.println("Mouse Clicked");
			System.out.println(event.getSource());
			if(data != null) {
				mainController.displayData(data);
			}
		}
	}
	
}
