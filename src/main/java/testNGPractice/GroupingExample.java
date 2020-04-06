package testNGPractice;

import org.testng.annotations.Test;

public class GroupingExample 	{

	@Test(groups = {"Apple"},priority = 1)
	public void apple1(){
		System.out.println("This is apple test1");
	}
	@Test(priority = 2,groups= {"Apple"})
	public void apple2(){

		System.out.println("This is apple test2");
	}
	@Test(groups= {"Vivo"})
	public void Vivo1(){

		System.out.println("This is Vivo1 test1");
	}
	@Test(groups= {"Vivo"})
	public void Vivo2(){
		System.out.println("This is Vivo2 test2");

	}
	@Test(groups= {"Samsung"})
	public void Samsung1(){
		System.out.println("This is samsung1 test1");

	}
	@Test(groups= {"Samsung"})
	public void Samsung2(){

		System.out.println("This is samsung2 test2");
	}
	@Test(groups= {"Lenovo"})
	public void Lenovo1(){
		System.out.println("This is Lenovo1 test1");

	}
	@Test(groups= {"Lenovo"})
	public void Lenovo2(){
		System.out.println("This is Lenovo1 test2");

	}


}
