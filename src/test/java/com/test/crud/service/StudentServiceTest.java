package com.test.crud.service;

import com.test.crud.entity.Student;
import com.test.crud.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository repository;

    @InjectMocks
    private StudentService service;

    @Test
    void testGetAllStudents(){
        List<Student> list = List.of(new Student(1L, "John", 3));
        when(repository.findAll()).thenReturn(list);
        List<Student> listOp = service.getAllStudents();
        assertEquals("John", listOp.get(0).getName());
    }
}
