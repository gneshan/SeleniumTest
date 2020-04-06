package testNGPractice;

import org.testng.annotations.Test;

public class DependanciesExample {
	
	@Test
	public void elementarySchool() {
		System.out.println("Elementary School Education");

	}
	@Test(dependsOnMethods = "elementarySchool")
	public void primarySchool() {
		System.out.println("Primary School Education");

	}
	@Test(dependsOnMethods = "primarySchool")
	public void higherSecondarySchool() {
		System.out.println("HigherSecondary School Education");

	}
	@Test(dependsOnMethods = "higherSecondarySchool")
	public void college() {
		System.out.println("College Education");

	}
	
	
	
	}
