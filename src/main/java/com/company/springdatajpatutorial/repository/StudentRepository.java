package com.company.springdatajpatutorial.repository;

import com.company.springdatajpatutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;



@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByFirstName(String firstName);


    List<Student> findByFirstNameContaining(String name);


    List<Student> findByGuardianName(String guardianName);


    /***  JPQL  ***/
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String EmailId);

    /***  JPQL  ***/
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String EmailId);


    /***  Native  ***/
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);


    /***  Native Named Param  ***/
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(
            @Param("emailId") String emailId
    );

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_student SET first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )

    int updateStudentNameByEmailId(String firstName , String emailId);





}
