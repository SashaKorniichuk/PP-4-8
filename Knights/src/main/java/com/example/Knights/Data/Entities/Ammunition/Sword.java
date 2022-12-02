package com.example.Knights.Data.Entities.Ammunition;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;


import javax.persistence.*;

@Entity
@Table(name = "sword")
public class Sword extends Ammunition {

    @Column(nullable=false)
    private String name = "NoName";
    @Column(nullable=false)
    private  boolean twoHanded;
    @Column(nullable=false)
    private int damage;
    @Column(nullable=false)
    private int dmgRange;

    public Sword(String name,boolean twoHanded, int damage, int dmgRange, double price, double weight) {
        super(price, weight);
        this.name=name;
        this.twoHanded = twoHanded;
        this.damage = damage;
        this.dmgRange=dmgRange;
    }

    public Sword() {

    }

    public String getName() {
        return name;
    }

    public boolean isTwoHanded() {
        return twoHanded;
    }

    public int getDamage() {
        return damage;
    }

    public int getDmgRange() {
        return dmgRange;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTwoHanded(boolean twoHanded) {
        this.twoHanded = twoHanded;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setDmgRange(int dmgRange) {
        this.dmgRange = dmgRange;
    }


    @Override
    public String toString() {
        String noname = "";
        if (!name.equals("NoName")) {
            noname = "Name: " + name + ". ";
        }
        String swordType = twoHanded ? "two-handed" : "single-handed";
        return "\n" + "#Sword." + noname + "It`s " + swordType + " sword"
                + ". It can take " + damage + " damage. " + super.toString();

    }
}
