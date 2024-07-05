package com.example.westpackhackathon.model;

import java.util.Scanner;

public class ChatBot {
    public String Choices(int choice) {
        try {
            switch (choice) {
                case 1:
                    return ChatbotString.DisplayPlan + "\nPlans\n1. ...\n" + ChatbotString.DisplayOption1 + "\n" + ChatbotString.ModifyPlanOption;

                case 2:
                    return ChatbotString.SufficientFundMessage;

                case 3:
                    return ChatbotString.AddPlanMessage + "\n" + ChatbotString.AddPlanOption;

                case 4:
                    return ChatbotString.TipsTrickMessage;
                case 0:
                    return ChatbotString.ExitMessage;
                default:
                    return ChatbotString.ParseErrorMessage;
            }
        } catch (Exception e) {
            return ChatbotString.ParseErrorMessage;
        }
    }
}
