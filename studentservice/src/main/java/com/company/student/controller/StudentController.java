package com.company.student.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.company.student.dto.Student;

import com.company.student.service.IstudentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@RestController
public class StudentController
{
    
    @Autowired
    private IstudentService studentService;

    @RequestMapping(value="/student",method=RequestMethod.POST)
    public String Student(@RequestBody Student student ) {
        
          return studentService.SaveStudent(student);
    }
    @RequestMapping(value="/student",method=RequestMethod.GET)
    @HystrixCommand(fallbackMethod="getDataFallBack")
    public List<Student> Student() {
        
          return studentService.getStudentData();
    }
   
   public List<Student> getDataFallBack() {
       
       Student  std = new Student();
       
       std.setName("fallback-emp1");
       std.setSid("fallback-1");
       List list=new ArrayList<Student>();
       list.add(std);
       return list;
       
   }
}
