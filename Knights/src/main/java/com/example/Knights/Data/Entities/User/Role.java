package com.example.Knights.Data.Entities.User;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role() {
        users = new ArrayList<User>();
    }

    public Role(String name) {
        this.name = name;
        users = new ArrayList<User>();
    }

    public Role(String name, List<User> users) {
        this.name = name;
        this.users = new ArrayList<>(users);
    }
}
