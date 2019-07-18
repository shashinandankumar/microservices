package com.javainuse.controllers;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name="student")
public interface RemoteCallService
{

    @RequestMapping(method=RequestMethod.GET, value="/student"  )
    public List<Object> getStudentData();
}
