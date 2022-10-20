package com.example.backend;

//import com.example.backend.entities.Cat;
//import com.example.backend.entities.Dog;
//import com.example.backend.entities.Parrot;
import com.example.backend.repository.IngredientRepository;
import com.example.backend.repository.ShawarmaRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.model.Ingredient;
import com.example.backend.model.Shawarma;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class JavaBackendApplication {

	//ApplicationContext context = new AnnotationConfigApplicationContext("entities");
	//Cat cat = context.getBean(Cat.class);
	//Dog dog = (Dog)context.getBean("dog");
	//Parrot parrot = context.getBean("parrot-kesha",Parrot.class);
	public static void main(String[] args) {
		SpringApplication.run(JavaBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(IngredientRepository repo, UserRepository userRepository, PasswordEncoder passwordEncoder, ShawarmaRepository shawarmaRepository){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				Ingredient flourTortilla = new Ingredient(
						"FLTO", "Flour Tortilla", Ingredient.Type.WRAP);
				Ingredient cornTortilla = new Ingredient(
						"COTO", "Corn Tortilla", Ingredient.Type.WRAP);
				Ingredient groundBeef = new Ingredient(
						"GRBF", "Ground Beef", Ingredient.Type.PROTEIN);
				Ingredient carnitas = new Ingredient(
						"CARN", "Carnitas", Ingredient.Type.PROTEIN);
				Ingredient tomatoes = new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES);
				Ingredient lettuce = new Ingredient(
						"LETC", "Lettuce", Ingredient.Type.VEGGIES);
				Ingredient cheddar = new Ingredient(
						"CHED", "Cheddar", Ingredient.Type.CHEESE);
				Ingredient jack = new Ingredient(
						"JACK", "Monterrey Jack", Ingredient.Type.CHEESE);
				Ingredient salsa = new Ingredient(
						"SLSA", "Salsa", Ingredient.Type.SAUCE);
				Ingredient sourCream = new Ingredient(
						"SRCR", "Sour Cream", Ingredient.Type.SAUCE);
				repo.save(flourTortilla);
				repo.save(cornTortilla);
				repo.save(groundBeef);
				repo.save(carnitas);
				repo.save(tomatoes);
				repo.save(lettuce);
				repo.save(cheddar);
				repo.save(jack);
				repo.save(salsa);
				repo.save(sourCream);
//				repo.save(new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP));
//				repo.save(new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP));
//				repo.save(new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN));
//				repo.save(new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN));
//				repo.save(new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES));
//				repo.save(new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES));
//				repo.save(new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
//				repo.save(new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE));
//				repo.save(new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE));
//				repo.save(new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));


				Shawarma shawarma1 = new Shawarma("Carnivore",Arrays.asList(
						flourTortilla, groundBeef, carnitas,
						sourCream, salsa, cheddar));
				shawarma1.setName("Carnivore");
				shawarma1.setIngredients(Arrays.asList(
						flourTortilla, groundBeef, carnitas,
						sourCream, salsa, cheddar));
				shawarmaRepository.save(shawarma1);


				Shawarma shawarma2 = new Shawarma();
				shawarma2.setName("Bovine Bounty");
				shawarma2.setIngredients(Arrays.asList(
						cornTortilla, groundBeef, cheddar,
						jack, sourCream));
				shawarmaRepository.save(shawarma2);
			}
		};
	}

}
