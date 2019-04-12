package com.mindtree.BasicApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.BasicApp.model.Employee;

@RestController
public class NewEmployee {
	@RequestMapping(value ="/employee", method = RequestMethod.GET)
public Employee detail(){
	Employee e =new Employee();
	e.setName("anindita");
	e.setDesignation("Engineer");
	e.setEmpId("M1047050");
	e.setSalary(24000);
	
	return e;

		}
}
