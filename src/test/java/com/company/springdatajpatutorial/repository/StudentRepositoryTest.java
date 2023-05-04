package com.company.springdatajpatutorial.repository;

import com.company.springdatajpatutorial.entity.Guardian;
import com.company.springdatajpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("nihatguliyev57@gmail.com")
                .firstName("Nihat")
                .lastName("Guliyev")
                .build();
        studentRepository.save(student);

    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("Fuad1@gmail.com")
                .name("Fuad")
                .mobile("5555555")
                .build();

        Student student  = Student.builder()
                .firstName("Nihat")
                .emailId("nihat@gmail.com")
                .lastName("Huseynli")
                .guardian(guardian)
                .build();
    studentRepository.save(student);
    }


    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);

    }

    @Test
    public void printStudentByFirstName(){

        List<Student> students =
                studentRepository.findByFirstName("Nihat");

        System.out.println("student = " +  students);
    }

    @Test
    public void printStudentByFirstNameContaining(){

        List<Student> students =
                studentRepository.findByFirstNameContaining("E");

        System.out.println("student = " +  students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){

        List<Student> students =
                studentRepository.findByGuardianName("Faiq");
        System.out.println("students = " + students);

    }

    @Test
    public void printGetStudentByEmailAddress(){
        Student student =
                studentRepository.getStudentByEmailAddress("nihatguliyev7557@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress() {
        String firstname =
                studentRepository.getStudentFirstNameByEmailAddress("nihatguliyev7557@gmail.com");

        System.out.println("Student First Name : " + firstname);

    }

    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative("nihatguliyev7557@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam(){
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam("nihatguliyev7557@gmail.com");

        System.out.println("Student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId(
                "Niko",
                "nihatguliyev7557@gmail.com"
        );
    }
}