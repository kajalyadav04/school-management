package com.school.repository;

import com.school.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyDao extends JpaRepository<Faculty,Integer> {

}
