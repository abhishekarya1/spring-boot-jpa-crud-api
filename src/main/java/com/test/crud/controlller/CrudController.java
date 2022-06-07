package com.test.crud.controlller;

import com.test.crud.entity.Student;
import com.test.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CrudController {

    @Autowired
    private StudentService service;

    @GetMapping("/all")
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @GetMapping("/{name}")
    public List<Student> getByName(@PathVariable String name) {
        return service.getStudentsByName(name);
    }

    @PostMapping("/add")
    public Student addStudentRecord(@RequestBody Student s){
        return service.addStudent(s);
    }

    @PutMapping("/update")
    public String updateStudent(@RequestParam Long id, @RequestBody Student s){
        service.updateStudent(id, s);
        return "Deleted Successfully!";
    }

    @DeleteMapping("/delete")
    public String removeStudent(@RequestParam(required=false) Long id){
        service.removeStudent(id);
        return "Deleted Successfully!";
    }
}
