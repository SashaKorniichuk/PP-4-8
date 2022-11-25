package com.example.Knights.Domain.ApiModels;

public class HelmViewModel extends AmmunitionViewModel{


    private String name;

    private boolean closeHelm;

    private int canTakeDamage;

    private String size;

    public HelmViewModel(long id,double price, double weight, String name, boolean closeHelm, int canTakeDamage, String size) {
        super(id,price, weight);
        this.name = name;
        this.closeHelm = closeHelm;
        this.canTakeDamage = canTakeDamage;
        this.size = size;
    }

    public HelmViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCloseHelm() {
        return closeHelm;
    }

    public void setCloseHelm(boolean closeHelm) {
        this.closeHelm = closeHelm;
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
