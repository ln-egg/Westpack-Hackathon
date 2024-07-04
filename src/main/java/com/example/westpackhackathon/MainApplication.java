package com.example.westpackhackathon;

import com.example.westpackhackathon.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class MainApplication extends Application {

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

        // this is the sample how to access the total amount of expenses
        int totalExpenses = expensesDAO.getTotalExpenses();
        System.out.println("Total Expenses: " + totalExpenses);
        /** this is sample how to access the total amount on different type of expenses
         *  param type: Optional, Essential, Recreational
         * */
        int optionalExpenses = expensesDAO.getTotalExpensesOnType("Optional");
        System.out.println("Total optional Expenses: " + optionalExpenses);

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
