package scenecontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class forgotpasswordscenecontroller {

    @FXML
    private Button goback;

    @FXML
    private Button changepassword;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private TextField phonenumber;

    @FXML
    private PasswordField confirmpassword;

    @FXML
    void gotosignin(ActionEvent event) {
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/signinscene.fxml"));
            Stage stage = (Stage) goback.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gotosignin2(ActionEvent event) {
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/becomeseller.fxml"));
            Stage stage = (Stage) changepassword.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void printlastname(ActionEvent event) {

    }

}
