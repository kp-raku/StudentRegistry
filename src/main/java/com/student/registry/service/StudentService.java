package com.student.registry.service;

import com.student.registry.model.Student;
import com.student.registry.repository.StudentRepository;
import com.student.registry.utils.StudentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentUtils studentUtils;

    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    public List<Student> getRank() {

        return studentUtils.getRankList();
    }

    public Optional<Student> findStudent(Long id){
        return studentRepository.findById(id);
    }

    public Student newStudent(Student student) {

        student.getMark().setTotal(
                student.getMark().getEnglish() + student.getMark().getScience() + student.getMark().getMaths()
        );
        Student saveStudent = studentRepository.save(student);
        return saveStudent;

    }

    public String deleteById(Long id) {

        studentRepository.deleteById(id);
        return id + " deleted";
    }

    public String clearDb() {

        studentRepository.deleteAll();
        return "All records  Deleted";
    }

    public Student updateStudent(Student newStudent, Long id) {

        return studentRepository.findById(id)
                .map(student -> {
                    if(newStudent.getMark().getEnglish()!=0)
                    student.getMark().setEnglish(newStudent.getMark().getEnglish());
                    if(newStudent.getMark().getMaths()!=0)
                    student.getMark().setMaths(newStudent.getMark().getMaths());
                    if(newStudent.getMark().getScience()!=0)
                    student.getMark().setScience(newStudent.getMark().getScience());
                    if(newStudent.getName()!=null)
                    student.setName(newStudent.getName());
                    student.getMark().setTotal(
                            student.getMark().getEnglish() + student.getMark().getScience() + student.getMark().getMaths()
                    );
                    return studentRepository.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setStudentId(id);
                    return studentRepository.save(newStudent);
                });
    }
}
