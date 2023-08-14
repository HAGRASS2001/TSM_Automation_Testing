package CommonStepsNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class UpdatePlan123NG {
	WebDriver driver;
	int balance;
	int bundle;
	
	public UpdatePlan123NG(WebDriver driver, int balance, int bundle) {
		this.driver = driver;
		this.balance = balance;
		this.bundle = bundle;
	}
	
	@Test
	public void UpdatePlan123() throws InterruptedException {
		
		// click on sim plans in left nav bar
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div/div[2]/a")).click();

		// wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// sort to get the first plan (plan123)
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[1]/div/table/thead/tr/th[1]"))
				.click();

		// wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		// click on action DropDown on specific record
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[20]/div/div/div/div/select"))
				.click();
		// select update action
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[20]/div/div/div/div/select/option[2]"))
				.click();

		// click on Credit check command input
		driver.findElement(By.xpath("//*[@id=\"sim_plan-CreditCheckCommand\"]")).click();
		// clear the input
		driver.findElement(By.xpath("//*[@id=\"sim_plan-CreditCheckCommand\"]")).clear();
		// Enter name value
		driver.findElement(By.xpath("//*[@id=\"sim_plan-CreditCheckCommand\"]"))
				.sendKeys("your credit is $" + balance + "and, your bundle is " + bundle + "mins");
		// click on save
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/button"))
				.click();
		// wait 1.5 sec
		Thread.sleep(1500);
	}
}
