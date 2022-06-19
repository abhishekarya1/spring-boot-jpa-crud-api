package com.test.crud.controlller;

import com.test.crud.entity.Student;
import com.test.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CacheConfig(cacheNames = "student")
public class CrudController {

    @Autowired
    private StudentService service;

    @Cacheable
    @GetMapping("/all")
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @Cacheable
    @GetMapping("/{name}")
    public List<Student> getByName(@PathVariable String name) {
        return service.getStudentsByName(name);
    }

    @CachePut
    @PostMapping("/add")
    public Student addStudentRecord(@RequestBody Student s) throws SQLException {
        return service.addStudent(s);
    }

    @CachePut
    @PutMapping("/update")
    public String updateStudent(@RequestParam Long id, @RequestBody Student s){
        service.updateStudent(id, s);
        return "Deleted Successfully!";
    }

    @CacheEvict(allEntries = true)
    @DeleteMapping("/delete")
    public String removeStudent(@RequestParam(required=false) Long id){
        service.removeStudent(id);
        return "Deleted Successfully!";
    }
}
