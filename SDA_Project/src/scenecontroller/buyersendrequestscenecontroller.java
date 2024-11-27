package scenecontroller;


import java.sql.SQLException;
import java.util.List;

import controllers.AccountController;
import controllers.ChatController;
import controllers.GigController;
import controllers.OrderController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import models.Buyer;
import models.Gig;
import models.Order;
import models.Seller;

public class buyersendrequestscenecontroller {

    @FXML
    private Button goback;

    @FXML
    private Button chatsbutton;

    @FXML
    private Button orderbutton;

    @FXML
    private Button chatbutton;

    @FXML
    private Label sellerLabel;

    @FXML
    private MenuButton gigcategorymenu;

    @FXML
    private Button submitorderbutton;

    private int gigid;
    private int sellerid;
    private int buyerid;
    
    @FXML
    void gigmenubutton(ActionEvent event) {
    	MenuItem clickedItem = (MenuItem) event.getSource();
        String categoryName = clickedItem.getText();
        gigcategorymenu.setText(categoryName);
        System.out.println(categoryName);
    }
    
    @FXML 
    void initialize() {
        // Set the seller's name
        
        
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
    void submitorder(ActionEvent event) {
//    	INSERT INTO Orders (GigID, SellerID, BuyerID, SellerReview, OrderStatus) VALUES    	(1, 1, 20, NULL, 'Pending')
    	Order order = new Order();
    	order.setGigId(gigid);
    	order.setSellerId(sellerid);
    	order.setBuyerId(buyerid);
    	order.setType("Active");
    	int neworderid = OrderController.addnewOrder(order);
    	if (neworderid == -1) {
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
//            order.setGigId(res);		//Resetting back to new gig id
//            Seller.getInstance().setListofgigs(GigController.getListOfGigs(Seller.getInstance().getId()));
            List<Order> neworder = OrderController.getListofOrders(buyerid);
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

    private int chatId;

	public void setchatId(int chatId) throws SQLException {
		// TODO Auto-generated method stub
		this.chatId = chatId;
		int b = Buyer.getInstance().getId();
		int sellerid = ChatController.getSellerNamefromChat(chatId, b);
		String sellerName = AccountController.getBuyerName(sellerid);
		List<Gig>gigs = GigController.getListOfGigs(sellerid);
		sellerLabel.setText(sellerName);
        
        // Clear any previous items in the menu
        gigcategorymenu.getItems().clear();
        if (gigs != null) {
        	for (Gig gig: gigs) {
            	MenuItem gigItem = new MenuItem(gig.getGigDescription());
            	gigItem.setOnAction(event -> {
                    // Set the seller ID dynamically when a chat is clicked
            		this.gigid = gig.getGigId();
            		this.sellerid = sellerid;
            		this.buyerid = b;
            		gigmenubutton(event);
                });
            	gigcategorymenu.getItems().add(gigItem);
            }
        }
        else {
        	
        }
	}

}

