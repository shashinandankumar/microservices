package com.company.student.service;


import java.util.List;


import com.company.student.dto.Student;



public interface IstudentService
{
    public String SaveStudent(Student std);

    public List<Student> getStudentData();
}
