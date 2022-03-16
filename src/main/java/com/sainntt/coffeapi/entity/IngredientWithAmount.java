package com.sainntt.coffeapi.entity;

import javax.persistence.*;

@Entity
public class IngredientWithAmount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Coffee coffee;
    private long amount;
    @OneToOne(fetch = FetchType.EAGER)
    private Ingredient ingredient;
}
