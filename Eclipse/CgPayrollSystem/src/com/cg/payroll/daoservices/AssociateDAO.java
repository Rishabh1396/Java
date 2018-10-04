package com.cg.payroll.daoservices;

import com.cg.payroll.beans.Associate;
import java.util.ArrayList;

public interface AssociateDAO {
	Associate save(Associate associate);
	Associate findone(int associateID);
	ArrayList<Associate> findAll();
}
