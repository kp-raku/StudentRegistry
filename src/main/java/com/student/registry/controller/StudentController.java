package com.student.registry.controller;

import com.student.registry.exception.StudentNotFoundException;
import com.student.registry.model.Student;
import com.student.registry.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public List<Student> getStudents() throws StudentNotFoundException {

        List<Student>studentList = studentService.getAllStudents();
        if(studentList.size() == 0)
            throw new StudentNotFoundException("Student list not found");
        return studentList;
    }

    @GetMapping("/rankList")
    public List<Student> getRankList() throws StudentNotFoundException {

        List<Student>rankList = studentService.getRank();
        if(rankList.size() == 0)
            throw new StudentNotFoundException("Student list not found");
        return rankList;

    }

    @GetMapping("/all/{id}")
    public Optional<Student> getStudentsById(@PathVariable Long id) throws StudentNotFoundException {
        Optional<Student> student = studentService.findStudent(id);
        if(!student.isPresent())
            throw new StudentNotFoundException(id + " is not present");
        return student;

    }

    @PostMapping("/add")
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        Student newStudent = studentService.newStudent(student);
        return new ResponseEntity<Student>(newStudent, HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) throws StudentNotFoundException {
        Optional<Student> student = studentService.findStudent(id);
        if(!student.isPresent())
            throw new StudentNotFoundException(id + " is not present to delete");
        return studentService.deleteById(id);

    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
       return studentService.clearDb();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateData(@RequestBody Student newStudent, @PathVariable Long id) throws StudentNotFoundException {
        Optional<Student> student = studentService.findStudent(id);
        if(!student.isPresent())
            throw new StudentNotFoundException(id + " is not present");
        Student updatedStudent = studentService.updateStudent(newStudent,id);
        return new ResponseEntity<Student>(updatedStudent,HttpStatus.CREATED);

    }
}
