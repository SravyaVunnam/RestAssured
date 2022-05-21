package com.rmgyantra.GenericLibrary;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseApiClass implements EndPoints {

	public DataBaseUtility dataBaseUtility=new DataBaseUtility();
	
	@BeforeSuite
	public void connectDB() throws Throwable
	{
	dataBaseUtility.createConn();
	}
	
	@AfterSuite
	public void closeDB() throws Throwable
	{
		dataBaseUtility.closeConnectio();
	}
}
