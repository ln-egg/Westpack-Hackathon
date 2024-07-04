package com.example.westpackhackathon.controller;

import java.util.Scanner;

public class ChatbotMenuClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        DisplayMenu();
        int choice = GetUserChoice();
        PerformUserAction(choice);
    }

    public static void DisplayMenu() {
        System.out.println("Hello [Username]! How can I help today?");
        // Dropdown button options:
        System.out.println("--------------------------------------------------");
        System.out.println("1. Display my current Plans");
        System.out.println("2. Check fund sufficiency for current Plan(s)");
        System.out.println("3. Add a new bill to your Plan");
        System.out.println("4. Show tips and trick for budgeting");
        System.out.println("0. Exit");
        System.out.println("--------------------------------------------------");
        // User is asked to pick one of the options
        System.out.println("Enter your choice (1-4) or press 0 to exit: ");

    }

    public static int GetUserChoice() {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        String userInput = sc.nextLine();  // Read user input

        while (true) {
            try {
                //converting String into Integer using Integer.valueOf() method
                Integer userInputInt = Integer.valueOf(userInput);

                if (userInputInt == 0) {
                    System.out.println("Thanks for using this system!");
                    return 0;
                } else if (userInputInt >= 1 && userInputInt <= 4) {
                    return userInputInt;
                } else {
                    System.out.println();
                    System.out.println("Invalid input. Please enter a valid choice (0-4).");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Invalid input. Please enter a valid choice (0-4).");
                //TODO: Display the options/menu again, instead of exit program
            }
        }
    }

    public static void PerformUserAction(int choice) {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        try {
            switch (choice) {
                // Option 1: Display Current Plans
                case 1:
                    System.out.println("Here are the plans you are currently on:");
                    //TODO: List all of user's plans
                    System.out.println("What would you like to do?");
                    // Dropdown button options:
                    System.out.println("1. Add Plan");
                    System.out.println("2. Remove Plan");
                    System.out.println("3. Exit Chatbot");

                    // User is asked to pick one of the options
                    System.out.println("Enter your choice (1-4) or press 0 to exit: ");
                    String userOptionInput = sc.nextLine();  // Read user input

                    break;

                // Option 2: Check fund sufficiency for current Plan(s)
                case 2:
                    System.out.println("For this month, you will need to pay an amount of $__.__ for your plans");
                    //TODO: List the plan and their cost per month

                    //TODO: Complete this if-statement
                    //--If: has enough money to pay for the plans
                    System.out.println("Yay!The fund in your account is sufficient to pay for this plan.");
                    //--Else if: don't have enough money to pay for the plans
                    System.out.println("Unfortunately, it looks like you won't have enough fund in your account!");
                    System.out.println("Please check your budgeting plans and/or contact your bank for further assistance.");
                    //--Else: has enough money, but will have low balance left from it
                    System.out.println("Good news! You have enough fund to pay for this plan. However, please note that you will have a low balance from it.");
                    System.out.println("Please check your budgeting plans.");
                    break;

                // Option 3: Add a new bill to your Plan
                case 3:
                    System.out.println("What type of Plan do you want to add?");
                    // Dropdown button options:
                    System.out.println("1. Optional Plan");
                    System.out.println("2. Essential Plan");

                    // User is asked to pick one of the options
                    System.out.println("Enter your choice (1-2) or press 0 to exit: ");
                    String userPlanInput2 = sc.nextLine();  // Read user input

                    // User is asked to input
                    System.out.println("Please input Plan's name:");
                    String userPlanNameInput = sc.nextLine();  // Read user input

                    // User is asked to input
                    System.out.println("Please input Plan's cost:");
                    System.out.println("$__.__");
                    // Dropdown button options:
                    System.out.println("1. Per Week");
                    System.out.println("2. Per Month");
                    System.out.println("2. Per Year");
                    String userPlanPaymentInput = sc.nextLine();  // Read user input

                    // Based on the Plan's cost and user's balance, provide info: can/cannot afford
                    //TODO: Complete these if-statements
                    //--If: Optional Plan
                    //-----If: Can Afford
                    System.out.println("Yay!The fund in your account is sufficient to pay for this plan.");
                    //-----Else if: Can Afford, but will limit other spendings
                    System.out.println("Good news! You have enough fund to pay for this plan. However, please note that you will have a low balance from it.");
                    System.out.println("Please check your budgeting plans.");
                    //-----Else if: Cannot Afford just yet
                    System.out.println("Unfortunately, it looks like you won't have enough fund in your account just yet!");
                    System.out.println("Please check your budgeting plans and/or contact your bank for further assistance.");
                    //-----Else: Cannot Afford
                    System.out.println("Unfortunately, it looks like you won't have enough fund in your account!");
                    System.out.println("Please check your budgeting plans and/or contact your bank for further assistance.");

                    //--Else if: Essential Plan
                    //-----If: Can Afford
                    System.out.println("Yay!The fund in your account is sufficient to pay for this plan.");
                    //-----Else if: Can Afford, but will limit other spendings
                    System.out.println("Good news! You have enough fund to pay for this plan. However, please note that you will have a low balance from it.");
                    System.out.println("Please check your budgeting plans.");
                    //-----Else if: Cannot Afford just yet
                    System.out.println("Unfortunately, it looks like you won't have enough fund in your account just yet!");
                    System.out.println("As you are considering this an essential plan, please reduce and/or cancel subscription for one of your optional plans");
                    System.out.println("Please check your budgeting plans and/or contact your bank for further assistance.");
                    //-----Else: Cannot Afford
                    System.out.println("Unfortunately, it looks like you won't have enough fund in your account!");
                    System.out.println("As you are considering this an essential plan, please check your budgeting plans and/or contact your bank for further assistance.");

                    //--Else: Recreational Plan????
                    System.out.println("Good news! You have enough fund to pay for this plan. ");

                    break;

                // Option 4: Show tips and tricks for budgeting
                case 4:
                    System.out.println("Here are some tips and tricks for budgeting. Please click on one of these articles and explore them!");
                    //TODO: List of articles from website
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
    }
}


