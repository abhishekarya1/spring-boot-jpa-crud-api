package com.test.crud.service;

import com.test.crud.entity.Student;
import com.test.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByNameIgnoreCase(name);
    }

    public Student addStudent(Student s) {
        return studentRepository.save(s);
    }

    public void removeStudent(Long id) {
       try {
           studentRepository.deleteById(id);
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }

    public void updateStudent(Long id, Student s) {
        Student sdb = studentRepository.findById(id).get();
        sdb.setName(s.getName());
        sdb.setAge(s.getAge());
        studentRepository.save(sdb);
    }
}
