package com.company.student.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "student")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String sid;
    @Column
    private String name;
   
    public Student(String sid, String name)
    {
        super();
        this.sid = sid;
        this.name = name;
    }
    public Student()
    {
        // TODO Auto-generated constructor stub
    }
    public String getSid()
    {
        return sid;
    }
    public void setSid(String sid)
    {
        this.sid = sid;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

   

}
