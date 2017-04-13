package edu.uark.models.repositories;

import edu.uark.dataaccess.repository.BaseRepository;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.TransactionEntry;
import edu.uark.models.entities.TransactionEntryEntity;
import edu.uark.models.repositories.interfaces.TransactionEntryRepositoryInterface;

/**
 * Created by pedro on 4/3/17.
 */
public class TransactionEntryRepository extends BaseRepository<TransactionEntryEntity> implements TransactionEntryRepositoryInterface {

    @Override
    public TransactionEntryEntity createOne() { return new TransactionEntryEntity(); }

    public TransactionEntryRepository() { super(DatabaseTable.TRANSACTION_ENTRY); }
}
