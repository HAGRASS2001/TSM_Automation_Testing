package Sim;

import org.testng.annotations.Test;

import CommonStepsNG.LoginNG;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;

public class UpdateSimNG {
	public WebDriver driver;

	@Test
	public void UpdateSimNG() {
		LoginNG login = new LoginNG(driver);
		// click on sim in left nav bar
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div/div[1]/a")).click();
		// click on action DropDown on specific record
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[20]/div/div/div/div/select"))
				.click();

		// select update action
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[20]/div/div/div/div/select/option[11]"))
				.click();

		// click on IMSI input
		driver.findElement(By.xpath("//*[@id=\"sims-imsi\"]")).click();
		// add 10 to the old valie
		driver.findElement(By.xpath("//*[@id=\"sims-imsi\"]")).sendKeys("10");
		// click on save
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/button"))
				.click();
		// click on ok in popup
		driver.findElement(By.xpath("/html/body/div[4]/div/div[4]/div/button")).click();
		// go back to sim table
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/a")).click();

		// click on tableview
		driver.findElement(By.xpath("//*[@id=\"dropdown-button-dark-example1\"]")).click();
		// choose customview2
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/form/div[4]/div[1]/div/div/a[5]"))
				.click();

	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.33.0-win64\\geckodriver.exe");

		FirefoxOptions options = new FirefoxOptions();

		options.setBinary("C:\\Users\\manah\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		Proxy proxy = new Proxy();
		proxy.setProxyType(ProxyType.MANUAL);
		proxy.setSocksProxy("127.0.0.1:8080");
		proxy.setSocksVersion(5);
		options.setProxy(proxy);
		//options.setHeadless(true);
		driver = new FirefoxDriver(options);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		//get IMEI from table
		String IMEI = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[13]")).getText();
		//get IMSI from table
		String IMSI = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[15]")).getText();
		
		//check if the IMEI and IMSI same as the input
		if(IMEI.equals("908070") & IMSI.equals("90807010")) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
			throw new AssertionError("Condition not true. Test failed. update");
		}
	}

}
