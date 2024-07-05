package com.example.westpackhackathon.model;

import java.util.List;
public interface IExpensesDAO {
    public void addExpenses (Expenses expenses);
    public void removeExpenses (Expenses expenses);

    public Expenses getExpenses (String Name);

    double OptionalPercentage();

    double EssentialPercentage();

    double RecreationalPercentage();
}
