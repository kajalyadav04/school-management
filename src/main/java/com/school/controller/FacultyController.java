package com.school.controller;

import com.school.model.Faculty;
import com.school.service.FacultyService;
import com.school.service.FacultyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    FacultyService facultyService = new FacultyServiceImpl();
    @GetMapping("/GetAllFac")
    public List<Faculty> getAllFaculty(){
        return facultyService.getAllFaculty();
    }
    @PostMapping("/createFac")
    public Faculty createFaculty(@RequestBody  Faculty faculty){
        return  facultyService.createFaculty(faculty);

    }
    @GetMapping("/getFacById/{id}")
    public  Faculty getFacultyById(@PathVariable int id) {
       return facultyService.getFacultyById(id);
    }
    @PutMapping("/update/{id}")
    public Faculty update(@PathVariable int id,@RequestBody Faculty faculty){
        return  facultyService.update(id,faculty);
    }
    @DeleteMapping("/Delete/{id}")
    public  String delete(@PathVariable int id){
        facultyService.delete(id);
        return "student deleted"+ id;
    }
}
