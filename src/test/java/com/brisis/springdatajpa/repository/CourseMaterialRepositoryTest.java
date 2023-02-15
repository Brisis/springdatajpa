package com.brisis.springdatajpa.repository;

import com.brisis.springdatajpa.entity.Course;
import com.brisis.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){

        Course course = Course.builder()
                .title("CSS")
                .credit(7)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.freecodecademy.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials =
                courseMaterialRepository.findAll();

        System.out.println("Course Materials: " + courseMaterials);
    }
}