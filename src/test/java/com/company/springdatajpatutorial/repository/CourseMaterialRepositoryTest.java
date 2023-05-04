package com.company.springdatajpatutorial.repository;

import com.company.springdatajpatutorial.entity.Course;
import com.company.springdatajpatutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;


    @Test
    public void SaveCourseMaterial() {

        Course course =
                Course.builder()
                        .title("Div")
                        .credit(6)
                        .build();


        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.div.com")
                        .course(course)
                        .build();

        repository.save(courseMaterial);
    }
    @Test
    public void printAllCoursesMaterial() {
        List<CourseMaterial> courseMaterials =
                repository.findAll();

        System.out.println("courseMaterials = " + courseMaterials);

    }


}