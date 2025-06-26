package com.school.repository;

import com.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, Integer> {
    // Find students whose name starts with a specific letter

    List<Student> findByNameStartingWith(String prefix);

    // Find students containing a keyword in their name (
    List<Student> findByNameContainingIgnoreCase(String keyword);

    // Custom JPQL Query to search for students dynamically
    @Query("SELECT s FROM Student s WHERE LOWER(s.name) LIKE LOWER(CONCAT(:keyword,'%'))")
    List<Student> searchByName(@Param("keyword") String keyword);
}
