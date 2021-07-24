package com.student.registry.utils;

import com.student.registry.model.Student;
import com.student.registry.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortbyMark implements Comparator<Student>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Student a, Student b)
    {
        return b.getMark().getTotal() - a.getMark().getTotal();
    }
}

@Component
public class StudentUtils {
    @Autowired
    StudentRepository studentRepository;

    List<Student> RankList = new ArrayList<Student>();

    public List<Student> getRankList(){

        RankList = studentRepository.findAll();
        Collections.sort(RankList,new SortbyMark());
        return RankList;
    }
}
