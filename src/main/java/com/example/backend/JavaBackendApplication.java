package com.example.backend;

//import com.example.backend.entities.Cat;
//import com.example.backend.entities.Dog;
//import com.example.backend.entities.Parrot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

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

}
