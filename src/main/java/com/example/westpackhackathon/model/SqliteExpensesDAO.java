package com.example.westpackhackathon.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqliteExpensesDAO implements IExpensesDAO {

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
                    + "Type ENUM NOT NULL,"
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


    /* THIS IS WHERE THEY CALCULATE THE PERCENTAGES OF EACH TYPE OF EXPENSE*/
    @Override
    public double OptionalPercentage() {
        return calculatePercentage(Expenses.Type_Expenses.Optional);
    }

    @Override
    public double EssentialPercentage() {
        return calculatePercentage(Expenses.Type_Expenses.Essential);
    }

    @Override
    public double RecreationalPercentage() {
        return calculatePercentage(Expenses.Type_Expenses.Recreational);
    }

    private double calculatePercentage(Expenses.Type_Expenses type) {
        double totalAmount = getTotalAmount();
        double typeAmount = getTypeAmount(type);

        if (totalAmount == 0) {
            return 0;
        }

        return (typeAmount / totalAmount) * 100;
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        try {
            String query = "SELECT SUM(Amount) AS TotalAmount FROM expenses";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                totalAmount = resultSet.getDouble("TotalAmount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalAmount;
    }

    private double getTypeAmount(Expenses.Type_Expenses type) {
        double typeAmount = 0;
        try {
            String query = "SELECT SUM(Amount) AS TypeAmount FROM expenses WHERE Type = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, type.toString());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                typeAmount = resultSet.getDouble("TypeAmount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return typeAmount;
    }
}
