package com.school.service;

import com.school.model.Faculty;

import java.util.List;

public interface FacultyService {
    public Faculty createFaculty(Faculty faculty);
    public String delete(int id);
    public Faculty update(int id,Faculty faculty);
    public List<Faculty> getAllFaculty();
    public Faculty getFacultyById(int id);

}
