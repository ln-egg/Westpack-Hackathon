package com.example.westpackhackathon.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class SqliteRevenueDAO implements IRevenueDAO {

    private Connection connection;

    public SqliteRevenueDAO()
    {
        connection = SqliteConnection.getInstance();
        createTable();
    }

    private void createTable() {
        try {
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS revenue ("
                    + "ID_Revenue INTEGER PRIMARY KEY AUTOINCREMENT,"
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
    public void addRevenue(Revenue revenue) {
        try {
            String query = "INSERT INTO revenue (ID_Revenue, Type, Name, Amount) VALUES (null, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, revenue.getType().toString());
            statement.setString(2, revenue.getName());
            statement.setInt(3, revenue.getAmount());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeRevenue(Revenue revenue) {
        try {
            String query = "DELETE FROM revenue WHERE ID_Revenue = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, revenue.getID_Revenue());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Revenue getRevenue(String Name) {
        try {
            String query = "SELECT * FROM revenue WHERE Name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, Name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("ID_Revenue");
                Revenue.Type_Revenue type = Revenue.Type_Revenue.valueOf(resultSet.getString("Type"));
                String revenueName = resultSet.getString("Name");
                int amount = resultSet.getInt("Amount");
                Revenue revenue = new Revenue(id, type, revenueName, amount);
                return revenue;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /** This to get the total amount of revenue*/
    @Override
    public int getTotalRevenue() {
        int totalRevenueResult = 0;
        try {
            String query = "SELECT SUM(Amount) as Total FROM revenue";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                totalRevenueResult = resultSet.getInt("Total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalRevenueResult;
    }

    @Override
    public int getTotalRevenueOnType(String type) {
        int totalRevenueOnTypeResult = 0;
        try {
            String query = "SELECT SUM(Amount) as Total FROM Revenue WHERE Type = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, type);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                totalRevenueOnTypeResult = resultSet.getInt("Total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalRevenueOnTypeResult;
    }
}
