package com.example.westpackhackathon.model;

public class ChatbotString {

    //----Display Start menu---
    public static String StartQuestion = "Hello [Username]! How can I help today?";
    // Dropdown button options:
    public static String StartOption = """
            --------------------------------------------------
            1. Display my current Plans
            2. Check fund sufficiency for current Plan(s)
            3. Add a new bill to your Plan
            4. Show tips and trick for budgeting
            0. Exit
            --------------------------------------------------
            """;
    // User is asked to pick one of the options
    public static String ChoicePrompt = "Enter your choice (1-4) or press 0 to exit: ";

    // When user input = 0:
    public static String ExitMessage = "Thanks for using Westpac chatbot!";

    // When user input is non-numerical or >= 4 :
    // An exception occurred: Exception e, e.getMessage()
    public static String ParseErrorMessage = "Invalid input. Please enter a valid choice (0-4).";


    // Option 1: Display Current Plans
    public static String DisplayPlan = "Here are the plans you are currently on:";
    public static String DisplayOption1 = "What would you like to do with your plan?";
    // Dropdown button options:
    public static String ModifyPlanOption = """
            1. Add Plan
            2. Remove Plan
            0. Exit Chatbot
            """;
    public String ChoicePrompt2 = "Enter your choice (1-2) or press 0 to exit: ";


    // Option 2: Check fund sufficiency for current Plan(s)
    public String DisplayCost = "For this month, you will need to pay an amount of $__.__ for your plans";
    //--If: has enough money to pay for the plans
    public static String SufficientFundMessage = "Yay!The fund in your account is sufficient to pay for this plan.";
    //--Else if: don't have enough money to pay for the plans
    public String InsufficientFundMessage = "Unfortunately, it looks like you won't have enough fund in your account!" +
            " Please check your budgeting plans and/or contact your bank for further assistance.";
    //--Else: has enough money, but will have low balance left from it
    public String LowBalanceMessage = "Good news! You have enough fund to pay for this plan. However, please note that you will have a low balance from it." +
            " Please check your budgeting plans.";


    // Option 3: Add a new bill to your Plan
    public static String AddPlanMessage = "What type of Plan do you want to add?";
    // Dropdown button options:
    public static String AddPlanOption = """
            1. Optional Plan
            2. Essential Plan
            0. Exit
            """;
    // User is asked to pick one of the options
    // USE THIS public String ChoicePrompt2 = "Enter your choice (1-2) or press 0 to exit: ";

    // User is asked to input Plan Name
    public String PlanNamePrompt = "Please input Plan's name: ";
    // User is asked to input Plan amount
    public String PlanCostPrompt = "Please input Plan's cost: ";
    // Dropdown button options:
    public String PlanFrequencyOption = """
            1. Per Week
            2. Per Month
            3. Per Year
            """;

    // Based on the Plan's cost and user's balance, provide info: can/cannot afford
    //--If: Optional Plan
    //-----If: Can Afford
    // USE THIS public String SufficientFundMessage = "Yay!The fund in your account is sufficient to pay for this plan.";
    //-----Else if: Can Afford, but will limit other spendings
    // USE THIS public String LowBalanceMessage = "Good news! You have enough fund to pay for this plan. However, please note that you will have a low balance from it." +
    //                                            " Please check your budgeting plans.";
    //-----Else if: Cannot Afford just yet
    public String InsufficientFundYetMessage = "Unfortunately, it looks like you won't have enough fund in your account just yet!" +
            " Please check your budgeting plans and/or contact your bank for further assistance.";
    //-----Else: Cannot Afford
    // USE THIS public String InsufficientFundMessage = "Unfortunately, it looks like you won't have enough fund in your account!" +
    //                                            " Please check your budgeting plans and/or contact your bank for further assistance.";

    //--Else if: Essential Plan
    //-----If: Can Afford
    // USE THIS public String SufficientFundMessage = "Yay!The fund in your account is sufficient to pay for this plan.";
    //-----Else if: Can Afford, but will limit other spendings
    // USE THIS public String LowBalanceMessage = "Good news! You have enough fund to pay for this plan. However, please note that you will have a low balance from it." +
    //                                            " Please check your budgeting plans.";
    //-----Else if: Cannot Afford just yet
    public String InsufficientFundYetMessage2 = "Unfortunately, it looks like you won't have enough fund in your account just yet!" +
            " As you are considering this an essential plan, please reduce and/or cancel subscription for one of your optional plans" +
            " Please check your budgeting plans and/or contact your bank for further assistance.";
    //-----Else: Cannot Afford
    public String InsufficientFundMessage2 = "Unfortunately, it looks like you won't have enough fund in your account!" +
            " As you are considering this an essential plan, please check your budgeting plans and/or contact your bank for further assistance.";


    // Option 4: Show tips and tricks for budgeting
    public static String TipsTrickMessage = "Here are some tips and tricks for budgeting. Please click on one of these articles and explore them!";
}


