package com.spring.security.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController
{

    private static final List<Student> students = Arrays.asList(
            new Student(1,"hari bahadur"),
            new Student(2, "ram Bahadur"),
            new Student(3, "Kari Bahadur")
    );

    @GetMapping
    public List<Student> getAllStudents()
    {
        return students;
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student)
    {
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentID)
    {
        System.out.println(studentID);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(Integer studentId, Student student)
    {
        System.out.println(String.format("%s %s", studentId, student));
    }
}
