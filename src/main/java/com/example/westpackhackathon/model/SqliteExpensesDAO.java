package com.example.westpackhackathon.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqliteExpensesDAO implements IExpensesDAO {

    public int totalExpense;
    private Connection connection;

    public SqliteExpensesDAO() {
        connection = SqliteConnection.getInstance();
        createTable();
    }

    private void createTable() {
        try {
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS expenses ("
                    + "ID_Expenses INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "Type VARCHAR NOT NULL,"
                    + "Name VARCHAR NOT NULL,"
                    + "Amount INTEGER NOT NULL"
                    + ")";
            statement.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addExpenses(Expenses expenses) {
        try {
            String query = "INSERT INTO expenses (ID_Expenses, Type, Name, Amount) VALUES (null, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, expenses.getType().toString());
            statement.setString(2, expenses.getName());
            statement.setInt(3, expenses.getAmount());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeExpenses(Expenses expenses) {
        try {
            String query = "DELETE FROM expenses WHERE ID_Expenses = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, expenses.getID_Expenses());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Expenses getExpenses(String name) {
        try {
            String query = "SELECT * FROM expenses WHERE Name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("ID_Expenses");
                Expenses.Type_Expenses type = Expenses.Type_Expenses.valueOf(resultSet.getString("Type"));
                String expenseName = resultSet.getString("Name");
                int amount = resultSet.getInt("Amount");
                Expenses expenses = new Expenses(id, type, expenseName, amount);
                return expenses;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /** This to get the total amount of expenses*/
    @Override
    public int getTotalExpenses() {
        int totalExpenseResult = 0;
        try {
            String query = "SELECT SUM(Amount) as Total FROM expenses";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                totalExpenseResult = resultSet.getInt("Total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalExpenseResult;
    }

    /** This to get the total amount of each type of expenses*/
    @Override
    public int getTotalExpensesOnType(String type) {
        int totalExpenseOnTypeResult = 0;
        try {
            String query = "SELECT SUM(Amount) as Total FROM expenses WHERE Type = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, type);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                totalExpenseOnTypeResult = resultSet.getInt("Total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalExpenseOnTypeResult;
    }

}
