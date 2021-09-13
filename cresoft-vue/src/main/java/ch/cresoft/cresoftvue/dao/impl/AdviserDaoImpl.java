package ch.cresoft.cresoftvue.dao.impl;

import ch.cresoft.cresoftvue.dao.AdviserDao;
import ch.cresoft.cresoftvue.model.Adviser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AdviserDaoImpl implements AdviserDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Adviser> findAll() {
        return jdbcTemplate.query("SELECT * FROM ADVISERS", (rs, rowNum) -> mapAdviserResult(rs));
    }

    private Adviser mapAdviserResult(final ResultSet resultSet) throws SQLException {
        Adviser adviser = new Adviser();

        adviser.setId(resultSet.getInt("ID"));
        adviser.setCode(resultSet.getString("CODE"));
        adviser.setName(resultSet.getString("NAME"));
        adviser.setShortName(resultSet.getString("SHORTNAME"));
        adviser.setDdlId(resultSet.getInt("DDL_ID"));
        adviser.setDepartment(resultSet.getString("DEPARTMENT"));
        adviser.setTelNumber(resultSet.getString("TEL_NUMBER"));
        adviser.setAteId(resultSet.getInt("ATE_ID"));
        adviser.setUsername(resultSet.getString("USERNAME"));
        adviser.setRecTyp(resultSet.getString("REC_TYP"));
        adviser.setDepartmentId(resultSet.getString("DEPARTMENT_ID"));
        adviser.setRecordStatus(resultSet.getInt("STATUS"));
        adviser.setRequestToDelete(resultSet.getString("REQUEST_TO_DELETE"));
        adviser.setRequestUser(resultSet.getString("REQUEST_USER"));
        adviser.setRequestDate(resultSet.getDate("REQUEST_DATE"));
        adviser.setApproveUser(resultSet.getString("APPROVE_USER"));
        adviser.setApproveDate(resultSet.getDate("APPROVE_DATE"));
        adviser.setRegion(resultSet.getString("REGION"));
        adviser.setMarket(resultSet.getString("MARKET"));

        return adviser;
    }
}
