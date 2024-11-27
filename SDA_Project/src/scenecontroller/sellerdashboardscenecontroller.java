package scenecontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.Seller;

public class sellerdashboardscenecontroller<NextSceneController> {
	@FXML
    private ImageView pane;

    @FXML
    private Button goback;

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
    private Label rating;

    @FXML
    private Label name1;


    @FXML
    public void initialize() {
        // Get the instance of Seller
        Seller seller = Seller.getInstance();

        // Set the labels with the respective information
        name.setText(seller.getname());
        username.setText("@" + seller.getusername());
        category.setText("Category: " + seller.getGigCategoryname());
//        income.setText(String.valueOf(seller.getEarning()));
//        customers.setText(String.valueOf(seller.getCustomers()));
//        description.setText(seller.getDescription());
        rating.setText(String.valueOf(seller.getFeedback()));

        // Optionally set name1 to something meaningful if needed
        name1.setText("Location: " + seller.getlocation());
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


}
