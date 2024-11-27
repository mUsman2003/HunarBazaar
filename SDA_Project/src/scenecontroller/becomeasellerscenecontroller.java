package scenecontroller;

import controllers.AccountController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class becomeasellerscenecontroller {

	
	public int CategoryID;
	 @FXML
	    private MenuButton category;

	    @FXML
	    private TextField cnic;

	    @FXML
	    private Button goback;

	    @FXML
	    private Button signup;

    @FXML
    void gotosignin(ActionEvent event) {

    }

    @FXML
    void gotosignin2(ActionEvent event) {

    }

    @FXML
    void printlastname(ActionEvent event) {

    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    void gotosellerdash(ActionEvent event) {
    	
    	String CNIC = cnic.getText();
    	 // Validate password length
        if (CNIC.length() < 13) {
            showAlert("Validation Error", "CNIC can't be less than 13 digits.");
            return ;
        }
        boolean SignUpSucess= AccountController.SellerSignUp(CNIC,CategoryID);
    	if(SignUpSucess)
    	{
    		
    		try {
    			Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellerhomescene.fxml"));
    			Stage stage = (Stage) goback.getScene().getWindow();
    			Scene scene = new Scene(scene2Root);
    			stage.setScene(scene);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    @FXML
    void gotoback(ActionEvent event) {
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyerhomescene.fxml"));
            Stage stage = (Stage) goback.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void menuclicked(ActionEvent event) {
        MenuItem clickedItem = (MenuItem) event.getSource();
        String categoryName = clickedItem.getText();
        int categoryID = 0;

        // Map category names to IDs
        if (categoryName.equals("Appliance Technician")) {
            categoryID = 1;
        } else if (categoryName.equals("Blacksmith")) {
            categoryID = 2;
        } else if (categoryName.equals("Carpenter")) {
            categoryID = 3;
        } else if (categoryName.equals("Cook")) { // Chef/Cook
            categoryID = 4;
        } else if (categoryName.equals("Electrician")) {
            categoryID = 5;
        } else if (categoryName.equals("Glass Worker")) {
            categoryID = 6;
        } else if (categoryName.equals("Locksmith")) {
            categoryID = 7;
        } else if (categoryName.equals("Mechanic")) {
            categoryID = 8;
        } else if (categoryName.equals("Mason")) {
            categoryID = 9;
        } else if (categoryName.equals("Painter")) {
            categoryID = 10;
        } else if (categoryName.equals("Plumber")) {
            categoryID = 11;
        } else if (categoryName.equals("Pest Control")) {
            categoryID = 12;
        } else if (categoryName.equals("Plasterer")) {
            categoryID = 13;
        } else if (categoryName.equals("Sewage Cleaner")) {
            categoryID = 14;
        } else if (categoryName.equals("Technician")) {
            categoryID = 15;
        } else if (categoryName.equals("Tiler")) {
            categoryID = 16;
        } else if (categoryName.equals("Welder")) {
            categoryID = 17;
        } else if (categoryName.equals("Furniture Repairer")) {
            categoryID = 18;
        }

        // Set the category name and ID
        //System.out.println("Selected Category: " + categoryName);
        //System.out.println("Category ID: " + categoryID);

        // Assuming 'category' is a label or text field for displaying the category name
        CategoryID=categoryID;
        category.setText(categoryName);
        System.out.println("Category id = " + categoryID);
    }


}
