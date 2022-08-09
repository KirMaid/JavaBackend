package com.example.backend.controller;

import com.example.backend.model.Start;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@Controller
//@RestController
//@RequestMapping("/start")
public class StartController {
    private static final String template = "Hello,%s!";
    private final AtomicLong counter = new AtomicLong();
    //@GetMapping

    @GetMapping("/")
    public String getStartPage(){
        return "home";
    }
//    public Start getStartPage(@RequestParam(value = "name",required = false,defaultValue = "World") String name){
//        return new Start(counter.incrementAndGet(),String.format(template,name));
//    }
}
