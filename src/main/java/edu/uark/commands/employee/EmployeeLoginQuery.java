package edu.uark.commands.employee;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Employee;
import edu.uark.models.api.enums.EmployeeApiRequestStatus;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;
import org.apache.commons.lang3.StringUtils;


//TODO : Also need to check for password
public class EmployeeLoginQuery implements ResultCommandInterface<Employee> {


    private String employeeId;
    public String getEmployeeId() { return this.employeeId; }
    public EmployeeLoginQuery setEmployeeId(String employeeId) {

        this.employeeId = employeeId;
        return this;
    }

    private EmployeeRepositoryInterface employeeRepository;
    public EmployeeRepositoryInterface getEmployeeRepositoryInterface() { return this.employeeRepository; }
    public EmployeeLoginQuery setEmployeeReposity(EmployeeRepositoryInterface employeeReposity) {

        this.employeeRepository = employeeReposity;
        return this;
    }

    public EmployeeLoginQuery() {

        this.employeeRepository = new EmployeeRepository();
    }

    @Override
    public Employee execute() {

        if (StringUtils.isBlank(this.employeeId)) {

            return new Employee().setApiRequestStatus(EmployeeApiRequestStatus.INVALID_INPUT);
        }

        EmployeeEntity employeeEntity = this.employeeRepository.byEmployeeId(this.employeeId);
        if (employeeEntity != null) {

            return new Employee(employeeEntity);
        } else {

            return new Employee().setApiRequestStatus(EmployeeApiRequestStatus.NOT_FOUND);
        }
    }
}
