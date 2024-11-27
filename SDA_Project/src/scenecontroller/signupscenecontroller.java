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
import javafx.scene.control.MenuButton;


public class signupscenecontroller {

    @FXML
    private Button signupbutton;


    
	@FXML
    private TextField lastnamefield;

    @FXML
    private TextField firstnamefield;

    @FXML
    private TextField phonenumber;

    @FXML
    private TextField username;


    @FXML
    private PasswordField password;
    
    private String loc;

    @FXML
    private MenuButton category;
    /*
     * 
    @FXML
    void printfirstname() {
    	System.out.println(firstnamefield.getText());
    }

    @FXML
    void printlastname() {
    	System.out.println(lastnamefield.getText());
    }
    
    
    @FXML
    void printallnames(ActionEvent event) {
    	System.out.println("First Name: " + firstnamefield.getText() + " \nLast Name:");
    	System.out.println(lastnamefield.getText());
    	
    }
    
    @FXML
    void checkpassword(ActionEvent event) {
    	if (password.getText() != confirmpassword.getText()) {
    		System.out.println("Incorrect");
    	}
    }
    
    
     */
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    

    @FXML
    void menuclicked(ActionEvent event) {
        MenuItem clickedItem = (MenuItem) event.getSource();
        System.out.println(clickedItem.getText());
        category.setText(clickedItem.getText());
    }

    
    
    
    private boolean isValidInput(String firstName, String lastName, String phoneNumber, String password, String position) {
        // Validate first name and last name
        if (firstName.isEmpty() || lastName.isEmpty()) {
            showAlert("Validation Error", "First name and last name cannot be empty.");
            return false;
        }

        // Validate phone number length
        if (phoneNumber.length() != 10 || !phoneNumber.matches("\\d+")) {
            showAlert("Validation Error", "Phone number must be 10 digits.");
            return false;
        }


        // Validate password length
        if (password.length() < 8) {
            showAlert("Validation Error", "Password must be at least 8 characters long.");
            return false;
        }

        if (position == null) {
        	showAlert("Validation Error", "Location can't be null.");
            return false;
        }
        return true; // All validations passed
    }
    
    @FXML
    void gotosignin(ActionEvent event) {
    	System.out.println("SignUp");
    	// Declare and assign variables directly
        String firstName = firstnamefield.getText();
        String lastName = lastnamefield.getText();
        String phoneNumber = phonenumber.getText();
        String userName = username.getText();
        String userPassword = password.getText();
        String position = category.getText();
        
        if (!isValidInput(firstName, lastName, phoneNumber, userPassword, position)) {
        	return; // Stop if validation fails
        }
        
        boolean success = AccountController.BuyerSignUpVaidation(userName, userPassword);
        //boolean success = AccountController.BuyerSignup(firstName,lastName,userName,phoneNumber,"Lahore",userPassword);
        
        
        if(success)
        {
        	boolean SignUpSucess= AccountController.BuyerSignup(firstName,lastName,userName,phoneNumber,position,userPassword);
        	if(SignUpSucess)
        	{
        		
		    	try {
		            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/signinscene.fxml"));
		            Stage stage = (Stage) signupbutton.getScene().getWindow();
		            Scene scene = new Scene(scene2Root);
		            stage.setScene(scene);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
        	}
        }
    }

}
