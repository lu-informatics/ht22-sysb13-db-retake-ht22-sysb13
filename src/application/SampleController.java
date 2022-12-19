package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import application.DataAccessLayer;

public class SampleController {

	@FXML
	private ResourceBundle resources;

	// @FXML
	// private URL location;

	DataAccessLayer dal = new DataAccessLayer();

	// First code that runs when running the application.
	@FXML
	public void initialize() {
	}

	@FXML
	private Button buttonAddOrder;

	@FXML
	private Button buttonConfirmOrder;

	@FXML
	private Button buttonCreateCustomer;

	@FXML
	private Button buttonCreateProduct;

	@FXML
	private Button buttonFindCustomer;

	@FXML
	private Button buttonFindProduct;

	@FXML
	private Button buttonRemoveOrder;

	@FXML
	private Button buttonViewView;

	// ChoiceBoxes

	@FXML
	private ChoiceBox<?> choiceBoxCustomeOrder;

	@FXML
	private ChoiceBox<?> choiceBoxCustomerIDView;

	@FXML
	private ChoiceBox<?> choiceBoxLoyaltyCustomer;

	@FXML
	private ChoiceBox<?> choiceBoxOrderIDView;

	@FXML
	private ChoiceBox<?> choiceBoxProductOrder;

	// TextFields

	@FXML
	private TextField txtAddressCustomer;

	@FXML
	private TextField txtAmountOrder;

	@FXML
	private TextField txtIDCustomer;

	@FXML
	private TextField txtIDPrice;

	@FXML
	private TextField txtIDProduct;

	@FXML
	private TextField txtNameCustomer;

	@FXML
	private TextField txtNameProduct;

	// TextAreas

	@FXML
	private TextArea txtAreaCustomer;

	@FXML
	private TextArea txtAreaOrder;

	@FXML
	private TextArea txtAreaProduct;

	@FXML
	private TextArea txtAreaView;

	//

	// CUSTOMERS
	// Registration of Customer

	public void buttonCreateCustomer(ActionEvent a) {
		Integer customerID = Integer.parseInt(txtIDCustomer.getText());
		String name = txtNameCustomer.getText();
		String address = txtAddressCustomer.getText();
		String loyaltyLevel = choiceBoxLoyaltyCustomer.getValue().toString();

		if (!name.isEmpty() && customerID != null && !address.isEmpty() && !loyaltyLevel.isEmpty()) {
			txtAreaCustomer.clear();
			txtAreaCustomer.appendText("Please make sure to fill in all fields");

		} else {

			try {
				dal.CreateCustomer(customerID, name, address, loyaltyLevel);

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}

	}
	
	// Find Customer by customer ID

	public void buttonFindCustomer(ActionEvent a) {

		int customerID = Integer.parseInt(txtIDCustomer.getText());
		try {
			ResultSet rS = dal.findCustomerByCustomerId(customerID);
			// iterates through the table, if it does not find a customer with the matching
			// ID, it will alert it
			if (!rS.next()) {
				txtAreaCustomer.clear();
				txtAreaCustomer.setText("Customer with this ID does not exist");
			} else {
				txtAreaCustomer.clear();
				txtAreaCustomer.setText("Customer ID: " + rS.getString("CustomerID") + "\nCustomer Name"
						+ rS.getString("Name") + "\nCustomer Address:" + rS.getString("Address") + ""
						+ "\nLoyalty Level" + rS.getString("LoyaltyLevel"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


}