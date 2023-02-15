package com.brisis.springdatajpa.repository;

import com.brisis.springdatajpa.entity.Course;
import com.brisis.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseDBA = Course.builder()
                .title("Advanced Database")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(7)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Pharaoh")
                .lastName("Chaka")
                .courses(List.of(courseDBA, courseJava))
                .build();

        teacherRepository.save(teacher);
    }
}