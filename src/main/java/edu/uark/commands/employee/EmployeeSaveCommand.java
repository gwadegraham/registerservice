package edu.uark.commands.employee;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Employee;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

/**
 * Created by pedro on 3/7/17.
 */
public class EmployeeSaveCommand implements ResultCommandInterface<Employee> {

    private EmployeeRepositoryInterface employeeRepository;
    private String employeeId;

    public String getEmployeeId() { return employeeId; }
    public EmployeeSaveCommand setEmployeeId(String employeeId) {

        this.employeeId = employeeId;
        return this;
    }

    public EmployeeRepositoryInterface getEmployeeRepository() { return employeeRepository; }
    public EmployeeSaveCommand setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {

        this.employeeRepository = employeeRepository;
        return this;
    }

    @Override
    public Employee execute() {

        return new Employee();
    }
}
