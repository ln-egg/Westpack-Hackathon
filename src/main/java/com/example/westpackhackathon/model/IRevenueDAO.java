package com.example.westpackhackathon.model;

import java.util.List;
public interface IRevenueDAO {
    public void addRevenue (Revenue revenue);
    public void removeRevenue(Revenue revenue);

    public Revenue getRevenue(String Name);
}
