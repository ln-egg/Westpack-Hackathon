package com.example.westpackhackathon.model;

public class Revenue {
    private int ID_Revenue;
    private Revenue.Type_Revenue type;
    private String Name;
    private int Amount;

    public enum Type_Revenue {
        Payroll,
        Transfer,
    }

    public Revenue(int ID_Revenue, Revenue.Type_Revenue type, String Name, int Amount) {
        this.ID_Revenue = ID_Revenue;
        this.type = type;
        this.Name = Name;
        this.Amount = Amount;
    }

    public int getID_Revenue() {
        return ID_Revenue;
    }

    public void setID_Revenue(int ID_Revenue) {
        this.ID_Revenue = ID_Revenue;
    }

    public Revenue.Type_Revenue getType() {
        return type;
    }

    public void setType(Revenue.Type_Revenue type) {
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
