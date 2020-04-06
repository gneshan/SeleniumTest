package testNGPractice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrizationExample {
	
	@Test
	@Parameters("Name")
	public void parameter(String name) {
		System.out.println("My name is " + name);
		
	}

}
