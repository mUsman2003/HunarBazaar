package scenecontroller;

import controllers.OrderController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;
import models.Feedback;
import models.Seller;

public class feedbackscenecontroller {

    @FXML
    private ImageView pane;

    @FXML
    private Button goback;

    @FXML
    private Button submitreview;

    @FXML
    private Button skipreview;

    @FXML
    private Slider reviewSlider;
    
    @FXML
    private TextField feedback;

    @FXML
    private Label reviewLabel;
    
    private int orderid;

    
    @FXML
    void gotoback(ActionEvent event) {

    }
    
    @FXML
    void feedback(ActionEvent event) {

    }


//   
//    @FXML
//    void reviewtolabel(MouseDragEvent event) {
//    	double sliderValue = reviewSlider.getValue();
//    	System.out.println(sliderValue);
//    	reviewLabel.setText(String.format("%.2f", sliderValue));  
//    }


    @FXML
    void reviewtolabel(KeyEvent event) {
    	double sliderValue = reviewSlider.getValue();
    	System.out.println(sliderValue);
    	reviewLabel.setText(String.format("%.2f", sliderValue)); 
    }
    
    @FXML
    void skipreview(ActionEvent event) {
    		if (Seller.getInstance() == null) {
    			try { 
	    			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/buyerorderactivescene.fxml"));
	        		Parent scene2Root = loader.load();
	        		buyerorderactivescenecontroller controller = loader.getController();
	                Stage stage = (Stage) goback.getScene().getWindow();
	                Scene scene = new Scene(scene2Root);
	                stage.setScene(scene);
	                controller.setStatus("Active");
	                System.out.println("Going to active orders");
	            	} 
    			catch (Exception e) {
	                e.printStackTrace();
    			}
    		}
    		else {
    			try { 
	    			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/sellerorderpendingbuyingscene.fxml"));
	        		Parent scene2Root = loader.load();
	        		sellerorderactivebuyingcontroller controller = loader.getController();
	                Stage stage = (Stage) goback.getScene().getWindow();
	                Scene scene = new Scene(scene2Root);
	                stage.setScene(scene);
	                controller.setStatus("Active");
	                System.out.println("Going to active orders");
	            	} 
    			catch (Exception e) {
	                e.printStackTrace();
    			}
    		}
    		
    }

    @FXML
    void submitreview(ActionEvent event) {
    	 if (Seller.getInstance() == null) {
			try { 
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/buyerorderactivescene.fxml"));
        		Parent scene2Root = loader.load();
        		buyerorderactivescenecontroller controller = loader.getController();
                Stage stage = (Stage) goback.getScene().getWindow();
                Scene scene = new Scene(scene2Root);
                stage.setScene(scene);
                controller.setStatus("Active");
                OrderController.setFeedback(orderid, reviewSlider.getValue());
                System.out.println("Going to active orders");
            	} 
			catch (Exception e) {
                e.printStackTrace();
			}
		}
		else {
			try { 
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/sellerorderpendingbuyingscene.fxml"));
        		Parent scene2Root = loader.load();
        		sellerorderactivebuyingcontroller controller = loader.getController();
                Stage stage = (Stage) goback.getScene().getWindow();
                OrderController.setFeedback(orderid, reviewSlider.getValue());
                Scene scene = new Scene(scene2Root);
                stage.setScene(scene);
            	} 
			catch (Exception e) {
                e.printStackTrace();
			}
		}
    }

	public void setOrderId(int orderId) {
		// TODO Auto-generated method stub
		this.orderid = orderId;
	}

}
