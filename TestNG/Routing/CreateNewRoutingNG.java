package Routing;

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

public class CreateNewRoutingNG {
	public WebDriver driver;

	@Test
	public void CreateNewRoutingNG() {
		LoginNG login = new LoginNG(driver);

		// click on routing in left nav bar
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div/div[3]/a")).click();
		// click on add routing
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/button[2]"))
				.click();
		// select Prefix input
		driver.findElement(By.xpath("//*[@id=\"routings-prefix\"]")).click();
		// enter the Prefix value
		driver.findElement(By.xpath("//*[@id=\"routings-prefix\"]")).sendKeys("test2010100");
		// select Description input
		driver.findElement(By.xpath("//*[@id=\"routings-description\"]")).click();
		// enter the Description value
		driver.findElement(By.xpath("//*[@id=\"routings-description\"]")).sendKeys("TestDesc");
		// click on sim dowpdown list
		driver.findElement(By.xpath("//*[@id=\"routings-sim\"]")).click();
		// choose sim from list
		driver.findElement(By.xpath("//*[@id=\"100001227\"]")).click();
		// click on type dowpdown list
		driver.findElement(By.xpath("//*[@id=\"routings-type\"]")).click();
		// choose type from list
		driver.findElement(By.xpath("//*[@id=\"S\"]")).click();
		// click on save
		driver.findElement(By.xpath("//*[@id=\"routings-save_tms_entity\"]")).click();
		// click on ok popup
		driver.findElement(By.xpath("/html/body/div[4]/div/div[4]/div/button")).click();

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
		options.setHeadless(true);
		driver = new FirefoxDriver(options);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		// get Prefix
		String Prefix = driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[2]"))
				.getText();
		// get Description
		String Description = driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[4]"))
				.getText();

		if (Prefix.equals("test2010100") & Description.equals("TestDesc")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
			throw new AssertionError("Condition not true. Test failed.");
		}
	}

}
