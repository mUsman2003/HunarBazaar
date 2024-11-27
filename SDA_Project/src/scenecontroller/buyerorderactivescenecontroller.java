package scenecontroller;

import java.sql.SQLException;
import java.util.List;

import controllers.AccountController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Buyer;
import models.Order;
import models.Seller;

public class buyerorderactivescenecontroller {

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
    private VBox orderContainer;
    
    @FXML
//    private ScrollPane scrollpane;
    
    private List<Order> orderlist;
    
    private String status;
    
    private double feedback;
    
    public void setFeedback(double feed) {
    	feedback = Double.parseDouble(String.format("%.2f", feed)); 
    }
    
    public void setStatus(String s) {
    	status = s;
    	System.out.println("Inside to active orders");
        try {
        	orderlist = Buyer.getInstance().getlistoforder();
            loadOrders(Buyer.getInstance().getlistoforder());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void initialize() {
        
    }

    public void loadOrders(List<Order> orders) {
        orderContainer.getChildren().clear(); // Clear any existing buttons
        for (Order order : orders) {
            // Create an HBox to hold the order button and the "Mark as Done" button
            
            // Create the main order button
        	System.out.println(order.getType());
            if (order.getType().equalsIgnoreCase(status) && status.equalsIgnoreCase("pending") && order.getBuyerId() == Buyer.getInstance().getId()) {
            	HBox orderBox = new HBox(10); // Horizontal layout with 10px spacing
            	String sellerName = AccountController.getBuyerName(order.getSellerId());

            	Button orderButton = new Button("Order ID: " + order.getOrderId() + " Seller: " + sellerName );
                orderButton.setPrefWidth(780); // Adjust as needed
                orderButton.setPrefHeight(60);
                orderButton.setOnAction(event -> handleOrderClick(order));
                
                // Create the "Mark as Done" button
                Button markAsDoneButton = new Button("Mark as Done");
                markAsDoneButton.setPrefWidth(120);
                markAsDoneButton.setPrefHeight(60);
                markAsDoneButton.setOnAction(event -> {
					try {
						markOrderAsDone(order);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
                
                Button markAsCancelButton = new Button("Mark as Cancel");
                markAsCancelButton.setPrefWidth(120);
                markAsCancelButton.setPrefHeight(60);
                markAsCancelButton.setOnAction(event -> {
					try {
						markOrderAsCancel(order);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
                
                // Add both buttons to the HBox
                orderBox.getChildren().addAll(orderButton, markAsDoneButton, markAsCancelButton);

                // Add the HBox to the VBox container
                orderContainer.getChildren().add(orderBox);
            }
            else if (order.getType().equalsIgnoreCase(status) && !status.equalsIgnoreCase("pending") && order.getBuyerId() == Buyer.getInstance().getId()) {
            	HBox orderBox = new HBox(10); // Horizontal layout with 10px spacing
            	String sellerName = AccountController.getBuyerName(order.getSellerId());

            	Button orderButton = new Button("Order ID: " + order.getOrderId() + " Seller: " + sellerName );
                orderButton.setPrefWidth(1025); // Adjust as needed
                orderButton.setPrefHeight(60);
                orderButton.setOnAction(event -> handleOrderClick(order));
                orderBox.getChildren().addAll(orderButton);

                // Add the HBox to the VBox container
                orderContainer.getChildren().add(orderBox);
            }
           
        }
    }

    public void handleOrderClick(Order order) {
        try {
        	Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Order Details " + order.getOrderId());
            alert.setHeaderText("Details");
            alert.setContentText("Order ID: " + order.getGigId());
            alert.setContentText("Buyer Name: " + AccountController.getBuyerName(order.getBuyerId()));
            alert.setContentText("Seller Name: " + AccountController.getBuyerName(order.getSellerId()));
            alert.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void markOrderAsDone(Order order) throws SQLException {
        // Update the order status
        controllers.OrderController.setStatus(order, "Pending", "Completed");

        // Show success alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order ID: " + order.getOrderId());
        alert.setHeaderText("Success!");
        alert.setContentText("Your Order has been marked as done successfully.");
        alert.showAndWait();

        // Update the local order list
        List<Order> orderlist = Buyer.getInstance().getlistoforder();
        for (Order o : orderlist) {
            if (o.getOrderId() == order.getOrderId()) {
                o.setType("Completed");
            }
        }
        
        // Transition to the feedback scene
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/feedbackscene.fxml"));
            Parent feedbackRoot = loader.load();
    		feedbackscenecontroller controller = loader.getController();
    		controller.setOrderId(order.getOrderId());
            Scene feedbackScene = new Scene(feedbackRoot);
            Stage stage = (Stage) goback.getScene().getWindow();
            stage.setScene(feedbackScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    	Buyer.getInstance().setlistoforder(orderlist);
        loadOrders(Buyer.getInstance().getlistoforder());
    }
    
    public void markOrderAsCancel(Order order) throws SQLException {
    	controllers.OrderController.setStatus(order,"Pending","Canceled");
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Order ID: " + order.getOrderId());
        alert.setHeaderText("Success!");
        alert.setContentText("Your Order has been cancelled successfully.");
        alert.show();
    	List<Order> orderlist = Buyer.getInstance().getlistoforder();
    	for(Order o: orderlist) {
    		if(o.getOrderId() == order.getOrderId()) {
    			o.setType("Canceled");
    		}
    	}
    	Buyer.getInstance().setlistoforder(orderlist);
        loadOrders(Buyer.getInstance().getlistoforder());
    }

    @FXML
    void gotoactiveorder(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/buyerorderactivescene.fxml"));
    		Parent scene2Root = loader.load();
    		buyerorderactivescenecontroller controller = loader.getController();
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
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/buyerordercancelledscene.fxml"));
    		Parent scene2Root = loader.load();
    		buyerorderactivescenecontroller controller = loader.getController();
//            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellerorderactivescene.fxml"));
            Stage stage = (Stage) goback.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
            controller.setStatus("canceled");
            System.out.println("Going to active orders");
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
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/buyerordercompletedscene.fxml"));
    		Parent scene2Root = loader.load();
    		buyerorderactivescenecontroller controller = loader.getController();
//            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellerorderactivescene.fxml"));
            Stage stage = (Stage) goback.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
            controller.setStatus("completed");
            System.out.println("Going to active orders");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void gotoorder(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/buyerorderactivescene.fxml"));
    		Parent scene2Root = loader.load();
    		buyerorderactivescenecontroller controller = loader.getController();
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
    void gotopending(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/buyerorderpendingscene.fxml"));
    		Parent scene2Root = loader.load();
    		buyerorderactivescenecontroller controller = loader.getController();
//            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellerorderactivescene.fxml"));
            Stage stage = (Stage) goback.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
            controller.setStatus("Pending");
            System.out.println("Going to active orders");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
