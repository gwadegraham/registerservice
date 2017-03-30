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
import edu.uark.models.repositories.ProductRepository;

public class ProductEntity extends BaseEntity<ProductEntity> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.lookupCode = rs.getString(ProductFieldNames.LOOKUP_CODE);
		this.quantity = rs.getInt(ProductFieldNames.QUANTITY);
		this.createdOn = rs.getTimestamp(ProductFieldNames.CREATED_ON).toLocalDateTime();
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(ProductFieldNames.LOOKUP_CODE, this.lookupCode);
		record.put(ProductFieldNames.COUNT, this.quantity);
		record.put(ProductFieldNames.CREATED_ON, Timestamp.valueOf(this.createdOn));
		
		return record;
	}

	private String lookupCode; 
	public String getLookupCode() {
		return this.lookupCode;
	}
	public ProductEntity setLookupCode(String lookupCode) {
		if (!StringUtils.equals(this.lookupCode, lookupCode)) {
			this.lookupCode = lookupCode;
			this.propertyChanged(ProductFieldNames.LOOKUP_CODE);
		}
		
		return this;
	}

	private int quantity;
	public int getCount() {
		return this.quantity;
	}
	public ProductEntity setCount(int count) {
		if (this.quantity != count) {
			this.quantity = count;
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
	
	public ProductEntity() {
		super(new ProductRepository());
		
		this.quantity = -1;
		this.lookupCode = StringUtils.EMPTY;
		this.createdOn = LocalDateTime.now();
	}
	
	public ProductEntity(UUID id) {
		super(id, new ProductRepository());
		
		this.quantity = -1;
		this.lookupCode = StringUtils.EMPTY;
		this.createdOn = LocalDateTime.now();
	}

	public ProductEntity(Product apiProduct) {
		super(apiProduct.getId(), new ProductRepository());
		
		this.quantity = apiProduct.getCount();
		this.lookupCode = apiProduct.getLookupCode();

		this.createdOn = LocalDateTime.now();
	}
}
