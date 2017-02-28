package edu.uark.commands.employee;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Employee;

public class EmployeeLoginQuery implements ResultCommandInterface<Employee> {

    @Override
    public Employee execute() {

        return new Employee();
    }
}
