package com.test.crud.repository;

import com.test.crud.entity.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith({SpringExtension.class})
public class StudentRepositoryTest {
    @Mock
    private StudentRepository repository;

    @Test
    void testFindNameByIgnoreCase(){
        List<Student> list= List.of(new Student(Long.valueOf(1), "John", 20));
        when(repository.findByNameIgnoreCase(Mockito.anyIn())).thenReturn(list);
        assertEquals(repository.findByNameIgnoreCase("test").get(0).getName(), list.get(0).getName());
    }
}
