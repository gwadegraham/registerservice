package edu.uark.models.repositories;
import com.fasterxml.jackson.databind.deser.Deserializers;
import edu.uark.models.entities.EmployeeEntity;
import java.sql.SQLException;

import edu.uark.dataaccess.repository.BaseRepository;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.dataaccess.repository.helpers.PostgreFunctionType;
import edu.uark.dataaccess.repository.helpers.SQLComparisonType;
import edu.uark.dataaccess.repository.helpers.where.WhereClause;
import edu.uark.dataaccess.repository.helpers.where.WhereContainer;
import edu.uark.models.entities.fieldnames.EmployeeFieldNames;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;


public class EmployeeRepository extends BaseRepository<EmployeeEntity> implements EmployeeRepositoryInterface {

	@Override
	public EmployeeEntity byEmployeeId(String employeeId) {

		return this.firstOrDefaultWhere(
				new WhereContainer(
						(new WhereClause()).
								//postgreFunction(PostgreFunctionType.LOWER).// EmployeeID is a string of numbers, no need to convert to lowercase.
								table(this.primaryTable).
								fieldName(EmployeeFieldNames.EMPLOYEE_ID).
								comparison(SQLComparisonType.EQUALS)
				),
				(ps) -> {
					try {
						ps.setObject(1, employeeId); //  removed call toLowerCase() here
					} catch (SQLException e) {}

					return ps;
				}
		);
	}

	@Override
	public EmployeeEntity createOne() {

		return new EmployeeEntity();
	}

	public EmployeeRepository() {

		super(DatabaseTable.EMPLOYEE);
	}
}
