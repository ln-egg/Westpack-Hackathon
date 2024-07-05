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

    public boolean budgetRuleResult()
    {
        /* create a method to determine whether the revenue and expenses of the user follows the 50/30/20 budget rule
        * note that 100% = revenue, 50% = needs percentage, 30% = wants percentage, 20% = savings percentage
        * note that if they follow the budget rule return "You follow the budget rule"
        * if they do not follow the budget rule return "You do not follow the budget"
        * if they are just under the budget rule (so within 10% of either categories) return "You are close to reaching the budget rules"*/
    }
}
