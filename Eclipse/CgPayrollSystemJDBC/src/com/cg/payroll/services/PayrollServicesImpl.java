package com.cg.payroll.services;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.AssociateDAO;
import com.cg.payroll.daoservices.AssociateDAOImpl;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;

public class PayrollServicesImpl implements PayrollServices {
	private AssociateDAO associateDAO = new AssociateDAOImpl();

	@Override
	public int acceptAssociateDetails(String firstName, String lastName,
			String emailId, String department, String designation,
			String pancard, int yearlyInvestmentUnder80C, int basicSalary,
			int epf, int companyPf, int accountNumber, String bankName,
			String ifscCode) throws PayrollServicesDownException, SQLException {
		Associate associate = new Associate(yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId, new BankDetails(accountNumber, bankName, ifscCode), new Salary(basicSalary, epf, companyPf));
		associate = associateDAO.save(associate);
		return associate.getAssociateID();
	}

	@Override
	public int calculateNetSalary(int associateId)
			throws AssociateDetailsNotFoundException,
			PayrollServicesDownException, SQLException {
		Associate associate = associateDAO.findone(associateId);
		//Allowances and Gross Salary Calculation
		associate.getSalary().setHra((int)(0.3 * associate.getSalary().getBasicSalary()));
		associate.getSalary().setOtherAllowance((int)(0.2 * associate.getSalary().getBasicSalary()));
		associate.getSalary().setPersonalAllowance((int)(0.2 * associate.getSalary().getBasicSalary()));
		associate.getSalary().setConveyenceAllowance((int)(0.25 * associate.getSalary().getBasicSalary()));
		associate.getSalary().setGrossSalary(associate.getSalary().getBasicSalary() + associate.getSalary().getHra() + associate.getSalary().getOtherAllowance() + associate.getSalary().getPersonalAllowance() + associate.getSalary().getConveyenceAllowance());
		double annualGrossSalary = associate.getSalary().getGrossSalary() * 12;
		//Tax Calculation
		double netSalaryAfterInvesting = annualGrossSalary - ((associate.getYearlyInvestmentUnder80C()>(150000-associate.getSalary().getEpf()-associate.getSalary().getCompanyPf())?(150000):(associate.getYearlyInvestmentUnder80C())));
		double annualTax = 0;
		if (netSalaryAfterInvesting <= 250000)
			annualTax = 0;
		else if (netSalaryAfterInvesting>250000 && netSalaryAfterInvesting<= 500000)
			annualTax = (netSalaryAfterInvesting - 250000) * 0.05;
		else if (netSalaryAfterInvesting>500000 && netSalaryAfterInvesting<=1000000)
			annualTax = (netSalaryAfterInvesting- 500000) * 0.2 + 250000 * 0.05;
		else
			annualTax = (netSalaryAfterInvesting - 1000000) * 0.3 + 500000 * 0.02 + 250000*0.05;
		double monthlyTax = annualTax / 12;
		associate.getSalary().setMonthlyTax((int)monthlyTax);
		associate.getSalary().setNetSalary((int) (associate.getSalary().getGrossSalary() - monthlyTax));
		return associate.getSalary().getNetSalary();
	}

	@Override
	public Associate getAssociateDetails(int associateId)
			throws AssociateDetailsNotFoundException,
			PayrollServicesDownException, SQLException{
		
		return associateDAO.findone(associateId);

	} 

	@Override
	public ArrayList<Associate> getAllAssociateDetails()
			throws PayrollServicesDownException, SQLException {
		// TODO Auto-generated method stub
		return associateDAO.findAll();
	}

}
