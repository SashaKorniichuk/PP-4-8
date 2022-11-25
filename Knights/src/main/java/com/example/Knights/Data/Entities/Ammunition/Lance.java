package com.example.Knights.Data.Entities.Ammunition;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

@Entity
@Table(name = "lance")
public class Lance extends Ammunition {
    @Column(nullable=false)
    private String name = "NoName";
    @Column(nullable=false)
    private int length;
    @Column(nullable=false)
    private int damage;
    @Column(nullable=false)
    private int dmgRange;

    public Lance(String name,int length, int damage,int dmgRange, double price, double weight) {
        super(price, weight);
        this.name=name;
        this.length = length;
        this.damage = damage;
        this.dmgRange=dmgRange;
    }

    public Lance() {

    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
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

    public void setLength(int length) {
        this.length = length;
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
        return "\n" + "#Lance." + noname + "It can inflict " + damage
                + " damage. Length: " + length + ". " + super.toString();

    }
}
