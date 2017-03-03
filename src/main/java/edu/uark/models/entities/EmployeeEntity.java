package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.models.api.Product;
import edu.uark.models.entities.fieldnames.ProductFieldNames;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.ProductRepository;

public class EmployeeEntity extends BaseEntity<EmployeeEntity> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.lookupCode = rs.getString(ProductFieldNames.LOOKUP_CODE);
		this.count = rs.getInt(ProductFieldNames.COUNT); 
		this.createdOn = rs.getTimestamp(ProductFieldNames.CREATED_ON).toLocalDateTime();
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(ProductFieldNames.LOOKUP_CODE, this.lookupCode);
		record.put(ProductFieldNames.COUNT, this.count);
		record.put(ProductFieldNames.CREATED_ON, Timestamp.valueOf(this.createdOn));
		
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
	private String created_On; 
	
	////////////////////////////////////////////////////
	public void setFirstName(String firstname)
	{
		
		this.firstName = firstname; 
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	
	////////////////////////////////////////////////////
	public void setLastName(String lastname)
	{
		
		this.lastName = lastname; 
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
	
	
	
	/////////////////////////////////////////////////////
	public void setCreated_On(String createdon)
	{

		this.created_On = createdon; 
	}

	public String getCreated_On()
	{
		return created_On;
	}


	

//-------------------------------------------end of "from registerddls"--------------//
	
	
	
	private String lookupCode; 
	public String getLookupCode() {
		return this.lookupCode;
	}
	public EmployeeEntity setLookupCode(String lookupCode) {
		if (!StringUtils.equals(this.lookupCode, lookupCode)) {
			this.lookupCode = lookupCode;
			this.propertyChanged(ProductFieldNames.LOOKUP_CODE);
		}
		
		return this;
	}

	private int count;
	public int getCount() {
		return this.count;
	}
	public EmployeeEntity setCount(int count) {
		if (this.count != count) {
			this.count = count;
			this.propertyChanged(ProductFieldNames.COUNT);
		}
		
		return this;
	}

	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	
	public Product synchronize(Product apiProduct) {
		this.setCount(apiProduct.getCount());
		this.setLookupCode(apiProduct.getLookupCode());
		
		apiProduct.setCreatedOn(this.createdOn);
		
		return apiProduct;
	}
	
	public EmployeeEntity() {
		super(new EmployeeRepository());
		
		this.count = -1;
		this.lookupCode = StringUtils.EMPTY;
		this.createdOn = LocalDateTime.now();
	}
	
	public EmployeeEntity(UUID id) {
		super(id, new EmployeeRepository());
		
		this.count = -1;
		this.lookupCode = StringUtils.EMPTY;
		this.createdOn = LocalDateTime.now();
	}

	public EmployeeEntity(Product apiProduct) {
		super(apiProduct.getId(), new EmployeeRepository());
		
		this.count = apiProduct.getCount();
		this.lookupCode = apiProduct.getLookupCode();

		this.createdOn = LocalDateTime.now();
	}
}
