package scenecontroller;

import java.sql.SQLException;

import controllers.GigController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Gig;
import models.Seller;

public class sellergignewscenecontroller {

    @FXML
    private Button goback;

    @FXML
    private Button chatsbutton;

    @FXML
    private Button orderbutton;

    @FXML
    private Button gigsbutton;

    @FXML
    private Button dashboardbutton;

    @FXML
    private Button earningbutton;

    @FXML
    private Button publishgigbutton;
    

    @FXML
    private TextField title;

    @FXML
    private MenuButton categorymenu;
    
    @FXML
    private TextField description;

    @FXML
    void gotoback(ActionEvent event) {
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellergigscene.fxml"));
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
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellerchatscene.fxml"));
            Stage stage = (Stage) goback.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gotodashboard(ActionEvent event) {
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellerdashboardscene.fxml"));
            Stage stage = (Stage) goback.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gotoearning(ActionEvent event) {
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellerearningscene.fxml"));
            Stage stage = (Stage) goback.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gotogigs(ActionEvent event) {
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellergigscene.fxml"));
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
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/sellerorderactivescene.fxml"));
    		Parent scene2Root = loader.load();
    		sellerorderactivescenecontroller controller = loader.getController();
//            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellerorderactivescene.fxml"));
            Stage stage = (Stage) goback.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
            controller.setStatus("Active");
            System.out.println("Going to active orders");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void menuclicked(ActionEvent event) {
    	MenuItem clickedItem = (MenuItem) event.getSource();
        String categoryName = clickedItem.getText();
        categorymenu.setText(categoryName);
    }
    
    @FXML
    void publishgigfunction(ActionEvent event) throws SQLException {
    	Gig newgig = new Gig();
        
    	if (categorymenu.getText() == null) {
    		System.out.println("Category can't be null");
    	}
    	if (title.getText() == null) {
    		System.out.println("Title can't be null");
    	}
    	if (description.getText() == null) {
    		System.out.println("Description can't be null");
    	}

    	newgig.setGigCategory(categorymenu.getText());
    	newgig.setGigDescription(this.description.getText());
    	newgig.setGigId(Seller.getInstance().getId()); //Temporarily setting new gig id as seller id
    	int res = GigController.createGig(newgig);
    	if (res == -1) {
    		Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Gig Publish");
            alert.setHeaderText("Failed!");
            alert.setContentText("Your gig has not been published.");
            alert.showAndWait(); // Display the dialog and wait for user interaction
    	}
    	else {
    		Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Gig Published");
            alert.setHeaderText("Success!");
            alert.setContentText("Your gig has been published successfully.");
            alert.showAndWait(); // Display the dialog and wait for user interaction
            newgig.setGigId(res);		//Resetting back to new gig id
            Seller.getInstance().setListofgigs(GigController.getListOfGigs(Seller.getInstance().getId()));
            try {
                Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellergigscene.fxml"));
                Stage stage = (Stage) goback.getScene().getWindow();
                Scene scene = new Scene(scene2Root);
                stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
    	}
    }

}
