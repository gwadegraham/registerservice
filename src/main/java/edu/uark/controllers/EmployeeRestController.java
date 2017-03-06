package edu.uark.controllers;

import edu.uark.commands.employee.EmployeeLoginQuery;
import edu.uark.models.api.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeRestController {


    /* INITIAL TEST */
    @RequestMapping(value = "/login/{employeeId}", method = RequestMethod.PUT)
    public Employee employeeLogin(Employee employee, @PathVariable String employeeId) {

        return (new EmployeeLoginQuery()).
                setEmployeeId(employeeId).
                execute();
    }

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "Successful test. (EmployeeRestController)";
    }

    @ResponseBody
    @RequestMapping(value = "/login/{employeeId}:{password}", method = RequestMethod.GET)
    public String testEmployeeId(@PathVariable String employeeId, @PathVariable String password) { return employeeId + " " + password; }
    
    //sangyunnn
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public Employee check() {
    	return new Employee();
    }
}
