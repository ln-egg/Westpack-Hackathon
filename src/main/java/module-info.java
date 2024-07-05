module com.example.westpackhackathon {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.westpackhackathon to javafx.fxml;
    exports com.example.westpackhackathon;
    exports com.example.westpackhackathon.controller;
    opens com.example.westpackhackathon.controller to javafx.fxml;
    exports com.example.westpackhackathon.model;
    opens com.example.westpackhackathon.model to javafx.fxml;
}