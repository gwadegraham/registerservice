package edu.uark.commands.transaction;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Transaction;
import edu.uark.models.api.TransactionEntry;
import edu.uark.models.api.enums.TransactionApiRequestStatus;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.repositories.TransactionRepository;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * Created by pedro on 4/18/17.
 */
public class TransactionSaveCommand implements ResultCommandInterface<Transaction> {

    @Override
    public Transaction execute() {

        if (StringUtils.isBlank(this.apiTransaction.getRecordId())) {

            return (new Transaction()).setApiRequestStatus(TransactionApiRequestStatus.INVALID_INPUT);
        }

        TransactionEntity transactionEntity = this.transactionRepository.get(this.apiTransaction.getId());
        if (transactionEntity != null) {

            this.apiTransaction = transactionEntity.synchronize(this.apiTransaction);
        } else {

            transactionEntity = this.transactionRepository.byRecordId(this.apiTransaction.getRecordId());
            if (transactionEntity == null) {

                transactionEntity = new TransactionEntity(this.apiTransaction);
            } else {

                return (new Transaction()).setApiRequestStatus(TransactionApiRequestStatus.RECORD_ID_ALREADY_EXISTS);
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

    /**
     * Constructor for TransactionSaveCommand
     */
    public TransactionSaveCommand() {

        this.transactionRepository = new TransactionRepository();
    }
}
