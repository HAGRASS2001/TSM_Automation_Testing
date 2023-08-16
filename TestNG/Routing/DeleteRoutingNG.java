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

public class DeleteRoutingNG {
	public WebDriver driver;

	@Test
	public void DeleteRoutingNG() {
		LoginNG login = new LoginNG(driver);
		// click on Routing in left nav bar
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div/div[3]/a")).click();
		// click on action DropDown on specific record
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[6]/div/div/div/div/select"))
				.click();
		// select delete action
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[6]/div/div/div/div/select/option[3]"))
				.click();
		// click on delete button on popup
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div[3]/div/button[2]")).click();
		// click on ok from popup
		driver.findElement(By.xpath("/html/body/div[5]/div/div[4]/div/button")).click();

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

		if (Prefix.equals("t101") & Description.equals("TestDesc")) {
			System.out.println("Fail");
			throw new AssertionError("Condition not true. Test failed.");
		} else {
			System.out.println("Pass");
		}
	}

}
