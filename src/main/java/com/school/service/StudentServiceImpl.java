package com.school.service;

import com.school.model.Student;
import com.school.repository.StudentDao;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentServive {
    @Autowired
    StudentDao studentDao;

    @Override
    public Student getsStudentById(int id) {

        return studentDao.findById(id).orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }

    @Override
    public List<Student> getAllStudent() {
        return studentDao.findAll();
    }

    @Override
    public Student createStudent(Student student) {

        return studentDao.save(student);
    }

    @Override
    public Student updateStudent(Integer id, Student student) {
        Optional<Student> existingStudentOpt = studentDao.findById(id);
        if (existingStudentOpt.isPresent()) {
            Student existingStudent = existingStudentOpt.get();
            existingStudent.setName(student.getName());
            existingStudent.setGrade(student.getGrade());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setGuardianName(student.getGuardianName());
            return studentDao.save(existingStudent);
        } else {
            throw new RuntimeException("Student not found with ID: " + id);
        }
    }

    @Override
    public String deleteStudentById(Integer id) {
        if (!studentDao.existsById(id)) {
            throw new RuntimeException("Student not found with ID: " + id);
        }
        studentDao.deleteById(id);
       return "deleted sucessfully: "+id;
    }

    @Override
    public List<Student> findByNameStrartWith(String letter) {
        return studentDao.findByNameStartingWith(letter);
    }

    @Override
    public List<Student> findBynameJpql(String keyword) {
        return studentDao.searchByName(keyword);
    }

    @Override
    public List<Student> findByNameSpring(String keyword) {
        return studentDao.findByNameContainingIgnoreCase(keyword);
    }
    @Override
    public  List<Student> saveAllStudent(List<Student> students){
        return studentDao.saveAll(students);
    }

    @Override
    public List<Student> sortStudentData(String field, String direction) {
        Sort sort=Sort.by(Sort.Direction.ASC,field);

        return studentDao.findAll(sort);
    }

    @Override
    public List<Student> findStudentByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return studentDao.findAll(pageable).getContent();
    }

    @Override
    public Page<Student> findStudentByPageUsingPage(int page, int size, String field, String direction) {
        Sort sort=direction.equalsIgnoreCase("asc")
                ?Sort.by(field).ascending()
                :Sort.by(field).descending();
        Pageable pageable = PageRequest.of(page,size,sort);
        return studentDao.findAll(pageable);
    }


}
