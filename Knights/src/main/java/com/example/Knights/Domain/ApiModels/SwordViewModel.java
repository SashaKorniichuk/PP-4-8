package com.example.Knights.Domain.ApiModels;

public class SwordViewModel extends AmmunitionViewModel {

    private String name;

    private boolean twoHanded;

    private int damage;

    private int dmgRange;

    public SwordViewModel(long id, double price, double weight, String name, boolean twoHanded, int damage, int dmgRange) {
        super(id, price, weight);
        this.name = name;
        this.twoHanded = twoHanded;
        this.damage = damage;
        this.dmgRange = dmgRange;
    }

    public SwordViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTwoHanded() {
        return twoHanded;
    }

    public void setTwoHanded(boolean twoHanded) {
        this.twoHanded = twoHanded;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDmgRange() {
        return dmgRange;
    }

    public void setDmgRange(int dmgRange) {
        this.dmgRange = dmgRange;
    }
}
