package com.company.springdatajpatutorial.repository;

import com.company.springdatajpatutorial.entity.Course;
import com.company.springdatajpatutorial.entity.Guardian;
import com.company.springdatajpatutorial.entity.Student;
import com.company.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;



@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses =
                courseRepository.findAll();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Serxan")
                .lastName("Resulov")
                .build();


        Course course =
                Course.builder()
                        .title("Python")
                        .credit(8)
                        .teacher(teacher)
                        .build();

        courseRepository.save(course);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Tarane")
                .lastName("Nesirova")
                .build();

        Guardian guardian = Guardian.builder()
                .name("Tamerlan")
                .email("tamerlan@gmail.com")
                .mobile("123456")
                .build();

        Student student = Student.builder()
                .firstName("Nihat")
                .emailId("nihat123@gmail.com")
                .lastName("Quliyev")
                .guardian(guardian)
                .build();


        Course course = Course.builder()
                .title("Tech")
                .credit(12)
                .teacher(teacher)
                .students(List.of(student))
                .build();

        courseRepository.save(course);
    }

}