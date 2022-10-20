package com.example.backend.controller;

import com.example.backend.model.Lesson;
import com.example.backend.helper.Helper;
import com.example.backend.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping("/lessons/upload")
    public ResponseEntity upload(@RequestParam("file") MultipartFile file){
        if (Helper.checkExcelFormat(file)){
            this.lessonService.save(file);
            return ResponseEntity.ok(Map.of("message","Success"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Excel format file");
    }

    @GetMapping("/lessons")
    public List<Lesson> getAllProduct(){
        return this.lessonService.getAllLessons();
    }
}
