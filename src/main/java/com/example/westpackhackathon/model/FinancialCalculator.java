package com.example.westpackhackathon.model;

public class FinancialCalculator {
    private SqliteRevenueDAO revenueDAO;
    private SqliteExpensesDAO expensesDAO;

    public FinancialCalculator(SqliteRevenueDAO revenueDAO, SqliteExpensesDAO expensesDAO) {
        this.revenueDAO = revenueDAO;
        this.expensesDAO = expensesDAO;
    }

    public double calculateProfit() {
        double totalRevenue = revenueDAO.getTotalRevenue();
        double totalExpenses = expensesDAO.getTotalAmount();
        return totalRevenue - totalExpenses;
    }



    /* THIS IS WHERE YOU WILL DETERMINE WHETHER THEIR FINANCIAL STANDING FOLLOWS THE 50/30/20 BUDGET RULE */

    public double calculateWantsPercentage()
    {
        double totalOptional = expensesDAO.OptionalPercentage();
        double totalRecreational = expensesDAO.RecreationalPercentage();

        return totalOptional + totalRecreational;
    }

    public double calculateNeedsPercentage()
    {
        double totalEssential = expensesDAO.EssentialPercentage();
        return totalEssential;
    }

    public double calculateSavingsPercentage()
    {
        double totalRevenue = revenueDAO.getTotalRevenue();
        double totalExpenses = expensesDAO.getTotalAmount();
        return totalRevenue - totalExpenses;
    }
}
