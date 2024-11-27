package scenecontroller;

import controllers.AccountController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Buyer;
import models.Seller;
import models.User;
import strategy.buyerhomestrategy;
import strategy.homepagecontext;
import strategy.sellerhomestrategy;

public class signinscenecontroller {

    @FXML
    private Button signupbutton;

    @FXML
    private Button signin;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button forgotpassword;

    /*
     * 
    @FXML
    void gotoforgotpassword(ActionEvent event) {
    	System.out.println("Forgot Password");
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/forgotpasswordscene.fxml"));
            Stage stage = (Stage) forgotpassword.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     */

    @FXML
    void gotosignup(ActionEvent event) {
    	
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/signupscene.fxml"));
            Stage stage = (Stage) signupbutton.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void signinfunction(ActionEvent event) {
    	String usern = username.getText();
        String passw = password.getText();

        try {
            User user = AccountController.login(usern, passw);

            if (user != null) {
                homepagecontext homePageContext = new homepagecontext();

                if (user instanceof Buyer) {
                	
                    homePageContext.setHomePageStrategy(new buyerhomestrategy(signin));
                } else if (user instanceof Seller) {
                    homePageContext.setHomePageStrategy(new sellerhomestrategy(signin));
                }

                homePageContext.displayHomePage();
            }
            else {
                showAlert("Validation Error", "Incorrect Credentials");
            }
        }
        finally{            	
        }           
    }


	private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
