package scenecontroller;

import java.sql.SQLException;

import controllers.GigController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.Gig;
import models.Seller;

public class sellergigviewscenecontroller {

    @FXML
    private ImageView pane;

    @FXML
    private Button goback;
    
    @FXML
    private Button deletegig;

    @FXML
    private Button sellerhome;

    @FXML
    private Button chatsbutton;

    @FXML
    private Button ordersbutton;

    @FXML
    private Button gigbutton;

    @FXML
    private Button dashboardbutton;

    @FXML
    private Button earning;

    @FXML
    private Label name;

    @FXML
    private Label username;

    @FXML
    private Label category;

    @FXML
    private Label gigDescription;

    @FXML
    private Label gigTitle;

    @FXML
    private Label rating;

    @FXML
    private Label name1;

//    @FXML
//    private Button editdescriptionbutton;
    private Gig gig;
    
    public void setGig(Gig gig) {
    	this.gig = gig;
    	
    	if (gig != null) {
            gigTitle.setText("");
            gigDescription.setText(gig.getGigDescription());
            Seller seller = Seller.getInstance();
            name.setText(seller.getname());
            username.setText("@" + seller.getusername());
            category.setText(seller.getGigCategoryname());
            rating.setText(String.valueOf(seller.getFeedback()));
            name1.setText(seller.getlocation());
        }
    	else {
    		System.out.println("Gig is null");
    	}
    }
    @FXML
    public void initialize() {
    	
    }
    
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
    void gotoorders(ActionEvent event) {
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
    void gotosellerhome(ActionEvent event) {
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellerhomescene.fxml"));
            Stage stage = (Stage) goback.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void deletinggig(ActionEvent event) throws SQLException {
        System.out.println("Deleting gig");
        
        boolean del = GigController.deleteGig(this.gig.getGigId());
        if (del) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Gig Deletion");
            alert.setHeaderText("Success!");
            alert.setContentText("Your gig has been deleted successfully.");
            alert.showAndWait(); // Display the dialog and wait for user interaction

            // Refresh Seller instance's list of gigs
            Seller.getInstance().setListofgigs(GigController.getListOfGigs(Seller.getInstance().getId()));

            try {
                Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellergigscene.fxml"));
                Stage stage = (Stage) goback.getScene().getWindow();
                Scene scene = new Scene(scene2Root);
                stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Gig Deletion");
            alert.setHeaderText("Failed!");
            alert.setContentText("Your gig hasn't been deleted.");
            alert.showAndWait();
        }
    }


    
}
