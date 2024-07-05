package com.example.westpackhackathon;

import com.example.westpackhackathon.model.Expenses;
import com.example.westpackhackathon.model.Revenue;
import com.example.westpackhackathon.model.SqliteExpensesDAO;
import com.example.westpackhackathon.model.SqliteRevenueDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    public static final int WIDTH = 350;
    public static final int HEIGHT = 740;

    private SqliteExpensesDAO expensesDAO;
    private Expenses tExpense;

    private SqliteRevenueDAO revenueDAO;
    private Revenue tRevenue;

    @Override
    public void start(Stage stage) throws IOException {
        expensesDAO = new SqliteExpensesDAO();
        tExpense = new Expenses(0, Expenses.Type_Expenses.Optional, "", 0);

        revenueDAO = new SqliteRevenueDAO();
        tRevenue = new Revenue(0, Revenue.Type_Revenue.Transfer, "", 0);

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("homepage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);
        stage.setTitle("Chatbot");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
