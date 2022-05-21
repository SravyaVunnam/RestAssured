package com.rmgyantra.GenericLibrary;

import java.util.Random;

public class JavaUtility {
	
	
	public int generateRandom()
	{
		Random random=new Random();
		int result = random.nextInt(1000);
		return result;
	}

}
