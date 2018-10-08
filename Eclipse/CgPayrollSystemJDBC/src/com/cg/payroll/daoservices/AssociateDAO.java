package com.cg.payroll.daoservices;

import com.cg.payroll.beans.Associate;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AssociateDAO {
	Associate save(Associate associate) throws SQLException;
	Associate findone(int associateID) throws SQLException;
	ArrayList<Associate> findAll() throws SQLException;
	public boolean update(Associate associate);
}
