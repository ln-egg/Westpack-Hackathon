package com.example.westpackhackathon.model;

import java.util.ArrayList;
import java.util.List;

public class ChatBot {
    private int state;
    public ChatBot() {
        state = 0;
    }
    public String Choices(int choice) {
        try {
            switch (choice) {
                case 1:
                    state = 1;
                    return ChatbotString.DisplayPlan + "\n" + ChatbotString.ListPlan + "\n" + ChatbotString.DisplayOption1 + "\n" + ChatbotString.ModifyPlanOption;
                case 2:
                    return ChatbotString.SufficientFundMessage;
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
        return "";
    }
    public void setState(int state) {
        this.state = state;
    }
    public int getState() {
        return state;
    }
}
