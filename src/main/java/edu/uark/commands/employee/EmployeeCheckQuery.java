package edu.uark.commands.employee;

import java.util.UUID;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Employee;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeCheckQuery implements ResultCommandInterface<Employee> {
	@Override
	public Employee execute() {
		return new Employee(
				this.employeeRepository.get(this.employeeId)
		);
	}

	//Properties
	private UUID employeeId;
	public UUID getEmployeeId() {
		return this.employeeId;
	}
	public EmployeeCheckQuery setEmployeeId(UUID employeeId) {
		this.employeeId = employeeId;
		return this;
	}

	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getProductRepository() {
		return this.employeeRepository;
	}
	public EmployeeCheckQuery setProductRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}

	public EmployeeCheckQuery() {
		this.employeeRepository = new EmployeeRepository();
	}
}