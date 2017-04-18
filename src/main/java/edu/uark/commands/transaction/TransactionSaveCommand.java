package edu.uark.commands.transaction;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Transaction;
import edu.uark.models.api.TransactionEntry;
import edu.uark.models.api.enums.TransactionApiRequestStatus;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.repositories.TransactionRepository;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * Created by pedro on 4/18/17.
 */
public class TransactionSaveCommand implements ResultCommandInterface<Transaction> {

    @Override
    public Transaction execute() {

        if (StringUtils.isBlank(this.apiTransaction.getCashierId())) {

            new Transaction().setApiRequestStatus(TransactionApiRequestStatus.INVALID_INPUT).
                    setApiRequestMessage("Cashier ID may not be empty.");
        }

        TransactionEntity transactionEntity;
        if (StringUtils.isBlank(this.apiTransaction.getRecordId())) {

            String recordId;
            do {
                recordId = RandomStringUtils.randomNumeric(RECORD_ID_LENGTH);
            } while (this.transactionRepository.recordIdExists(recordId));

            this.apiTransaction.setRecordId(recordId);
            transactionEntity = new TransactionEntity(this.apiTransaction);
        } else {

            transactionEntity = this.transactionRepository.get(this.apiTransaction.getId());
            if (transactionEntity != null) {

                if (this.apiTransaction.getRecordId().equals(transactionEntity.getRecordId())) {

                    this.apiTransaction = transactionEntity.synchronize(this.apiTransaction);
                } else {

                    return new Transaction().setApiRequestStatus(TransactionApiRequestStatus.INVALID_INPUT);
                }
            } else {

                transactionEntity = this.transactionRepository.byRecordId(this.apiTransaction.getRecordId());
                if (transactionEntity == null) {

                    transactionEntity = new TransactionEntity(this.apiTransaction);
                } else {

                    return new Transaction().setApiRequestStatus(TransactionApiRequestStatus.RECORD_ID_ALREADY_EXISTS);
                }
            }
        }

        transactionEntity.save();
        if ((new UUID(0, 0)).equals(this.apiTransaction.getId())) {

            this.apiTransaction.setId(transactionEntity.getId());
        }

        return this.apiTransaction;
    }

    /**
     * Transaction object from api
     */
    private Transaction apiTransaction;
    public Transaction getApiTransaction() {

        return this.apiTransaction;
    }
    public TransactionSaveCommand setApiTransaction(Transaction apiTransaction) {

        this.apiTransaction = apiTransaction;
        return this;
    }


    /**
     * Transaction repository
     */
    private TransactionRepositoryInterface transactionRepository;
    public TransactionRepositoryInterface getTransactionRepository() {

        return this.transactionRepository;
    }
    public TransactionSaveCommand setTransactionRepository(TransactionRepositoryInterface transactionRepository) {

        this.transactionRepository = transactionRepository;
        return this;
    }

    private static final int RECORD_ID_LENGTH = 8;

    /**
     * Constructor for TransactionSaveCommand
     */
    public TransactionSaveCommand() {

        this.transactionRepository = new TransactionRepository();
    }
}
