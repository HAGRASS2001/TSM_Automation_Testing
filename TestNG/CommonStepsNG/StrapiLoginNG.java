package CommonStepsNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class StrapiLoginNG {
	WebDriver driver;

	public StrapiLoginNG(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		this.login();
	}

	@Test
	public void login() {
		// Launch strapi
		driver.navigate().to("http://172.16.50.158/admin/auth/login");

		// Maximize the Browser
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id=\":r1:\"]")).click();

		driver.findElement(By.xpath("//*[@id=\":r1:\"]")).sendKeys("tasv2@tasv2.com");

		driver.findElement(By.xpath("//*[@id=\":r3:\"]")).click();

		driver.findElement(By.xpath("//*[@id=\":r3:\"]")).sendKeys("Tmsv4@123");

		driver.findElement(By.xpath("/html/body/div/div[2]/div/main/div[1]/form/div[2]/button")).click();

	}
}
