package com.example.backend.repository;

import com.example.backend.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient,String> {
//    Iterable<Ingredient> findAll();
//    Optional<Ingredient> findById(String id);
//
//    Ingredient save(Ingredient ingredient);
}
