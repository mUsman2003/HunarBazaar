package scenecontroller;

import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.Buyer;
import models.Chats;
import models.Seller;

public class sellerchatscenecontroller {
	

    private volatile boolean keepRunning = true;

	@FXML
    private ScrollPane ChatBox;

    @FXML
    private TextField SendMessageBox;

    @FXML
    private ScrollPane UserNameBox;

    @FXML
    private Button acceptrequest;

    @FXML
    private Button chatsbutton;

    @FXML
    private Button contactinfobutton;

    @FXML
    private Button dashboardbutton;

    @FXML
    private Button earningbutton;

    @FXML
    private Button gigsbutton;

    @FXML
    private Button goback;

    @FXML
    private Button orderbutton;
    
      
    @FXML
    public void initialize() {
        Buyer b = Buyer.getInstance();
        Chats chat = Chats.getInstance(); 
        chat.setSenderId(b.getId());

        // Create a VBox to hold the user details
        VBox userList = new VBox(10); // Spacing between user entries
        userList.setPadding(new Insets(10)); // Padding around the VBox
        userList.setStyle("-fx-background-color: #f9f9f9;"); // Light background for the user box

        // Fetch the unique chats from ChatHandler
        List<String> chats = handlers.ChatHandler.getUserUniqueChats();

        // Populate the VBox with chat data
        for (String chatDetails : chats) {
            // Extract chat ID and opposite user name from the chatDetails string
            String[] parts = chatDetails.split(", ");
            int extractedChatId = Integer.parseInt(parts[0].split(": ")[1].trim());
            chat.setChatId(extractedChatId);
            chat.setSenderId(b.getId());
            String oppositeUserName = parts[1].split(": ")[1].trim(); // Extract the name after "Opposite User: "

            // Create a VBox for each user with borders and styling
            VBox userBox = new VBox(5); // Spacing within the userBox
            userBox.setPrefWidth(UserNameBox.getPrefWidth() * 0.8); // Fit the width of the ScrollPane
            userBox.setPadding(new Insets(10)); // Internal padding
            userBox.setStyle("-fx-border-color: black; -fx-background-color: #f0f0f0; -fx-border-radius: 5; -fx-background-radius: 5;");

            // Add user details (e.g., name and other info)
            Label userNameLabel = new Label(oppositeUserName);
            userNameLabel.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");
            //Label userStatusLabel = new Label("Status: Online");

            // Add all elements to the userBox
            userBox.getChildren().addAll(userNameLabel);

            // Handle clicks to populate the ChatBox with dummy messages
            userBox.setOnMouseClicked(event -> {
                    chat.setChatId(extractedChatId);
                    populateChatBox(userNameLabel.getText());

                    //startInfiniteLoop(userNameLabel.getText());
        
            });
            // Add the userBox to the userList VBox
            userList.getChildren().add(userBox);
        }
        // Set the userList as the content of the UserNameBox
        UserNameBox.setContent(userList);
    }

    private void populateChatBox(String user) {
        VBox chatMessages = new VBox(10); // Spacing between messages
        chatMessages.setPadding(new Insets(10)); // Padding around messages

        // Fetch the chat messages for the user
        List<String> chatMessagesList = handlers.ChatHandler.getUserUniqueChatMessages(); // Retrieve chat messages

        Buyer b =Buyer.getInstance();
        // Check if chatMessagesList is not empty
        if (chatMessagesList != null && !chatMessagesList.isEmpty()) {
            for (String chatDetails : chatMessagesList) {
                try {
                    // Extract chat details (e.g., chatId, senderId, message, timestamp)
                    // Split the string by comma
                    String[] parts = chatDetails.split(", ");
                    
                    // Ensure we have at least 3 parts (Chat ID, Sender ID, Message)
                    if (parts.length >= 3) {
                        // Extract Chat ID and Sender ID for debugging purposes
                        String chatIdPart = parts[0].split(": ")[1]; // Chat ID part
                        String senderIdPart = parts[1].split(": ")[1]; // Sender ID part
                        
                        // Extract message, which is after "Message: "
                        String message = parts[2].split(": ")[1]; // Extract message text
                        
                        // Optionally, print or log the extracted parts for debugging
                        System.out.println("Chat ID: " + chatIdPart + ", Sender ID: " + senderIdPart + ", Message: " + message);

                        // Create a label for each message
                        Label messageLabel = new Label(message);
                        int senderId = Integer.parseInt(senderIdPart); // Convert to int
                     // Check if the sender ID matches the current user's ID
                        if (senderId == b.getId()) {
                            // If the sender is the user, set a different style
                            messageLabel.setStyle("-fx-background-color: #e1e1e1; -fx-padding: 10; -fx-border-radius: 5; -fx-background-radius: 5;");
                        } else {
                            // If the sender is not the user, set the default style
                            messageLabel.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 10; -fx-border-radius: 5; -fx-background-radius: 5;");
                        }

                        // Add the message to the VBox
                        chatMessages.getChildren().add(messageLabel);
                    } else {
                        // Handle case where chat details format is unexpected
                        Label errorLabel = new Label("Error: Unexpected chat details format.");
                        chatMessages.getChildren().add(errorLabel);
                    }
                } catch (Exception e) {
                    // Log the exception for debugging
                    e.printStackTrace();
                    // Optionally, add a label indicating error in message processing
                    Label errorLabel = new Label("Error: Could not process message.");
                    chatMessages.getChildren().add(errorLabel);
                }
            }
        } else {
            // Handle the case where no messages are found
            Label noMessages = new Label("No messages found.");
            chatMessages.getChildren().add(noMessages);
        }

        // Set the chat messages in the ChatBox
        ChatBox.setContent(chatMessages);
        
  
    }


    private void startInfiniteLoop(String user) {
        keepRunning = true; // Reset the flag

        Thread chatUpdater = new Thread(() -> {
            while (keepRunning) {
                try {
                    populateChatBox(user); // Update the chat box
                    Thread.sleep(1000); // Wait for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        chatUpdater.setDaemon(true); // Set the thread as a daemon so it doesn't block application exit
        chatUpdater.start();
    }

    @FXML
    private void stopInfiniteLoop() {
        keepRunning = false; // Signal the loop to stop
    }
    
    @FXML
    void SendMessage(ActionEvent event) {
        // Get the message from the SendMessageBox
        String message = SendMessageBox.getText();

        if (message != null && !message.isEmpty()) {
            // Add the message with the same format
            //addMessageToChatBox("You", message);
            controllers.ChatController.insertChatMessage(message);
            populateChatBox("You");

            // Clear the text field after sending the message
            SendMessageBox.clear();

            // Scroll to the bottom of the chat box to show the latest message
            ChatBox.setVvalue(1.0);
        }
    }
    
    private void addMessageToChatBox(String sender, String content) {
        // Get the current chat messages
        VBox chatMessages = (VBox) ChatBox.getContent();

        if (chatMessages == null) {
            // Initialize VBox if it's not already set
            chatMessages = new VBox(10); // Spacing between messages
            chatMessages.setPadding(new Insets(10)); // Padding around messages
            ChatBox.setContent(chatMessages);
        }

        // Create a new styled Label for the message
        Label messageLabel = new Label(sender + ": " + content);
        messageLabel.setStyle("-fx-background-color: #e1e1e1; -fx-padding: 10; -fx-border-radius: 5; -fx-background-radius: 5;");
        messageLabel.setWrapText(true); // Enable text wrapping for long messages

        // Add some margin for spacing
        //VBox.setMargin(messageLabel, new Insets(5, 50, 5, 0)); // Right alignment with left margin

        // Add the new message to the VBox
        chatMessages.getChildren().add(messageLabel);
    }
    
    @FXML
    void gotoacceptrequest(ActionEvent event) {
    	try {
            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/selleracceptrequestscene.fxml"));
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

//    @FXML
//    void gotochats(ActionEvent event) {
//    	try {
//            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellerchatscene.fxml"));
//            Stage stage = (Stage) goback.getScene().getWindow();
//            Scene scene = new Scene(scene2Root);
//            
//            stage.setScene(scene);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    void gotocontactinfo(ActionEvent event) {
//    	try {
//    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/sellercontactinfoscene.fxml"));
//    		Parent scene2Root = loader.load();
//    		sellercontactinfoscenecontroller controller = loader.getController();
////            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellerorderactivescene.fxml"));
//            Stage stage = (Stage) goback.getScene().getWindow();
//            Scene scene = new Scene(scene2Root);
//            stage.setScene(scene);
//
//    	} catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    void gotodashboard(ActionEvent event) {
//    	try {
//            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellerdashboardscene.fxml"));
//            Stage stage = (Stage) goback.getScene().getWindow();
//            Scene scene = new Scene(scene2Root);
//            
//            stage.setScene(scene);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    void gotoearning(ActionEvent event) {
//    	try {
//            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellerearningscene.fxml"));
//            Stage stage = (Stage) goback.getScene().getWindow();
//            Scene scene = new Scene(scene2Root);
//            
//            stage.setScene(scene);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    void gotogigs(ActionEvent event) {
//    	try {
//            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellergigscene.fxml"));
//            Stage stage = (Stage) goback.getScene().getWindow();
//            Scene scene = new Scene(scene2Root);
//            
//            stage.setScene(scene);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    void gotoorder(ActionEvent event) {
//    	try {
//            Parent scene2Root = FXMLLoader.load(getClass().getResource("/application/sellerorderactivescene.fxml"));
//            Stage stage = (Stage) goback.getScene().getWindow();
//            Scene scene = new Scene(scene2Root);
//            
//            stage.setScene(scene);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
