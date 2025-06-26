package com.school.service;

import com.school.exception.InvalidIdException;
import com.school.model.Faculty;
import com.school.repository.FacultyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyDao facultyDao;
    @Override
    public Faculty createFaculty(Faculty faculty) {
       return facultyDao.save(faculty);

    }

    @Override
    public String delete(int id) {
        if(!facultyDao.existsById(id)) {
            throw new InvalidIdException( "faculty not exist");
        }
        facultyDao.deleteById(id);
        return "faculty deleted: "+ id;
    }

    @Override
    public Faculty update(int id, Faculty faculty) {
       Optional<Faculty> existingFacultyOpt= facultyDao.findById(id);
       if(existingFacultyOpt.isPresent()){
         Faculty  existingFaculty =existingFacultyOpt.get();
         existingFaculty.setDepartment(faculty.getDepartment());
         existingFaculty.setName(faculty.getName());
         existingFaculty.setEmail(faculty.getName());
         existingFaculty.setPhone(faculty.getPhone());
           return facultyDao.save(existingFaculty);
       }
       else{
           throw new InvalidIdException("Faculty not Found"+ +id);
       }


    }

    @Override
    public List<Faculty> getAllFaculty() {
        return facultyDao.findAll();
    }

    @Override
    public Faculty getFacultyById(int id) {
        return facultyDao.findById(id).orElseThrow(()-> new InvalidIdException("faculty id not found:"+ id));
    }
}
