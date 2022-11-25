package com.example.Knights.Domain.ApiModels;

public abstract class AmmunitionViewModel {

    private long ammunitionId;
    private double price;

    private double weight;

    public AmmunitionViewModel(long id,double price, double weight) {
        this.ammunitionId=id;
        this.price = price;
        this.weight = weight;
    }

    public AmmunitionViewModel() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public long getAmmunitionId() {
        return ammunitionId;
    }

    public void setAmmunitionId(long ammunitionId) {
        this.ammunitionId = ammunitionId;
    }
}

