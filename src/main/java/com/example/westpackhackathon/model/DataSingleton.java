package com.example.westpackhackathon.model;

public class DataSingleton {
    private static final DataSingleton instance = new DataSingleton();

    private Expenses tExpense;
    private Revenue tRevenue;

    private DataSingleton(){}

    public static DataSingleton getInstance() { return instance; }

    public Expenses getExpense() { return tExpense; }
    public void setExpsnse(Expenses expenses) { this.tExpense = expenses; }
}
