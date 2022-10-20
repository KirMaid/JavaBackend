package com.example.backend.controller;
import com.example.backend.repository.IngredientRepository;
import com.example.backend.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("shawarmaOrder")
public class DesignShawarmaController {
    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignShawarmaController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {

        Iterable<Ingredient> ingredients = ingredientRepo.findAll();
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type:types){
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType((List<Ingredient>) ingredients, type));
        }

//        List<Ingredient> ingredients = Arrays.asList(
//                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
//                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
//                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
//                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
//                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
//                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
//                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
//                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
//                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
//                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
//        );

    }
    @ModelAttribute(name = "shawarmaOrder")
    public ShawarmaOrder order(){
        return new ShawarmaOrder();
    }
    @ModelAttribute(name = "shawarma")
    public Shawarma shawarma(){
        return new Shawarma();
    }
    @GetMapping
    public String showDesignForm(){
        return "design";
    }
    @PostMapping
    public String processShawarma(@Valid Shawarma shawarma, Errors errors, @ModelAttribute ShawarmaOrder shawarmaOrder){
        if (errors.hasErrors()){
            return "design";
        }
        shawarmaOrder.addShawarma(shawarma);
        log.info("Processing shawarma: {}", shawarma);
        return  "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type){
        return ingredients
                .stream()
                .filter(x-> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
