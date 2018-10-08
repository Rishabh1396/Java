package com.cg.payroll.daoservices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.util.ConnectionProvider;


public class AssociateDAOImpl implements AssociateDAO{
	private static HashMap<Integer, Associate> associates=new HashMap<>();
	private static int ASSOCIATE_ID_COUNTER=101;
	private Connection conn = ConnectionProvider.getDBConnection();

	@Override
	public Associate save(Associate associate) throws SQLException {
		/*associate.setAssociateID(ASSOCIATE_ID_COUNTER++);
		associates.put(associate.getAssociateID(), associate);
		return associate;*/
		try{
			conn.setAutoCommit(false);
			PreparedStatement pstmt1=conn.prepareStatement("insert into Associate(yearlyInvestmentUnder80C,firstName,lastName,department,designation,pancard,emailId)values(?,?,?,?,?,?,?)");
			pstmt1.setInt(1, associate.getYearlyInvestmentUnder80C());
			pstmt1.setString(2, associate.getFirstName());
			pstmt1.setString(3, associate.getLastName());
			pstmt1.setString(4, associate.getDepartment());
			pstmt1.setString(5, associate.getDesignation());
			pstmt1.setString(6, associate.getPancard());
			pstmt1.setString(7, associate.getEmailId());
			pstmt1.executeUpdate();
			
			PreparedStatement pstmt2 = conn.prepareStatement("Select max(associateId) from Associate");
			ResultSet rs=pstmt2.executeQuery();
			rs.next();
			int associateId=rs.getInt(1);
			
			PreparedStatement pstmt3 = conn.prepareStatement("Insert into BankDetails values(?,?,?,?)");
			pstmt3.setInt(1, associateId);
			pstmt3.setDouble(2, associate.getBankDetails().getAccountNumber());
			pstmt3.setString(3, associate.getBankDetails().getBankName());
			pstmt3.setString(4, associate.getBankDetails().getIfscCode());
			pstmt3.executeUpdate();
			
			PreparedStatement pstmt4 = conn.prepareStatement("Insert into Salary(associateId,basicSalary,epf,companyPf) values(?,?,?,?)");
			pstmt4.setInt(1, associateId);
			pstmt4.setDouble(2, associate.getSalary().getBasicSalary());
			pstmt4.setDouble(3, associate.getSalary().getEpf());
			pstmt4.setDouble(4, associate.getSalary().getCompanyPf());
			pstmt4.executeUpdate();
			conn.commit();
			associate.setAssociateID(associateId);
			return associate;
			

		}catch(SQLException e){
			e.printStackTrace();
			conn.rollback();
			throw e;
		}finally{
			conn.setAutoCommit(true);
		}
		
	}

	@Override
	public Associate findone(int associateID) throws SQLException {
		PreparedStatement pstmt1 = conn.prepareStatement("Select * from Associate where associateId="+associateID);
		ResultSet associateRS = pstmt1.executeQuery();
		if(associateRS.next()){
			int yearlyInvestmentUnder80C=associateRS.getInt("yearlyInvestmentUnder80C");
			String firstName=associateRS.getString("firstname");
			String lastName=associateRS.getString("lastname");
			String department=associateRS.getString("department");
			String designation=associateRS.getString("designation");
			String pancard=associateRS.getString("pancard");
			String emailId=associateRS.getString("emailId");
			Associate associate=new Associate(associateID, yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId);
			PreparedStatement pstmt2=conn.prepareStatement("Select * from BankDetails where associateId="+associateID);
			ResultSet bankdetailsRs=pstmt2.executeQuery();
			bankdetailsRs.next();
			
			int accountNumber=bankdetailsRs.getInt("accountNumber");
			String bankName=bankdetailsRs.getString("bankName");
			String ifscCode=bankdetailsRs.getString("ifscCode");
			associate.setBankDetails(new BankDetails(accountNumber, bankName, ifscCode));
			
			PreparedStatement pstmt3 = conn.prepareStatement("select * from Salary where associateId="+associateID);
			
			
			ResultSet salaryRS =pstmt3.executeQuery();
			salaryRS.next();
			associate.setSalary(new Salary(salaryRS.getInt("basicSalary"), salaryRS.getInt("hra"), salaryRS.getInt("conveyenceAllowance"), salaryRS.getInt("otherAllowance"), salaryRS.getInt("personalAllowance"), salaryRS.getInt("monthlyTax"), salaryRS.getInt("epf"), salaryRS.getInt("companyPf"), salaryRS.getInt("grossSalary"), salaryRS.getInt("netSalary")));
			
			return associate;
		}
		return associates.get(associateID);
	}

	@Override
	public ArrayList<Associate> findAll() throws SQLException {
		PreparedStatement pstmt1 = conn.prepareStatement("Select * from Associate");
		ResultSet associateRS = pstmt1.executeQuery();
		
		ArrayList<Associate> associates = new ArrayList<>();
		while(associateRS.next()) {
			
			int associateId = associateRS.getInt("associateId");
			String firstName=associateRS.getString("firstName");
			String lastName=associateRS.getString("lastName");
			String department=associateRS.getString("department");
			String designation=associateRS.getString("designation");
			String pancard=associateRS.getString("pancard");
			String emailId=associateRS.getString("emailId");
			int yearlyInvestmentUnder80C=associateRS.getInt("yearlyInvestmentUnder80C");
			Associate associate = new Associate(associateId, yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId, null, null);
			
			PreparedStatement pstmt2 = conn.prepareStatement("Select * from BankDetails where associateId="+associateId);
			ResultSet bankdetailsRs=pstmt2.executeQuery();
			bankdetailsRs.next();
			
			int accountNumber=bankdetailsRs.getInt("accountNumber");
			String bankName=bankdetailsRs.getString("bankName");
			String ifscCode=bankdetailsRs.getString("ifscCode");
			associate.setBankDetails(new BankDetails(accountNumber, bankName, ifscCode));
			PreparedStatement pstmt3 = conn.prepareStatement("select * from Salary where associateId="+associateId);
			ResultSet salaryRS =pstmt3.executeQuery();
			salaryRS.next();
			associate.setSalary(new Salary(salaryRS.getInt("basicSalary"), salaryRS.getInt("hra"), salaryRS.getInt("conveyenceAllowance"), salaryRS.getInt("otherAllowance"), salaryRS.getInt("personalAllowance"), salaryRS.getInt("monthlyTax"), salaryRS.getInt("epf"), salaryRS.getInt("companyPf"), salaryRS.getInt("grossSalary"), salaryRS.getInt("netSalary")));
			associates.add(associate);
		}
		return associates;
	}

	@Override
	public boolean update(Associate associate) throws SQLException {
		PreparedStatement pstmt1=conn.prepareStatement("update salary set hra=?,otherAllowance=?,personalAllowance=?,conveyenceAllowance=?,monthlyTax=?,grossSalary=?,netSalary=? where associateID=?");
		pstmt1.setInt(1, (int) (0.3*associate.getSalary().getBasicSalary()));
		pstmt1.setInt(2, (int) (0.3*associate.getSalary().getBasicSalary()));
		pstmt1.setInt(3, (int) (0.2*associate.getSalary().getBasicSalary()));
		pstmt1.setInt(4, (int) (0.2*associate.getSalary().getBasicSalary()));
		pstmt1.setInt(5, (int) (0.2*associate.getSalary().getBasicSalary()));
		pstmt1.setInt(6, (int) (0.2*associate.getSalary().getBasicSalary()));
		pstmt1.setInt(7, (int) (0.2*associate.getSalary().getBasicSalary()));
		pstmt1.executeUpdate();
		return false;
	}

}
