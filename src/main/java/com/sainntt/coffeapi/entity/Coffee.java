package com.sainntt.coffeapi.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "coffee"
    )
    private List<IngredientWithAmount> ingredients;
}
