package com.sainntt.coffeapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"coffee_id","ingredient_id"}))
public class RecipeElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coffee_id",nullable = false)
    private Coffee coffee;
    private long amount;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ingredient_id",nullable = false)
    private Ingredient ingredient;
}
