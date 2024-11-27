package scenecontroller;


import java.util.List;

import controllers.GigController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.category;

public class sellerGigCategoryDisplayController {

	
	@FXML
	private VBox contentBox; // This corresponds to the VBox in the FXML

	@FXML
	public void initialize() {
	    // Fetch gigs dynamically based on the current category
	    List<String> gigs = GigController.getCategoryGigs();

	    // Check if there are any gigs returned
	    if (gigs.isEmpty()) {
	        System.out.println("No gigs found for the selected category.");
	        return;
	    }

	    // Populate the VBox dynamically
	    for (String gigDetails : gigs) {
	        try {
	            // Example format: "SellerID: 101; Seller: John Doe; Location: City; Avg Review: 4.85; Description: Custom Metalwork; Category: Blacksmith"
	            String[] details = gigDetails.split("; ");
	            
	            // Ensure the array has the correct number of parts
	            if (details.length != 6) {
	                System.out.println("Unexpected format for gigDetails: " + gigDetails);
	                continue; // Skip improperly formatted entries
	            }

	            // Extract the values from the split strings
	            int sellerID = Integer.parseInt(details[0].split(": ", 2)[1]);
	            String sellerName = details[1].split(": ", 2)[1];
	            String sellerLocation = details[2].split(": ", 2)[1];
	            String avgReview = details[3].split(": ", 2)[1];
	            String gigDescription = details[4].split(": ", 2)[1];
	            String category = details[5].split(": ", 2)[1];

	            // Create a new VBox for each gig
	            VBox gigDetailsBox = new VBox(5); // Spacing within the box
	            gigDetailsBox.setPrefSize(300, 100); // Adjust height to fit the button
	            gigDetailsBox.setPadding(new Insets(10));
	            gigDetailsBox.setAlignment(Pos.TOP_LEFT);
	            gigDetailsBox.setStyle("-fx-border-color: black; -fx-background-color: #f0f0f0; -fx-border-radius: 5; -fx-background-radius: 5;");

	            // Add title, description, and rating
	            Label title = new Label("Seller: " + sellerName);
	            title.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
	            Label description = new Label("Description: " + gigDescription);
	            Label rating = new Label("Avg Review: " + avgReview);
	            Label location = new Label("Location: " + sellerLocation);
	            Label categoryLabel = new Label("Category: " + category);

	            // Create the button
	            Button chatButton = new Button("Details");
	            chatButton.setPrefSize(100, 30);
	            chatButton.setOnAction(e -> {
	                try {
	                	//Seller seller=Seller.getInstance(sellerID, sellerName, sellerName, gigDescription, null, null, null, null, null, sellerLocation, category, sellerID, sellerID)
	                	//Seller s=Seller.getInstance();
	                	
	                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/sellergigdetailscene.fxml"));
	                    Parent scene2Root = loader.load();
	                    sellergigdetailscenecontroller controller = loader.getController();

	                    // Pass details to the next controller
	                    controller.SetSellerID(sellerID);
	                    controller.setGig(details);
	                    Stage stage = (Stage) goback.getScene().getWindow();
	                    Scene scene = new Scene(scene2Root);
	                    stage.setScene(scene);
	                } catch (Exception e1) {
	                    e1.printStackTrace();
	                }
	            });

	            // Add labels and button to the gigDetailsBox
	            gigDetailsBox.getChildren().addAll(title, description, rating, location, categoryLabel, chatButton);

	            // Add the gigDetailsBox to the VBox in the ScrollPane
	            contentBox.getChildren().add(gigDetailsBox);
	        } catch (Exception e) {
	            System.out.println("Error processing gigDetails: " + gigDetails);
	            e.printStackTrace();
	        }
	    }
	}



    @FXML
    private Button goback;

    @FXML
    void gotoback(ActionEvent event) {
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
