package com.company.springdatajpatutorial.repository;

import com.company.springdatajpatutorial.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends   JpaRepository<CourseMaterial,Long> {

}
