package edu.uark.controllers;

import edu.uark.commands.employee.EmployeeLoginQuery;
import edu.uark.models.api.Employee;
import edu.uark.models.api.EmployeeCheck;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeRestController {


    //TODO : RESTful link and test if it actually works (command)
    @RequestMapping(value = "/login/{employeeId}:{password}", method = RequestMethod.PUT)
    public Employee employeeLogin(Employee employee, @PathVariable String employeeId, @PathVariable String password) {

        return (new EmployeeLoginQuery()).
                setEmployeeId(employeeId).
                setPassword(password).
                execute();
    }

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "Successful test. (EmployeeRestController)";
    }
    
    //sangyunnn
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public EmployeeCheck check() {
    	return new EmployeeCheck();
    }
}
