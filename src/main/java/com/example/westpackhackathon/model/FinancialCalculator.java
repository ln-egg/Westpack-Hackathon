package com.example.westpackhackathon.model;

public class FinancialCalculator {
    private SqliteRevenueDAO revenueDAO;
    private SqliteExpensesDAO expensesDAO;

    public FinancialCalculator() {
        revenueDAO = new SqliteRevenueDAO();
        expensesDAO = new SqliteExpensesDAO();
    }

    public double calculateProfit() {
        double totalRevenue = revenueDAO.getTotalRevenue();
        double totalExpenses = expensesDAO.getTotalExpenses();
        return totalRevenue - totalExpenses;
    }

    public double calculateWantsPercentage() {
        double totalOptional = expensesDAO.getTotalExpensesOnType("Optional");
        double totalRecreational = expensesDAO.getTotalExpensesOnType("Recreational");

        return totalOptional + totalRecreational;
    }

    public double calculateNeedsPercentage() {
        double totalEssential = expensesDAO.getTotalExpensesOnType("Essential");
        return totalEssential;
    }

    public double calculateSavingsPercentage() {
        double totalRevenue = revenueDAO.getTotalRevenue();
        double totalExpenses = expensesDAO.getTotalExpenses();
        return (totalRevenue - totalExpenses) / totalRevenue * 100;
    }

    public int budgetRuleResult() {
        double wantsPercentage = calculateWantsPercentage();
        double needsPercentage = calculateNeedsPercentage();
        double savingsPercentage = calculateSavingsPercentage();

        boolean followsRule = (needsPercentage == 50) && (wantsPercentage == 30) && (savingsPercentage == 20);
        boolean closeToRule = (Math.abs(needsPercentage - 50) <= 10) && (Math.abs(wantsPercentage - 30) <= 10) && (Math.abs(savingsPercentage - 20) <= 10);

        /* CHANGE THIS ACCORDING TO THE DIALOGUE*/
        if (followsRule) {
            return 0; //"You follow the budget rule";
        } else if (closeToRule) {
            return 1;//"You are close to reaching the budget rules";
        } else {
            return 2;//"You do not follow the budget rule";
        }
    }
}
