package testNGPractice;

import org.testng.annotations.Test;

public class SkipaTestcase {

	@Test(priority = 1)
	public void startCar() {
		System.out.println("Start the car");
	}

	@Test(dependsOnMethods = "startCar")
	public void putFirstGear() {
		System.out.println("First Gear on");
	}
	@Test(priority = 3)
	public void putSecondGear() {
		System.out.println("Second Gear on");
	}
	@Test(priority = 4)
	public void putThirdGear() {
		System.out.println("Third Gear on");
	}
	@Test(priority = 5)
	public void putFourthGear() {
		System.out.println("Fourth Gear on");
	}
	@Test(priority = 6,enabled=false)
	public void turnOnMusic() {
		System.out.println("Start the Music");
	}

}
