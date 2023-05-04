package com.company.springdatajpatutorial.repository;

import com.company.springdatajpatutorial.entity.Course;
import com.company.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void saveTeacher() {

        Course courseJava =
                Course.builder()
                        .title("Java")
                        .credit(5)
                        .build();

        Course courseJavaScript =
                Course.builder()
                        .title("JavaScript")
                        .credit(3)
                        .build();


        Teacher teacher =
                Teacher.builder()
                        .firstName("Farid")
                        .lastName("Tahmazov")
                        //.courses(List.of(courseJava,courseJavaScript))
                        .build();

        teacherRepository.save(teacher);

    }



}