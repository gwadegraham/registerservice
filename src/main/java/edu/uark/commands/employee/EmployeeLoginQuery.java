package edu.uark.commands.employee;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Employee;
import edu.uark.models.api.EmployeeLogin;
import edu.uark.models.api.enums.EmployeeApiRequestStatus;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeLoginQuery implements ResultCommandInterface<Employee> {
    @Override
    public Employee execute() {
        if (StringUtils.isBlank(this.employeeLogin.getEmployeeId())) {
            return new Employee().setApiRequestStatus(EmployeeApiRequestStatus.INVALID_INPUT);
        }

        EmployeeEntity employeeEntity = this.employeeRepository.byEmployeeId(this.employeeLogin.getEmployeeId());
        if ((employeeEntity != null) && (employeeEntity.getPassword().equals(this.employeeLogin.getPassword()))) {
            return new Employee(employeeEntity);
        } else {
            return new Employee().setApiRequestStatus(EmployeeApiRequestStatus.NOT_FOUND);
        }
    }

    //Properties
    private EmployeeLogin employeeLogin;
    public EmployeeLogin getEmployeeLogin() {
        return this.employeeLogin;
    }
    public EmployeeLoginQuery setEmployeeLogin(EmployeeLogin employeeLogin) {
        this.employeeLogin = employeeLogin;
        return this;
    }

    private EmployeeRepositoryInterface employeeRepository;
    public EmployeeRepositoryInterface getProductRepository() {
        return this.employeeRepository;
    }
    public EmployeeLoginQuery setProductRepository(EmployeeRepositoryInterface employeeRepository) {
        this.employeeRepository = employeeRepository;
        return this;
    }

    public EmployeeLoginQuery() {
        this.employeeLogin = new EmployeeLogin();
        this.employeeRepository = new EmployeeRepository();
    }
}