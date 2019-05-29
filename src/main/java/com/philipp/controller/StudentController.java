package com.philipp.controller;

import com.philipp.entity.Student;
import com.philipp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @CrossOrigin(origins = "http://localhost:5555")
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){
        return this.studentService.getAllStudents();
    }

    @CrossOrigin(origins = "http://localhost:5555")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id){
        return this.studentService.getStudentById(id);
    }

    @CrossOrigin(origins = "http://localhost:5555")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void removeStudentById(@PathVariable("id") int id){
        this.studentService.removeStudentById(id);
    }

    @CrossOrigin(origins = "http://localhost:5555")
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody  Student student){
        this.studentService.updateStudent(student);
    }

    @CrossOrigin(origins = "http://localhost:5555")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody  Student student){
        this.studentService.insertStudent(student);
    }
}
