package scenecontroller;

import PersistentStorage.ChatRepository;
import PersistentStorage.PersistenceFactory;
import PersistentStorage.SQLServerHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.Buyer;
import models.Gig;
import models.Seller;

public class sellergigdetailscenecontroller {


    @FXML
    private Button Chatbtn;

    @FXML
    private Label category;

    @FXML
    private Button chatsbutton;

    @FXML
    private Button dashboardbutton;

    @FXML
    private Button earning;

    @FXML
    private Label gigDescription;

    @FXML
    private Label gigTitle;

    @FXML
    private Button gigbutton;

    @FXML
    private Button goback;

    @FXML
    private Label name;

    @FXML
    private Label name1;

    @FXML
    private Button ordersbutton;

    @FXML
    private ImageView pane;

    @FXML
    private Label rating;

    @FXML
    private Button sellerhome;

    @FXML
    private Label username;

    @FXML
    void StartChat(ActionEvent event) {

    	Buyer b=Buyer.getInstance();
    	//Seller s = Seller.getInstance();
    	System.out.println("BuyerID: " +b.getId());
    	
    	System.out.println("\nSellerID: "+ this.getSellerID());
    	
    	PersistenceFactory factory = new PersistenceFactory();
        SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");
        ChatRepository chatRepo = sqlHandler.getChatRepository();
    	chatRepo.insertChatIDBuyer(this.getSellerID());
    	
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellerchatscene.fxml"));
           
            
            Stage stage = (Stage) goback.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private Gig gig;
    
    public void setGig(Gig gig) {
    	this.gig = gig;
    	
    	if (gig != null) {
            gigTitle.setText("");
            gigDescription.setText(gig.getGigDescription());
//            gigPrice.setText(String.valueOf(gig.getPrice()));
            Seller seller = Seller.getInstance();

            // Set the labels with the respective information
            name.setText(seller.getname());
            username.setText("@" + seller.getusername());
            category.setText(seller.getGigCategoryname());
//            customers.setText(String.valueOf(seller.getCustomers()));
//            description.setText(seller.getDescription());
            rating.setText(String.valueOf(seller.getFeedback()));
            // Optionally set name1 to something meaningful if needed
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
    void gotogigs(ActionEvent event) {
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellerordergigscene.fxml"));
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
    public void setGig(String[] details) {
        // Ensure the details array has the expected number of elements
        if (details == null || details.length < 5) {
            System.out.println("Invalid gig details provided.");
            return;
        }

        // Extract the details from the array
        String sellerName = details[0].split(": ")[1];
        String sellerLocation = details[1].split(": ")[1];
        String avgReview = details[2].split(": ")[1];
        String gigDescription = details[3].split(": ")[1];
        String gigCategory = details[4].split(": ")[1];

        // Populate the UI elements with the extracted details
        gigTitle.setText("Gig Title:");
        this.gigDescription.setText(gigDescription); // Assuming gig title isn't provided separately
        category.setText(gigCategory);
        name.setText(sellerName);
        name1.setText(sellerLocation);
        rating.setText(avgReview);
    }

    @FXML
    void startnewchat(ActionEvent event) {
    	System.out.println("New chat");
    }

 private int SellerID;
    
   	public void SetSellerID(int sellerID2) {
   		SellerID=sellerID2;
   		
   	}
   	public int getSellerID()
   	{
   		return SellerID;
   	}
}
