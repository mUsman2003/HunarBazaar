package scenecontroller;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Gig;
import models.Seller;

public class sellergigscenecontroller {

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
    private Button createnewgigbutton;
    
    @FXML
    private VBox gigContainer;
    
    private Scene previous;
    
    void setprevious(Scene scene) {
    	previous = scene;
    }
    @FXML
    public void initialize() {
        try {
            int sellerId = Seller.getInstance().getId(); // Replace with the actual seller's ID
            System.out.println(Seller.getInstance().getname());
            loadGigs(Seller.getInstance().getListofgigs());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

	public void loadGigs(List<Gig> gigs) {
	    gigContainer.getChildren().clear(); // Clear any existing buttons
	    for (Gig gig : gigs) {
		    Button gigButton = new Button(gig.getGigDescription());
		    gigButton.setPrefWidth(1030);
		    gigButton.setPrefHeight(50);// Adjust size as needed
	        gigButton.setOnAction(event -> handleGigClick(gig));
	        gigContainer.getChildren().add(gigButton);
	    }
	}
    
	public void handleGigClick(Gig gig) {
		try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/sellergigviewscene.fxml"));
            Parent scene2Root = loader.load();
            sellergigviewscenecontroller controller = loader.getController();
            controller.setGig(gig);
            Stage stage = (Stage) goback.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	

	@FXML
    void gotoback(ActionEvent event) {
//    	try {
//            Stage stage = (Stage) previous.getWindow();
//            stage.setScene(previous);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
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
    void gotocreatenewgig(ActionEvent event) {
    	if (Seller.getInstance().getListofgigs().size() > 3) {
    		Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Gig Publish");
            alert.setHeaderText("Failed!");
            alert.setContentText("You can't create more than 3 Gigs.");
            alert.showAndWait(); // Display the dialog and wait for user interaction
            return;
    	}
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellergignewscene.fxml"));
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
}
 