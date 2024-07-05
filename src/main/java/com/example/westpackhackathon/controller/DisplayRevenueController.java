package com.example.westpackhackathon.controller;


import com.example.westpackhackathon.ApplicationInfo;
import com.example.westpackhackathon.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DisplayRevenueController implements Initializable {

    @FXML
    private Button ChatbotButton;

    @FXML
    private Button HomeButton;
    @FXML
    private Label totalRevenueAmountLabel;


    @FXML
    void onChatbotButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ChatbotButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("chatbotpage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), ApplicationInfo.WIDTH, ApplicationInfo.HEIGHT);
        stage.setScene(scene);
    }

    @FXML
    void onHomeButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) HomeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("homepage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), ApplicationInfo.WIDTH, ApplicationInfo.HEIGHT);
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        totalRevenueAmountLabel.setText("AHOJ");
    }
}
