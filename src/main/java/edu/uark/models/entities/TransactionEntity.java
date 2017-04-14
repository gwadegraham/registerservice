package edu.uark.models.entities;

import java.rmi.registry.LocateRegistry;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import edu.uark.models.api.Employee;
import edu.uark.models.api.Product;
import edu.uark.models.entities.fieldnames.EmployeeFieldNames;
import edu.uark.models.entities.fieldnames.ProductFieldNames;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.ProductRepository;

public class TransactionEntity extends BaseEntity<TransactionEntity> {	
	
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.recordId = rs.getString(TransactionFieldNames.RECORD_ID);
		this.cashierId = rs.getString(TransactionFieldNames.CASHIER_ID);
		this.totalPrice = rs.getDouble(TransactionFieldNames.TOTAL_PRICE);
		this.transType = rs.getString(TransactionFieldNames.TRANSACTION_TYPE);
		this.referenceId = rs.getString(TransactionFieldNames.REFERENCE_ID);
		this.createdOn = rs.getTimestamp(TransactionFieldNames.CREATED_ON).toLocalDateTime();;
		
	}
	
	
private String recordId;
private String cashierId;
private double totalPrice;
private String transType;
private String referenceId;
private LocalDateTime createdOn;


public void setRecordId(String record_id)
{

this.recordId = record_id;

}

public String getRecordId()
{
	
return recordId;

}



public void setCashierId(String cashier_id)
{

this.cashierId = cashier_id;

}

public String getCahierId()
{
	
return cashierId;

}

public void setTotalPrice(double total_price)
{

this.totalPrice = total_price;

}

public double getTotalPrice()
{
	
return totalPrice;

}

public void setTransType(String transaction_type)
{

this.transType = transaction_type;

}

public String getTransType()
{
	
return transType;

}

public void setReferenceId(String reference_id)
{

this.referenceId = reference_id;

}

public String getReferenceId()
{
	
return referenceId;

}

public LocalDateTime getCreatedOn() {
	return this.createdOn;
}

}

// add FillRecord, FillFromRecord, Synchronize, Constructors (3) here  

