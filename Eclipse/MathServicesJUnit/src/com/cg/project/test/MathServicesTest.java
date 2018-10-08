package com.cg.project.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.project.exceptions.InvalidNumberRangeException;
import com.cg.project.mathservices.MathServices;
import com.cg.project.mathservices.MathServicesImpl;

public class MathServicesTest {
static MathServices mathServices;
	@BeforeClass
	public static void setUPTestEnv(){
		//System.out.println("setUPTestEnv()");
		mathServices = new MathServicesImpl();
	}
	@Before
	public void setUPMockDataforTest(){
		//System.out.println("setUPMockDataforTest()");
	}
	@Test(expected=InvalidNumberRangeException.class)
	public void testAddNumbersForFirstNOInvalid() throws InvalidNumberRangeException{
		//System.out.println("test1()");
		mathServices.addNums(-100, 200);
	}
	@Test(expected=InvalidNumberRangeException.class)
	public void testAddNumbersForSecondNOInvalid() throws InvalidNumberRangeException{
		//System.out.println("test1()");
		mathServices.addNums(100, -200);
	}
	@Test
	public void testAddNumbersForBothValidNo() throws InvalidNumberRangeException{
		//System.out.println("test1()");
		int temp = mathServices.addNums(100, 200);
		Assert.assertEquals(300, temp);
	}
	
	@Test(expected=InvalidNumberRangeException.class)
	public void testSubNumbersForFirstNOInvalid() throws InvalidNumberRangeException{
		//System.out.println("test1()");
		mathServices.subNums(-100, 200);
	}
	@Test(expected=InvalidNumberRangeException.class)
	public void testSubNumbersForSecondNOInvalid() throws InvalidNumberRangeException{
		//System.out.println("test1()");
		mathServices.subNums(100, -200);
	}
	@Test
	public void testSubNumbersForBothValidNo() throws InvalidNumberRangeException{
		//System.out.println("test1()");
		int temp = mathServices.subNums(200, 100);
		Assert.assertEquals(100, temp);
	}
	
	@Test(expected=InvalidNumberRangeException.class)
	public void testMultiNumbersForFirstNOInvalid() throws InvalidNumberRangeException{
		//System.out.println("test1()");
		mathServices.multiNums(-100, 200);
	}
	@Test(expected=InvalidNumberRangeException.class)
	public void testMultiNumbersForSecondNOInvalid() throws InvalidNumberRangeException{
		//System.out.println("test1()");
		mathServices.multiNums(100, -200);
	}
	@Test
	public void testMultiNumbersForBothValidNo() throws InvalidNumberRangeException{
		//System.out.println("test1()");
		int temp = mathServices.multiNums(10, 20);
		Assert.assertEquals(200, temp);
	}
	@After
	public void tearDownMockDataForTest(){
		//System.out.println("tearDownMockDataForTest()");
	}
	@AfterClass
	public static void tearDownTestEnv(){
		//System.out.println("tearDownTestEnv()");
		mathServices = null;
	}

}
