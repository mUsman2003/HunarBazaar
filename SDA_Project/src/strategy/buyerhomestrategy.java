package strategy;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class buyerhomestrategy implements homepagestrategy {
	private Button signinbutton;
	
	public buyerhomestrategy(Button signin){
		this.signinbutton = signin;
	}
    @Override
    public void displayHomePage() {
    	try {
    		Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/buyerhomescene.fxml"));
    		Stage stage = (Stage) signinbutton.getScene().getWindow();
    		Scene scene = new Scene(scene2Root);
    		stage.setScene(scene);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
