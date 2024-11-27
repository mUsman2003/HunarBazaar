package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file and link it to the SampleController
            FXMLLoader loader = new FXMLLoader(getClass().getResource("signinscene.fxml"));
            Parent root = loader.load(); // Load the FXML file
            
            // Create the scene and set it to the stage
            Scene scene = new Scene(root);
            primaryStage.setTitle("JavaFX with Controller");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        launch(args);// NOTE: in the connection string:
        // - Change FTCLAPTOP-13 to the name of your SQL Server.
        // - Change Learners to the name of your database in SQL Server.

        String connectionString = 
            "jdbc:sqlserver://IRTAZA-KHAN\\SQLEXPRESS:1433;Database=SDA_Project_Database;encrypt=false;trustServerCertificate=true;integratedSecurity=true;";

        try {
            try (Connection connection = DriverManager.getConnection(connectionString)) {
                System.out.println("Connection established.");
               
                // Create a Statement to execute SQL queries

            } finally {
			}
        } catch (SQLException e) {
            System.out.println("Error connecting to the database");
            e.printStackTrace();
        }
        
    	
        launch(args);
}

    }
