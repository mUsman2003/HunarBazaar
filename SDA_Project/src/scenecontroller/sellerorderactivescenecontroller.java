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
import models.Order;
import models.Seller;

public class sellerorderactivescenecontroller {

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
    
    public void setStatus(String s) {
    	status = s;
    	System.out.println("Inside to active orders");
        try {
        	orderlist = Seller.getInstance().getlistoforder();
            loadOrders(Seller.getInstance().getlistoforder());
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
            if (order.getType().equalsIgnoreCase(status) && status.equalsIgnoreCase("active") && order.getSellerId() == Seller.getInstance().getId()) {
            	HBox orderBox = new HBox(10); // Horizontal layout with 10px spacing
            	String buyerName = AccountController.getBuyerName(order.getBuyerId());

            	Button orderButton = new Button("Order ID: " + order.getOrderId() + " Buyer: " + buyerName );
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
            else if (order.getType().equalsIgnoreCase(status) && !status.equalsIgnoreCase("active") && order.getSellerId() == Seller.getInstance().getId()) {
            	HBox orderBox = new HBox(10); // Horizontal layout with 10px spacing
            	String buyerName = AccountController.getBuyerName(order.getBuyerId());

            	Button orderButton = new Button("Order ID: " + order.getOrderId() + " Buyer: " + buyerName );
                orderButton.setPrefWidth(1025); // Adjust as needed
                orderButton.setPrefHeight(60);
                orderButton.setOnAction(event -> handleOrderClick(order));
                // Add both buttons to the HBox
                orderBox.getChildren().addAll(orderButton);
//                orderBox.getChildren().addAll(orderButton, markAsDoneButton, markAsCancelButton);

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
    	controllers.OrderController.setStatus(order,"Active","Completed");
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Order ID: " + order.getOrderId());
        alert.setHeaderText("Success!");
        alert.setContentText("Your Order has been marked as done and moved to pending successfully.");
        alert.show();
    	List<Order> orderlist = Seller.getInstance().getlistoforder();
    	for(Order o: orderlist) {
    		if(o.getOrderId() == order.getOrderId()) {
    			o.setType("Pending");
    		}
    	}
    	Seller.getInstance().setlistoforder(orderlist);
        loadOrders(Seller.getInstance().getlistoforder());
    }
    
    public void markOrderAsCancel(Order order) throws SQLException {
    	controllers.OrderController.setStatus(order,"Active","Canceled");
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Order ID: " + order.getOrderId());
        alert.setHeaderText("Success!");
        alert.setContentText("Your Order has been cancelled successfully.");
    	List<Order> orderlist = Seller.getInstance().getlistoforder();
    	for(Order o: orderlist) {
    		if(o.getOrderId() == order.getOrderId()) {
    			o.setType("Canceled");
    		}
    	}
    	Seller.getInstance().setlistoforder(orderlist);
        loadOrders(Seller.getInstance().getlistoforder());
    }

    @FXML
    void gotoactiveorder(ActionEvent event) {
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
    void gotoback(ActionEvent event) {
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
    void gotocanceled(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/sellerordercancelledscene.fxml"));
    		Parent scene2Root = loader.load();
    		sellerorderactivescenecontroller controller = loader.getController();
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
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellerchatscene.fxml"));
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
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/sellerordercompletedscene.fxml"));
    		Parent scene2Root = loader.load();
    		sellerorderactivescenecontroller controller = loader.getController();
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
    void gotopending(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/sellerorderpendingscene.fxml"));
    		Parent scene2Root = loader.load();
    		sellerorderactivescenecontroller controller = loader.getController();
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
