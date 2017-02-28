package edu.uark.controllers;

import edu.uark.models.api.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeRestController {

    @RequestMapping(value = "/apiv0/employees", method = RequestMethod.PUT)
    public Employee employeeLogin(Employee employee) {

        return new Employee();
    }

}
