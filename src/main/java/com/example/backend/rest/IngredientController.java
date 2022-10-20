package com.example.backend.rest;

import com.example.backend.repository.IngredientRepository;
import com.example.backend.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/ingredients",produces = "application/json")
@CrossOrigin(origins = "http:/localhost:8080")
public class IngredientController {
private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientController(IngredientRepository repo) {
        this.ingredientRepository = repo;
    }

    @GetMapping
    public Iterable<Ingredient> allIngredients(){
        return ingredientRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient saveIngredient(@RequestBody Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIngredient(@PathVariable("id") String ingredientId){
        ingredientRepository.deleteById(ingredientId);
    }
}
