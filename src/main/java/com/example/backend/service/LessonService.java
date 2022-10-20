package com.example.backend.service;

import com.example.backend.repository.LessonRepository;
import com.example.backend.model.Lesson;
import com.example.backend.helper.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;
    public void save(MultipartFile file){
        try {
            List<Lesson> lessons = Helper.getAllLessons(file.getInputStream());
            this.lessonRepository.saveAll(lessons);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Lesson> getAllLessons(){
        return this.lessonRepository.findAll();
    }
}
