package com.vicky.Foundations;

import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StringManipulationProject {
	private String AcTransactionMessage="Transaction TN123456 was successful";
	private String AcTransactionStatus="Pending";
	private String AcBusinessName="ABC Ltd.";
	private String AcBankAmount="Rs 1000";
	
	@Before
	public void beforeTest()
	{
		System.out.println("Run Test : "+name.getMethodName());
	}
	
	@After
	public void afterTest()
	{
		System.out.println("Test Complete");
		System.out.println();
	}
	
	@Rule
	public TestName name = new TestName();
	
	
	
	@Test
	public void test01TransactionIgnoreCase()
	{
		try {
			String ExTransactionStatus="pending";
			//Assert.assertEquals(ExTransactionStatus, AcTransactionStatus);
			Assert.assertTrue(ExTransactionStatus.equalsIgnoreCase(AcTransactionStatus));
			System.out.println("Test Passed");
		} 
		catch (AssertionError e) {
			System.out.println("Test Falied");
			Assert.fail();
		}	
	}
	
	@Test
	public void test02TransactionContains()
	{
		try {
			String exTransactionMessage="successful";
			Assert.assertTrue(AcTransactionMessage.contains(exTransactionMessage));
			System.out.println("Test Passed");
		}
		catch (AssertionError e) {
			System.out.println("Test Failed");
			Assert.fail();
		}
	}
	
	@Test
	public void test03TransactionStartWith()
	{
		try {
			String ExTransactionMessage="Transaction";
			Assert.assertTrue(AcTransactionMessage.startsWith(ExTransactionMessage));
			System.out.println("Test Passed");
		} 
		catch (AssertionError e) {
			System.out.println("Test Falied");
			Assert.fail();
		}	
	}
	
	@Test
	public void test04TransactionEndsWith()
	{
		try {
			String ExTransactionMessage="successful";
			Assert.assertTrue(AcTransactionMessage.endsWith(ExTransactionMessage));
			System.out.println("Test Passed");
		} 
		catch (AssertionError e) {
			System.out.println("Test Falied");
			Assert.fail();
		}	
	}
	
	@Test
	public void test05PatternMatch()
	{
		try {
			String regEx="^[a-zA-Z. ]+$";
			Assert.assertTrue(AcBusinessName.matches(regEx));
			System.out.println("Test Passed");
		} 
		catch (AssertionError e) {
			System.out.println("Test Falied");
			Assert.fail();
		}	
	}
	
	public static void main(String[] args) {
	

	}

}
