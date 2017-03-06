package edu.uark.commands.employee;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Employee;
import edu.uark.models.api.enums.EmployeeApiRequestStatus;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeCheckQuery implements ResultCommandInterface<Employee>{

	@Override
	public Employee execute() {
		// TODO Auto-generated method stub 
		if(StringUtils.isBlank(this.EmployeeNumber)) {
			return new Employee().setApiRequestStatus(EmployeeApiRequestStatus.INVALID_INPUT);
		}
		
		EmployeeEntity employeeEntity = this.employeeRepository.byEmployeeId(this.EmployeeNumber);
		if (employeeEntity != null) {
			return new Employee(employeeEntity);
		} else {
			return new Employee().setApiRequestStatus(EmployeeApiRequestStatus.NOT_FOUND);
		}
	}
	
	private String EmployeeNumber;
	public String getEmployeeNumber() {
		return this.EmployeeNumber;
	}
	
	public EmployeeCheckQuery setEmployeeNumber(String employeeNumber) {
		this.EmployeeNumber = employeeNumber;
		return this;
	}
	
	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getEmployeeRepository() {
		return this.employeeRepository;
	}
	
	public EmployeeCheckQuery setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public EmployeeCheckQuery() {
		this.employeeRepository = new EmployeeRepository();
	}

}
