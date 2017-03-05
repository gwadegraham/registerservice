package edu.uark.controllers;

import edu.uark.commands.employee.EmployeeLoginQuery;
import edu.uark.models.api.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeRestController {

    //CHANGE pedro
    @RequestMapping(value = "/login", method = RequestMethod.PUT)
    public Employee employeeLogin(Employee employee) {

        return (new EmployeeLoginQuery()).execute();
    }

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "Successful test. (EmployeeRestController)";
    }
    
    //sangyunnn
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public EmployeeCount check() {
    	return (new EmployeeCount());
    }
}
