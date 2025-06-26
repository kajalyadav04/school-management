package com.school.controller;

import com.school.model.Student;
import com.school.service.StudentServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    StudentServive service;
    @GetMapping("/getAllStudent")
    public List<Student> getstudent(){
          return service.getAllStudent();
    }

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }
    @GetMapping("/getStuById/{id}")
    public Student getStudentId(@PathVariable Integer id){
       return service.getsStudentById(id);
    }
    @PutMapping("/update/{id}")
    public Student update(@PathVariable int id, @RequestBody Student student){
        return service.updateStudent(id,student);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return service.deleteStudentById(id);
    }
    @GetMapping("searchS")
    public List<Student> seachByNameSpring(@RequestParam String name){
        return service.findByNameSpring(name);
    }
    @GetMapping("searchJ")
    public List<Student> searchByNameJpql(@RequestParam String keyword){
        return service.findBynameJpql(keyword);
    }
    @GetMapping("starts")
    public List<Student> findByName(@RequestParam String letter){
        return service.findByNameStrartWith(letter);
    }
    @PostMapping("/saveallStudent")
    public List<Student>  saveAllStudent(@RequestBody List<Student> student) {
        return service.saveAllStudent(student);
    }
    @GetMapping("/sort")
    public List<Student> sort(@RequestParam  String field, @RequestParam(defaultValue = "asc") String direction){
        return service.sortStudentData(field,direction);

    }
    @GetMapping("/findStudentInpages")
    public  List<Student> implementpaging(@RequestParam int page,@RequestParam int size){
        return service.findStudentByPage(page,size);

    }
    @GetMapping("/findStudentInpagesUsingPage")
    public Page<Student> implementPagingUsingPaging(@RequestParam int page, @RequestParam int size, @RequestParam String field, @RequestParam String direction){
        return service.findStudentByPageUsingPage(page,size,field,direction);
    }


}
