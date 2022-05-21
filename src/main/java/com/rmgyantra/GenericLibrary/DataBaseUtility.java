package com.rmgyantra.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	
	Connection con=null;
	public void createConn() throws Throwable
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	}
	 
	public void closeConnectio() throws Throwable
	{
		con.close();
	}
	
	public ResultSet executeStatement(String query) throws Throwable
	{
		 Statement stmt = con.createStatement();
	      ResultSet result = stmt.executeQuery(query);
	      return result;
	}

}
