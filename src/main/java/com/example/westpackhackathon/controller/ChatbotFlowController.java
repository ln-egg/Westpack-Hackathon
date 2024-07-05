package com.example.westpackhackathon.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import com.example.westpackhackathon.MainApplication;

import java.io.IOException;
import java.util.Scanner;

public class ChatbotFlowController {

    @FXML
    private Button sendButton;

    @FXML
    private TextField userInputField;

    @FXML
    private TextArea chatArea;

    @FXML
    private Button HomeButton;

    @FXML
    private Button ChatbotButton;

    public void initialize() {
        sendButton.setOnAction(event -> handleUserInput());
    }

    public void handleUserInput() {
        String userInput = userInputField.getText();
        chatArea.appendText("You: " + userInput + "\n");

        // Pass the user input to the ChatbotMenuClass for processing
        int userChoice = Integer.parseInt(userInput);
        performUserAction(userChoice);

        userInputField.clear();
    }

    public void performUserAction(int choice) {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        try {
            switch (choice) {
                case 1:
                    chatArea.appendText("Chatbot: Here are the plans you are currently on:\n");
                    // List all of user's plans
                    // Simulating user plans
                    chatArea.appendText("1. Basic Plan\n2. Premium Plan\n");
                    chatArea.appendText("Chatbot: What would you like to do?\n");
                    chatArea.appendText("1. Add Plan\n2. Remove Plan\n3. Exit Chatbot\n");
                    break;

                case 2:
                    chatArea.appendText("Chatbot: For this month, you will need to pay an amount of $100 for your plans\n");
                    chatArea.appendText("Chatbot: Yay! The fund in your account is sufficient to pay for this plan.\n");
                    break;

                case 3:
                    chatArea.appendText("Chatbot: What type of Plan do you want to add?\n");
                    chatArea.appendText("1. Optional Plan\n2. Essential Plan\n");
                    break;

                case 4:
                    chatArea.appendText("Chatbot: Here are some tips and tricks for budgeting. Please click on one of these articles and explore them!\n");
                    // List of articles from the website
                    chatArea.appendText("1. Article 1\n2. Article 2\n3. Article 3\n");
                    break;

                default:
                    chatArea.appendText("Chatbot: Invalid choice. Please enter a valid choice (1-4).\n");
                    break;
            }
        } catch (Exception e) {
            chatArea.appendText("Chatbot: An exception occurred: " + e.getMessage() + "\n");
        }
    }

    public void onHomeButtonClick() throws IOException {
        Stage stage = (Stage) HomeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("homepage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 740);
        stage.setScene(scene);
    }

    public void onChatbotButtonClick() throws IOException {
        Stage stage = (Stage) ChatbotButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("chatbotpage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 740);
        stage.setScene(scene);
    }
}
