package strategy;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class sellerhomestrategy implements homepagestrategy {
	private Button signinbutton;
	
	public sellerhomestrategy(Button signin){
		this.signinbutton = signin;
	}
    @Override
    public void displayHomePage() {
    	try {
    		Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellerhomescene.fxml"));
    		Stage stage = (Stage) signinbutton.getScene().getWindow();
    		Scene scene = new Scene(scene2Root);
    		stage.setScene(scene);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
