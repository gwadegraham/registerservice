package edu.uark.controllers;

import edu.uark.commands.employee.EmployeeSaveCommand;
import edu.uark.commands.employee.EmployeeLoginQuery;
import edu.uark.models.api.Employee;

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

    @RequestMapping(value = "/create/{employeeId}", method = RequestMethod.GET)
    public Employee testCreateEmployee(@PathVariable String employeeId) {

        return (new EmployeeSaveCommand()).
                setEmployeeId(employeeId).
                execute();
    }

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "Successful test. (EmployeeRestController)";
    }
    
    //sangyun
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public Employee check() {
    	return new Employee();
    }
}
