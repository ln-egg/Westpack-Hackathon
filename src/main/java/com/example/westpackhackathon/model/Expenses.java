package com.example.westpackhackathon.model;




public class Expenses {
    private int ID_Expenses;
    private Type_Expenses type;
    private String Name;
    private int Amount;

    public enum Type_Expenses {
        Optional,
        Essential,
        Recreational
    }

    public Expenses(int ID_Expenses, Type_Expenses type, String Name, int Amount) {
        this.ID_Expenses = ID_Expenses;
        this.type = type;
        this.Name = Name;
        this.Amount = Amount;
    }

    public int getID_Expenses() {
        return ID_Expenses;
    }

    public void setID_Expenses(int ID_Expenses) {
        this.ID_Expenses = ID_Expenses;
    }

    public Type_Expenses getType() {
        return type;
    }

    public void setType(Type_Expenses type) {
        this.type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }
}
