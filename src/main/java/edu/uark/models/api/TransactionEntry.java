package edu.uark.models.api;

import edu.uark.models.api.enums.TransactionEntryApiRequestStatus;
import edu.uark.models.entities.TransactionEntryEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * Created by pedro on 4/3/17.
 */
public class TransactionEntry {

    private UUID id;
    public UUID getId() {

        return this.id;
    }
    public void setId(UUID id) {

        this.id = id;
    }

    private String transactionId;
    public String getTransactionId() {

        return this.transactionId;
    }
    public void setTransactionId(String transactionId) {

        this.transactionId = transactionId;
    }

    private String productId;
    public String getProductId() {

        return this.productId;
    }
    public void setProductId(String productId) {

        this.productId = productId;
    }

    private int amountSold;
    public int getAmountSold() {

        return this.amountSold;
    }
    public void setAmountSold(int amountSold) {

        this.amountSold = amountSold;
    }

    private double soldPrice;
    public double getSoldPrice() {

        return this.soldPrice;
    }
    public void setSoldPrice(double soldPrice) {

        this.soldPrice = soldPrice;
    }

    private TransactionEntryApiRequestStatus apiRequestStatus;
    public TransactionEntryApiRequestStatus getApiRequestStatus() {

        return apiRequestStatus;
    }
    public TransactionEntry setApiRequestStatus(TransactionEntryApiRequestStatus apiRequestStatus) {

        if (this.apiRequestStatus != apiRequestStatus) {

            this.apiRequestStatus = apiRequestStatus;
        }

        return this;
    }

    private String apiRequestMessage;
    public String getApiRequestMessage() {

        return this.apiRequestMessage;
    }
    public TransactionEntry setApiRequestMessage(String apiRequestMessage) {

        if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage)) {

            this.apiRequestMessage = apiRequestMessage;
        }

        return this;
    }

    public TransactionEntry() {

        this.transactionId = StringUtils.EMPTY;
        this.productId = StringUtils.EMPTY;
        this.amountSold = 0;
        this.soldPrice = 0;
    }

    public TransactionEntry(TransactionEntryEntity transactionEntryEntity) {

        this.transactionId = transactionEntryEntity.getTransactionId();
        this.productId = transactionEntryEntity.getProductId();
        this.amountSold = transactionEntryEntity.getAmountSold();
        this.soldPrice = transactionEntryEntity.getSoldPrice();
    }
}
