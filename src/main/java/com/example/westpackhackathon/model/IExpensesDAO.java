package com.example.westpackhackathon.model;

public interface IExpensesDAO {
    public void addExpenses (Expenses expenses);
    public void removeExpenses (Expenses expenses);

    public Expenses getExpenses (String Name);

    public int getTotalExpenses();

    public int getTotalExpensesOnType(String type);
}
