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

public class TransactionEntity extends Transaction<TransactionEntity> {	
	
	// some code here
	// class Transaction not created as of yet


private String customerName;
private int productCount; 
private double totalPrice; 




public void setCustomerName(String customer_name)
{

this.customerName = customer_name;

}

public String getCustomerName()
{
	
return customerName;

}


public void setProductCount(int product_count)
{

this.productCount = product_count;

}

public int getProductCount()
{
	
return productCount;

}

public void setTotalPrice(double total_price)
{

this.totalPrice = total_price;

}

public double getTotalPrice()
{
	
return totalPrice;

}


}




