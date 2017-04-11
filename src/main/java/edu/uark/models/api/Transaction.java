package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Transaction setId(UUID id) {
		this.id = id;
		return this;
	}
	
	private UUID cashierId;
	public UUID getcashierId() {
		return this.id;
	}
	public Transaction setcashierId(UUID cashierId) {
		this.id = id;
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
	
	private UUID refId;
	public UUID getRefId() {
		return this.getRefId();
	}
	
	public Transaction setRefId(UUID ref) {
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

}
