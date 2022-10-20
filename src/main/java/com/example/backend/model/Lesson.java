package com.example.backend.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
//@RequiredArgsConstructor
public class Lesson {
    @Id
    private Integer id;

    private String name;
    private String type;
    private LocalDate startTime;
    private LocalDate endTime;
    //private List<LocalDate> dates;
    private String classroom;
    private String teacher;
}
