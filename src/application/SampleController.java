package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import java.io.IOException; 
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class SampleController {

	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    void initialize() {
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
    
    //ChoiceBoxes

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

    //TextFields
    
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

    //TextAreas
    
    @FXML
    private TextArea txtAreaCustomer;

    @FXML
    private TextArea txtAreaOrder;

    @FXML
    private TextArea txtAreaProduct;

    @FXML
    private TextArea txtAreaView;

    //
    
  //


   


    		
    	
    	
    }
