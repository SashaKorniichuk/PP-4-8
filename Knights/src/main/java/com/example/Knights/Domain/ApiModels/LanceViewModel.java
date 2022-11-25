package com.example.Knights.Domain.ApiModels;

public class LanceViewModel extends AmmunitionViewModel {

    private String name;

    private int length;

    private int damage;

    private int dmgRange;

    public LanceViewModel(long id, double price, double weight, String name, int length, int damage, int dmgRange) {
        super(id, price, weight);
        this.name = name;
        this.length = length;
        this.damage = damage;
        this.dmgRange = dmgRange;
    }

    public LanceViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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
