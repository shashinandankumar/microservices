package com.example.rmqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.integration.support.MessageBuilder;


import com.example.rmqueue.model.Employee;
import com.example.rmqueue.source.EmployeeRegistrationSource;

@RestController
@EnableBinding(EmployeeRegistrationSource.class)
public class EmployeeRegistrationController {

    @Autowired
    EmployeeRegistrationSource employeeRegistrationSource;

    @RequestMapping("/register")
    @ResponseBody
    public String orderFood(@RequestBody Employee employee) {
        employeeRegistrationSource.employeeRegistration().send(MessageBuilder.withPayload(employee).build());
        System.out.println(employee.toString());
        return "Employee Registered";
    }
}