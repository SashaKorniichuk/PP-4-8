package com.example.Knights.Domain.ApiModels;

public class ShieldViewModel extends AmmunitionViewModel{


    private String name;

    private int canTakeDamage;

    private String size;

    public ShieldViewModel(long id, double price, double weight, String name, int canTakeDamage, String size) {
        super(id, price, weight);
        this.name = name;
        this.canTakeDamage = canTakeDamage;
        this.size = size;
    }

    public ShieldViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCanTakeDamage() {
        return canTakeDamage;
    }

    public void setCanTakeDamage(int canTakeDamage) {
        this.canTakeDamage = canTakeDamage;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
