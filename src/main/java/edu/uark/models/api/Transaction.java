package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.models.api.enums.TransactionApiRequestStatus;
import edu.uark.models.entities.TransactionEntity;

public class Transaction {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Transaction setId(UUID id) {
		this.id = id;
		return this;
	}
	
	private String cashierId;
	public String getCashierId() {
		return this.cashierId;
	}
	public Transaction setCashierId(String cashierId) {
		this.cashierId = cashierId;
		return this;
	}
	private double totalAmount;
	public double getTotal() {
		return this.totalAmount;
	}
	
	public Transaction setTotalAmount(double total) {
		this.totalAmount = total;
		return this;
	}
	
	private String type;
	public String getType() {
		return this.type;
	}
	
	public Transaction setType(String type) {
		this.type = type;
		return this;
	}

	private String refId;
	public String getRefId() {
		return this.getRefId();
	}
	
	public Transaction setRefId(String ref) {
		this.refId = ref;
		return this;
	}
	
	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	
	public Transaction setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	
	private TransactionApiRequestStatus apiRequestStatus;
	public TransactionApiRequestStatus getApiRequestStatus() {
		return this.apiRequestStatus;
	}
	
	public Transaction setApiRequestStatus(TransactionApiRequestStatus apiRequestStatus) {
		if (this.apiRequestStatus != apiRequestStatus) {
			this.apiRequestStatus = apiRequestStatus;
		}
		
		return this;
	}
	
	private String apiRequestMessage;
	public String getApiRequestMessage() {
		return this.apiRequestMessage;
	}
	public Transaction setApiRequestMessage(String apiRequestMessage) {
		if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage)) {
			this.apiRequestMessage = apiRequestMessage;
		}
		
		return this;
	}
	
	public Transaction() {
		this.id = new UUID(0, 0);
		this.cashierId = StringUtils.EMPTY;
		this.totalAmount = 0.0;
		this.type = "sales";
		this.refId = "";
		this.createdOn = LocalDateTime.now();
		this.apiRequestStatus = TransactionApiRequestStatus.OK;
		this.apiRequestMessage = StringUtils.EMPTY;
	}
	
	public Transaction(TransactionEntity transactionEntity) {
		this.id = transactionEntity.getId();
		this.cashierId = "";
		this.totalAmount = 0.0;
		this.type = "sales";
		this.refId = "";
		this.createdOn = LocalDateTime.now();
	}

}
