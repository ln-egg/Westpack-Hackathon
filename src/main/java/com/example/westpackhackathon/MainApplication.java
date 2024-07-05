package com.example.westpackhackathon;

import com.example.westpackhackathon.controller.Table;
import com.example.westpackhackathon.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class MainApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("homepage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), ApplicationInfo.WIDTH, ApplicationInfo.HEIGHT);
        stage.setTitle("Chatbot");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
