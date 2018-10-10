CREATE TABLE Associate(associateID number(10),yearlyInvestmentUnder80C number(10),firstName varchar2(50),lastName varchar2(50),department varchar2(50),designation varchar2(50),pancard varchar2(50),emailId varchar2(50),ManagerId number(10));

CREATE TABLE Associate1(associateID number(10),yearlyInvestmentUnder80C number(10),firstName varchar2(50),lastName varchar2(50),department varchar2(50),designation varchar2(50),pancard varchar2(50),emailId varchar2(50),mgr number(10));


CREATE TABLE Account(accountNo number(10) primary key, pinNumber number(10), accountType varchar2(50), status varchar2(50), accountBalance number(10));
CREATE TABLE Transaction(accountNo number(10) references Account(accountNo), transactionId number(10), transactionType varchar2(50), amount number(10));


alter table Associate add constraint primary key(associateID);
alter table Transaction add constraint PK_TransId primary key(transactionID);

CREATE TABLE BankDetails(associateID number(10) references associate(associateID),accountNumber number(15) primary key,bankName varchar2(50),ifscCode varchar2(50));
CREATE TABLE BankDetails(associateID number(10) ,accountNumber number(15),bankName varchar2(50),ifscCode varchar2(50));


CREATE SEQUENCE ACCNO_SEQ
start with 10143300
increment by 1
minvalue 1
maxvalue 10243300
nocycle;

CREATE SEQUENCE PINNO_SEQ
start with 1000
increment by 1
minvalue 1
maxvalue 9999
nocycle;

CREATE SEQUENCE TRANSID_SEQ
start with 13221324
increment by 1
minvalue 1
maxvalue 23221324
nocycle;


alter table BankDetails add primary key(accountNumber);


CREATE TABLE Salary(associateID number(10) references associate(associateID),
 basicSalary number(10),
 hra number(10),
 conveyenceAllowance number(10),
 otherAllowance number(10),
 personalAllowance number(10),
 monthlyTax number(10),
 epf number(10),
 companyPf number(10),
 gratutity number(10),
 grossSalary number(10),
 netSalary number(10)); 
 
 CREATE TABLE Salary(associateID number(10),
 basicSalary number(10),
 hra number(10),
 conveyenceAllowance number(10),
 otherAllowance number(10),
 personalAllowance number(10),
 monthlyTax number(10),
 epf number(10),
 companyPf number(10),
 gratutity number(10),
 grossSalary number(10),
 netSalary number(10)); 



CREATE TABLE Customer(customerID number(10) primary key,firstName varchar2(50),lastName varchar2(50),mobileNo number(10),emailId varchar2(50), adharNo number(12),pancardNo number(12),dateOfBirth date);


CREATE TABLE Address(city varchar2(50),state varchar2(50),pinCode number(10), country varchar2(50));
alter table Address 
					add customerID number(10) references Customer(customerID); 

CREATE TABLE Account(accountNo number(15) Primary Key,accountBalance number(20),accountType varchar2(50));
alter table Account 
					add customerID number(10) references Customer(customerID);

CREATE TABLE Transaction(transactionID number(10),timeStamp timestamp(0),amount number(20),transactionType varchar2(50),transactionLocation varchar2(50),modeOfTransaction varchar2(50),transactionStatus varchar2(50));
alter table Transaction add constraint TransID_PK primary key(transactionID);

CREATE TABLE PostPaidAccount(mobileNo number(10) primary key);
alter table PostPaidAccount add customerID references Customer(customerID) add PlanId references Plan(PlanId);


CREATE TABLE Plan(planID number(10),monthlyRental number(10),freeLocalCalls number(10),freeStdCalls number(10),freeLocalSMS number(10),freeStdSMS number(10), freeInternetDataUsageUnits number(10),localCallRate number(10),stdCallRate number(10),localSMSRate number(10),stdSMSRate number(10),internetDataUsageRate number(10));
alter table Plan add constraint planID_PK primary key(planID);


CREATE TABLE Bill(billID number(10),noOfLocalSMS number(10),noOfStdSMS number(10),noOfLocalCalls number(10),noOfStdCalls number(10), InternetDataUsageUnits number(10),InternetDataUsageUnitsAmount number(10),billMonth varchar2(20),stateGST number(10),centralGST number(10),totalBillAmount number(20), localSMSAmount number(10), stdSMSAmount number(10), localCallAmount number(10));
alter table Bill add constraint primary key(billID);
alter table Bill add planID references Plan(PlanID);

select a.associateId, a.firstname,b.bankname 
	from Associate a join Bankdetails b 
		on	a.associateId=b.associateId;
		
		
		
		

		
select a.associateId, a.firstname,b.bankname 
	from Associate a left join Bankdetails b 
		on	a.associateId=b.associateId;
		
		
select a.associateId, a.firstname,b.bankname 
	from Associate a right join Bankdetails b 
		on	a.associateId=b.associateId;
		
select * 
	from Associate a right join Bankdetails b 
		on	a.associateId=b.associateId;
		
		
		
		
		
		
select mgr from associate1 group by mgr having count(associateId)=(select max(mycount) from (select count(associateId) mycount from associate1 group by mgr));