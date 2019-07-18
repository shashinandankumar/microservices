package com.company.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.company.student.dto.Student;

@Service
public class StudentServiceImpl implements IstudentService
{

   // @Autowired
    //private IstudentDao studentdao;
    
    public String SaveStudent(Student std)
    {
       return "shashi";
       
    }

     public List<Student> getStudentData()
    {
        List ls=new ArrayList<Student>();
        ls.add(new Student("2","shashi"));
        ls.add(new Student("5","kumar"));
        return ls;

}
     }
