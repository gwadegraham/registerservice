package edu.uark.models.repositories;

import edu.uark.dataaccess.repository.BaseRepository;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.dataaccess.repository.helpers.PostgreFunctionType;
import edu.uark.dataaccess.repository.helpers.SQLComparisonType;
import edu.uark.dataaccess.repository.helpers.where.WhereClause;
import edu.uark.dataaccess.repository.helpers.where.WhereContainer;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;

/**
 * Created by pedro on 4/14/17.
 */
public class TransactionRepository extends BaseRepository<TransactionEntity> implements TransactionRepositoryInterface {

    @Override
    public TransactionEntity byRecordId(String recordId) {

        return this.firstOrDefaultWhere(
                new WhereContainer(
                        (new WhereClause()).
                                postgreFunction(PostgreFunctionType.LOWER).
                                table(this.primaryTable).
                                fieldName(TransactionFieldNames.RECORD_ID).
                                comparison(SQLComparisonType.EQUALS)
                ),
                (ps) -> {

                    try {

                        ps.setObject(1, recordId.toLowerCase());
                    } catch (SQLException e) {


                    }

                    return ps;
                }
        );
    }

    @Override
    public boolean recordIdExists(String recordId) {

        return this.existsWhere(
                new WhereContainer(
                        new WhereClause().
                                table(this.primaryTable).
                                fieldName(TransactionFieldNames.RECORD_ID).
                                comparison(SQLComparisonType.EQUALS)

                ),
                (ps) -> {
                    try {
                        ps.setObject(1, recordId);
                    } catch (SQLException e) {}

                    return ps;
                }
        );
    }

    @Override
    public TransactionEntity createOne () {

        return new TransactionEntity();
    }

    public TransactionRepository() {

            super(DatabaseTable.TRANSACTION);
    }
}