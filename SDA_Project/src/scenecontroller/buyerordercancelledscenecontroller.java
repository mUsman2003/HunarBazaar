package scenecontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class buyerordercancelledscenecontroller {

    @FXML
    private Button goback;

    @FXML
    private Button chatsbutton;

    @FXML
    private Button orderbutton;

    @FXML
    private Button activeorderbutton;

    @FXML
    private Button pendingorderbutton;

    @FXML
    private Button completedorderbutton;

    @FXML
    private Button canceledorderbutton;

    @FXML
    void gotoactiveorder(ActionEvent event) {
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyerorderactivescene.fxml"));
            Stage stage = (Stage) goback.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
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
    void gotocanceled(ActionEvent event) {
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyerordercancelledscene.fxml"));
            Stage stage = (Stage) goback.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gotochats(ActionEvent event) {
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyerchatscene.fxml"));
            Stage stage = (Stage) goback.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gotocompleted(ActionEvent event) {
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyerordercompletedscene.fxml"));
            Stage stage = (Stage) goback.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gotoorder(ActionEvent event) {
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyerorderactivescene.fxml"));
            Stage stage = (Stage) goback.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gotopending(ActionEvent event) {
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyerorderpendingscene.fxml"));
            Stage stage = (Stage) goback.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
