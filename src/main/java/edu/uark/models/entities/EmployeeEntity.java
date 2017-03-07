package edu.uark.models.entities;

import java.rmi.registry.LocateRegistry;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import edu.uark.models.api.Employee;
import edu.uark.models.entities.fieldnames.EmployeeFieldNames;
import edu.uark.models.entities.fieldnames.ProductFieldNames;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.models.repositories.EmployeeRepository;

public class EmployeeEntity extends BaseEntity<EmployeeEntity> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {

		this.employeeID = rs.getString(EmployeeFieldNames.EMPLOYEE_ID);
	    this.firstName = rs.getString(EmployeeFieldNames.FIRST_NAME);
	    this.lastName = rs.getString(EmployeeFieldNames.LAST_NAME);
	    this.active = rs.getBoolean(EmployeeFieldNames.ACTIVE);
	    this.currentRole = rs.getString(EmployeeFieldNames.CURRENT_ROLE);
	    this.managerID = ((UUID) rs.getObject(EmployeeFieldNames.MANAGER_ID));
	    this.password= rs.getString(EmployeeFieldNames.PASSWORD);
	    this.createdOn= rs.getTimestamp(EmployeeFieldNames.CREATED_ON).toLocalDateTime();
	    this.count= rs.getInt(EmployeeFieldNames.COUNT);
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {

	    record.put(EmployeeFieldNames.EMPLOYEE_ID, this.employeeID);
        record.put(EmployeeFieldNames.FIRST_NAME, this.firstName);
        record.put(EmployeeFieldNames.LAST_NAME, this.lastName);
        record.put(EmployeeFieldNames.ACTIVE, this.active);
        record.put(EmployeeFieldNames.CURRENT_ROLE, this.currentRole);
        record.put(EmployeeFieldNames.MANAGER_ID, this.managerID);
        record.put(EmployeeFieldNames.PASSWORD, this.password);
        record.put(EmployeeFieldNames.CREATED_ON, Timestamp.valueOf(this.createdOn));
        record.put(EmployeeFieldNames.COUNT, this.count);

		return record;
	}
	
//--------------------------------------------------- from registerddls----------------//
	private String firstName;
	private String lastName;
	private String employeeID; 
	private boolean active; 
	private String currentRole;
	private UUID managerID; 
	private String password;
	
	
	////////////////////////////////////////////////////
	public void setFirstName(String firstName)
	{
		
		this.firstName = firstName;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	
	////////////////////////////////////////////////////
	public void setLastName(String lastName)
	{
		
		this.lastName = lastName;
	}
	
	public String getLastName (){
		return lastName;
	}
	
	
	///////////////////////////////////////////////////////
	public void setEmployeeID(String employeeId)
	{
		
		this.employeeID = employeeId; 
	}
	
	public String getEmployeeID(){
		return employeeID;
	}
	
	//////////////////////////////////////////////////////
	public void setActive(boolean activeEmp)
	{
		
		this.active = activeEmp; 
	}
	
	public boolean getActive()
	{
		return active;
	}
	
	/////////////////////////////////////////////////////
	public void setCurrentRole(String currentrole)
	{
		
		this.currentRole = currentrole; 
	}
	
	public String getCurrentRole()
	{
		return currentRole;
	}
	
	
	/////////////////////////////////////////////////////
	public void setManagerID(UUID managerId)
	{

		this.managerID = managerId; 
	}

	public UUID getManagerID()
	{
		return managerID;
	}
	
	
	/////////////////////////////////////////////////////
	public void setPassword(String pw)
	{

		this.password = pw; 
	}

	public String getPassword()
	{
		return password;
	}
	
	private int count;
	public int getCount() {
		return this.count;
	}
	public EmployeeEntity setCount(int count) {
		if (this.count != count) {
			this.count = count;
			this.propertyChanged(EmployeeFieldNames.COUNT);
		}
		
		return this;
	}


//-------------------------------------------end of "from registerddls"--------------//

	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}

	public Employee synchronize(Employee apiEmployee) {

	    this.setEmployeeID(apiEmployee.getEmployeeId());
	    this.setFirstName(apiEmployee.getFirstName());
	    this.setLastName(apiEmployee.getLastName());
	    this.setActive(apiEmployee.getActive());
	    this.setCurrentRole(apiEmployee.getRole());
	    this.setManagerID(apiEmployee.getManagerId());
	    this.setPassword(apiEmployee.getPassword());
	    apiEmployee.setCreatedOn(this.createdOn);
	    return apiEmployee;
    }

    public EmployeeEntity() {

	    super(new EmployeeRepository());
	    this.employeeID = StringUtils.EMPTY;
        this.managerID = new UUID(0, 0);
        this.firstName = "";
        this.lastName = "";
        this.currentRole = "";
        this.password = "";
        this.active = false;
        this.createdOn = LocalDateTime.now();
    }

    public EmployeeEntity(UUID id) {

	    super(id, new EmployeeRepository());
        this.employeeID = StringUtils.EMPTY;
        this.managerID = new UUID(0, 0);
        this.firstName = "";
        this.lastName = "";
        this.currentRole = "";
        this.password = "";
        this.active = false;
        this.createdOn = LocalDateTime.now();
    }

    public EmployeeEntity(Employee apiEmployee) {

	    super(apiEmployee.getId(), new EmployeeRepository());

	    this.employeeID = apiEmployee.getEmployeeId();
	    this.managerID = apiEmployee.getManagerId();
	    this.firstName = apiEmployee.getFirstName();
	    this.lastName = apiEmployee.getLastName();
	    this.currentRole = apiEmployee.getRole();
	    this.password = apiEmployee.getPassword();
	    this.active = apiEmployee.getActive();
	    this.createdOn = LocalDateTime.now();
    }
}
