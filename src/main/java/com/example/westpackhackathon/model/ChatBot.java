package com.example.westpackhackathon.model;

import java.util.ArrayList;
import java.util.List;

public class ChatBot {
    private int state;
    private SqliteRevenueDAO revenueDAO;
    private SqliteExpensesDAO expensesDAO;
    private FinancialCalculator fC;
    public ChatBot() {
        state = 0;
        fC = new FinancialCalculator();
        revenueDAO = new SqliteRevenueDAO();
        expensesDAO = new SqliteExpensesDAO();
    }
    public String Choices(int choice) {
        try {
            switch (choice) {
                case 1:
                    state = 1;
                    return ChatbotString.DisplayPlan + "\nPlans\n1. ...\n" + ChatbotString.DisplayOption1 + "\n" + ChatbotString.ModifyPlanOption;
                case 2:
                    switch(fC.budgetRuleResult()) {
                        case 0:
                            return ChatbotString.DisplayCost1 + expensesDAO.getTotalExpensesOnType("Optional") + ChatbotString.DisplayCost2 +"\n" + ChatbotString.SufficientFundMessage + "\n" + ChatbotString.StartOption + "\n" + ChatbotString.ChoicePrompt;
                        case 1:
                            return ChatbotString.DisplayCost1 + expensesDAO.getTotalExpensesOnType("Optional") + ChatbotString.DisplayCost2 +"\n" + ChatbotString.LowBalanceMessage + "\n" + ChatbotString.StartOption + "\n" + ChatbotString.ChoicePrompt;
                        case 2:
                            return ChatbotString.InsufficientFundMessage + "\n" + ChatbotString.StartOption + "\n" + ChatbotString.ChoicePrompt;
                    }
                case 3:
                    state = 3;
                    return ChatbotString.AddPlanMessage + "\n" + ChatbotString.AddPlanOption;
                case 4:
                    state = 4;
                    return ChatbotString.TipsTrickMessage;
                case 0:
                    state = -1;
                    return ChatbotString.ExitMessage + "\nEnter anything to continue.";
                default:
                    return ChatbotString.ParseErrorMessage;
            }
        } catch (Exception e) {
            return ChatbotString.ParseErrorMessage;
        }
    }
//    public DisplayPlans() {
//        List<String> list = new ArrayList<>();
//
//    }
    public String Option1(int choice){
        return "";
    }
    public String Option3(int choice){
        try {
            switch (choice) {
                case 1:
                    return "";
                case 2:
                    return "";
                case 0:
                    return "";
                default:
                    return "";
            }
        } catch (Exception e) {
            return ChatbotString.ParseErrorMessage;
        }
    }
    public void setState(int state) {
        this.state = state;
    }
    public int getState() {
        return state;
    }
}
