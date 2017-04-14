package edu.uark.models.repositories.interfaces;

import edu.uark.dataaccess.repository.BaseRepositoryInterface;
import edu.uark.models.entities.TransactionEntity;

/**
 * Created by pedro on 4/14/17.
 */
public interface TransactionRepositoryInterface extends BaseRepositoryInterface<TransactionEntity> {

    public TransactionEntity byRecordId(String recordId);
}
