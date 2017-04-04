package edu.uark.models.entities;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.models.api.TransactionEntry;
import edu.uark.models.entities.fieldnames.TransactionEntryFieldNames;
import edu.uark.models.repositories.TransactionEntryRepository;
import org.apache.commons.lang3.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

/**
 * Created by pedro on 4/3/17.
 */
public class TransactionEntryEntity extends BaseEntity<TransactionEntryEntity> {

    @Override
    protected void fillFromRecord(ResultSet rs) throws SQLException {

        this.transactionId = rs.getString(TransactionEntryFieldNames.TRANSACTION_ID);
        this.productId = rs.getString(TransactionEntryFieldNames.PRODUCT_ID);
        this.amountSold = rs.getString(TransactionEntryFieldNames.AMOUNT_SOLD);
        this.soldPrice = rs.getString(TransactionEntryFieldNames.SOLD_PRICE);
    }

    @Override
    protected Map<String, Object> fillRecord(Map<String, Object> record) {

        record.put(TransactionEntryFieldNames.TRANSACTION_ID, this.transactionId);
        record.put(TransactionEntryFieldNames.PRODUCT_ID, this.productId);
        record.put(TransactionEntryFieldNames.AMOUNT_SOLD, this.amountSold);
        record.put(TransactionEntryFieldNames.SOLD_PRICE, this.soldPrice);

        return record;
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

    private String amountSold;
    public String getAmountSold() {

        return this.amountSold;
    }
    public void setAmountSold(String amountSold) {

        this.amountSold = amountSold;
    }

    private String soldPrice;
    public String getSoldPrice() {

        return this.soldPrice;
    }
    public void setSoldPrice(String soldPrice) {

        this.soldPrice = soldPrice;
    }

    public TransactionEntry synchronize(TransactionEntry apiTransactionEntry) {

        this.setTransactionId(apiTransactionEntry.getTransactionId());
        this.setProductId(apiTransactionEntry.getProductId());
        this.setAmountSold(apiTransactionEntry.getAmountSold());
        this.setSoldPrice(apiTransactionEntry.getSoldPrice());
        return apiTransactionEntry;
    }

    public TransactionEntryEntity() {

        super(new TransactionEntryRepository());
        this.transactionId = StringUtils.EMPTY;
        this.productId = StringUtils.EMPTY;
        this.amountSold = StringUtils.EMPTY;
        this.soldPrice = StringUtils.EMPTY;
    }

    public TransactionEntryEntity(UUID id) {

        super(id, new TransactionEntryRepository());
        this.transactionId = StringUtils.EMPTY;
        this.productId = StringUtils.EMPTY;
        this.amountSold = StringUtils.EMPTY;
        this.soldPrice = StringUtils.EMPTY;
    }

    public TransactionEntryEntity(TransactionEntry apiTransactionEntry) {

        super(apiTransactionEntry.getId(), new TransactionEntryRepository());

        this.transactionId = StringUtils.EMPTY;
        this.productId = StringUtils.EMPTY;
        this.amountSold = StringUtils.EMPTY;
        this.soldPrice = StringUtils.EMPTY;
    }
}
