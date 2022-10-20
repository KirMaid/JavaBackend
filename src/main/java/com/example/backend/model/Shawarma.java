package com.example.backend.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
//@RequiredArgsConstructor
@NoArgsConstructor(access= AccessLevel.PUBLIC, force=true)
public class Shawarma {

    public Shawarma(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt = new Date();

    //@NotNull
    @Size(min = 5,message = "Name must be at least 5 characters long")
    private String name;
    @NotNull
    @ManyToMany(targetEntity=Ingredient.class)
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

//    public Shawarma(String name, List<Ingredient> ingredients) {
//        this.name = name;
//        this.ingredients = ingredients;
//    }
}
