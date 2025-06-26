package com.school.service;

import com.school.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentServive {
    public Student getsStudentById(int id);
    public List<Student> getAllStudent();
    public Student createStudent(Student student);
    public Student updateStudent(Integer id, Student student);
    public String deleteStudentById(Integer id);
    public  List<Student> findByNameStrartWith(String letter);
    public List<Student> findBynameJpql(String keyword);
    public List<Student> findByNameSpring(String keyword);
    public List<Student> saveAllStudent(List<Student> student);
    public List<Student>  sortStudentData(String string,String direction);
    public List<Student> findStudentByPage(int page,int size);
    public Page<Student> findStudentByPageUsingPage(int page, int size, String field, String direction);

}
