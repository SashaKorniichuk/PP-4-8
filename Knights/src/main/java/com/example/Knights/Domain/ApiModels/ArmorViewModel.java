package com.example.Knights.Domain.ApiModels;

public class ArmorViewModel extends AmmunitionViewModel{

    private String name;

    private boolean ceremonial;

    private int canTakeDamage;

    private String size;

    public ArmorViewModel(long id,double price, double weight, String name, boolean ceremonial, int canTakeDamage, String size) {
        super(id,price, weight);
        this.name = name;
        this.ceremonial = ceremonial;
        this.canTakeDamage = canTakeDamage;
        this.size = size;
    }

    public ArmorViewModel() {
    }

    public String getName() {
        return name;
    }

    public boolean isCeremonial() {
        return ceremonial;
    }

    public int getCanTakeDamage() {
        return canTakeDamage;
    }

    public String getSize() {
        return size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCeremonial(boolean ceremonial) {
        this.ceremonial = ceremonial;
    }

    public void setCanTakeDamage(int canTakeDamage) {
        this.canTakeDamage = canTakeDamage;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
