package com.sainntt.coffeapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class RecipeElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Coffee coffee;
    private long amount;
    @OneToOne(fetch = FetchType.EAGER)
    private Ingredient ingredient;
}
