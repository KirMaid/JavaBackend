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
public class DateLesson {
    @Id
    private Integer id;
    private LocalDate startTime;
    private LocalDate endTime;
    private String DayOfWeek;
}
