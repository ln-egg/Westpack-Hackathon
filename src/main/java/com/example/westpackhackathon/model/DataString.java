package com.example.westpackhackathon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataString {
    //private SqliteExpensesDAO expensesDAO;
    //private Expenses tExpense;

    //private SqliteRevenueDAO revenueDAO;
    //private Revenue tRevenue;

    static SqliteExpensesDAO expensesDAO = new SqliteExpensesDAO();
    Expenses tExpense = new Expenses(0, Expenses.Type_Expenses.Optional, "", 0);

    SqliteRevenueDAO revenueDAO = new SqliteRevenueDAO();
    Revenue tRevenue = new Revenue(0, Revenue.Type_Revenue.Transfer, "", 0);

    // this is the sample how to access the total amount of expenses
    int totalExpenses = expensesDAO.getTotalExpenses();
    //System.out.println("Total Expenses: " + totalExpenses);
    public String DisplayTotalExpenses = "Total Expenses: " + totalExpenses;
    /** this is sample how to access the total amount on different type of expenses
     *  param type: Optional, Essential, Recreational
     * */

    int optionalExpenses = expensesDAO.getTotalExpensesOnType("Optional");
    //System.out.println("Total optional Expenses: " + optionalExpenses);
    public String DisplayTotalOptionalExpenses = "Total optional Expenses: " + optionalExpenses;

    int totalRevenue = revenueDAO.getTotalRevenue();
    //System.out.println("Total Revenue: " + totalRevenue);
    public String DisplayTotalRevenue = "Total Revenue: " + totalRevenue;

    int payrollRevenue = revenueDAO.getTotalRevenueOnType("Payroll");
    //System.out.println("Total Payroll Revenue : " + payrollRevenue);
    public String DisplayPayrollRevenue = "Total Payroll Revenue : " + payrollRevenue;

    static List<Expenses> tList = expensesDAO.getExpenseRecords("Optional");



    //System.out.println(tList);

    //new Table();


}
