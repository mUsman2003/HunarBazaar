package scenecontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.Buyer;
import models.Seller;
import models.category;

public class buyerhomescenecontroller {

    @FXML
    private Button becomesellerbutton;
    @FXML
    private Button goback;
    @FXML
    private Button chatbutton;

    @FXML
    private Button orderbutton;
    

    @FXML
    private Button A1;
    
    @FXML
    private Button A10;

    @FXML
    private Button A11;

    @FXML
    private Button A12;

    @FXML
    private Button A13;

    @FXML
    private Button A14;

    @FXML
    private Button A15;

    @FXML
    private Button A16;

    @FXML
    private Button A17;

    @FXML
    private Button A18;

    @FXML
    private Button A2;

    @FXML
    private Button A3;

    @FXML
    private Button A4;

    @FXML
    private Button A5;

    @FXML
    private Button A6;

    @FXML
    private Button A7;

    @FXML
    private Button A8;

    @FXML
    private Button A9;

    
    @FXML
    void GotoCategoryApplianceTechnician(ActionEvent event) {   	

    	category c = category.getInstance();
    	c.setValue(1);
    	System.out.println("Hello");
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyergigbuy.fxml"));
            Stage stage = (Stage) becomesellerbutton.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    }
    
    @FXML
    void GotoCategoryBlackSmith(ActionEvent event) {
    	category c = category.getInstance();
    	c.setValue(2);
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyergigbuy.fxml"));
            Stage stage = (Stage) becomesellerbutton.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    }

    @FXML
    void GotoCategoryCarpenter(ActionEvent event) {
    	category c = category.getInstance();
    	c.setValue(3);

    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyergigbuy.fxml"));
            Stage stage = (Stage) becomesellerbutton.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void GotoCategoryChef(ActionEvent event) {
    	category c = category.getInstance();
    	c.setValue(4);
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyergigbuy.fxml"));
            Stage stage = (Stage) becomesellerbutton.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void GotoCategoryElectrician(ActionEvent event) {
    	category c = category.getInstance();
    	c.setValue(5);
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyergigbuy.fxml"));
            Stage stage = (Stage) becomesellerbutton.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void GotoCategoryFurnitureRepairer(ActionEvent event) {
    	category c = category.getInstance();
    	c.setValue(18);
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyergigbuy.fxml"));
            Stage stage = (Stage) becomesellerbutton.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void GotoCategoryGlassWorker(ActionEvent event) {
    	category c = category.getInstance();
    	c.setValue(6);
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyergigbuy.fxml"));
            Stage stage = (Stage) becomesellerbutton.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void GotoCategoryLockSmith(ActionEvent event) {
    	category c = category.getInstance();
    	c.setValue(7);
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyergigbuy.fxml"));
            Stage stage = (Stage) becomesellerbutton.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void GotoCategoryMachanic(ActionEvent event) {
    	category c = category.getInstance();
    	c.setValue(8);
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyergigbuy.fxml"));
            Stage stage = (Stage) becomesellerbutton.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void GotoCategoryMason(ActionEvent event) {
    	category c = category.getInstance();
    	c.setValue(9);
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyergigbuy.fxml"));
            Stage stage = (Stage) becomesellerbutton.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void GotoCategoryPainter(ActionEvent event) {
    	category c = category.getInstance();
    	c.setValue(10);
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyergigbuy.fxml"));
            Stage stage = (Stage) becomesellerbutton.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void GotoCategoryPestController(ActionEvent event) {
    	category c = category.getInstance();
    	c.setValue(12);
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyergigbuy.fxml"));
            Stage stage = (Stage) becomesellerbutton.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void GotoCategoryPlasterer(ActionEvent event) {
    	category c = category.getInstance();
    	c.setValue(13);
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyergigbuy.fxml"));
            Stage stage = (Stage) becomesellerbutton.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void GotoCategoryPumber(ActionEvent event) {
    	category c = category.getInstance();
    	c.setValue(11);
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyergigbuy.fxml"));
            Stage stage = (Stage) becomesellerbutton.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void GotoCategorySewageCleaner(ActionEvent event) {
    	category c = category.getInstance();
    	c.setValue(14);
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyergigbuy.fxml"));
            Stage stage = (Stage) becomesellerbutton.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void GotoCategoryTechnician(ActionEvent event) {
    	category c = category.getInstance();
    	c.setValue(15);
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyergigbuy.fxml"));
            Stage stage = (Stage) becomesellerbutton.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void GotoCategoryTiler(ActionEvent event) {
    	category c = category.getInstance();
    	c.setValue(16);
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyergigbuy.fxml"));
            Stage stage = (Stage) becomesellerbutton.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void GotoCategoryWelder(ActionEvent event) {
    	category c = category.getInstance();
    	c.setValue(17);
    	
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyergigbuy.fxml"));
            Stage stage = (Stage) becomesellerbutton.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void gotobecomeseller(ActionEvent event) {
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/becomeseller.fxml"));
            Stage stage = (Stage) becomesellerbutton.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void gotoback(ActionEvent event) {
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/signinscene.fxml"));
            Stage stage = (Stage) goback.getScene().getWindow();
            Scene scene = new Scene(scene2Root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    	Buyer.resetInstance();
    	Seller.resetInstance();
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
    void gotoorders(ActionEvent event) {
    	
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
}
