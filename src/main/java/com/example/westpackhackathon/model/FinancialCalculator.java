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
}
