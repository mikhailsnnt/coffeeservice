package com.sainntt.coffeapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "coffee"
    )
    private List<RecipeElement> ingredients;
}
