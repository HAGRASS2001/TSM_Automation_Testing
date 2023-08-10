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

public class SendUSSDNG {
	public WebDriver driver;

	@Test
	public void SendUSSDNG() {
		LoginNG login = new LoginNG(driver);
		// click on sim in left nav bar
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div/div[1]/a")).click();
		// click on action DropDown on specific record
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[21]/div/div/div/div/select"))
				.click();
		// select send USSD action
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[21]/div/div/div/div/select/option[2]"))
				.click();

		// click on send USSD textarea
		driver.findElement(By.xpath("//*[@id=\"ussd_command\"]")).click();
		// enter the USSD value
		driver.findElement(By.xpath("//*[@id=\"ussd_command\"]")).sendKeys("send USSD test");
		// click on save
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div[2]/button[2]")).click();

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

		// get USSD respond from table
		String USSDRespond = driver.findElement(By.xpath("//*[@id=\"ussd_response\"]")).getText();

		// check if the USSD the same
		if (USSDRespond.equals("send USSD test")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
			throw new AssertionError("Condition not true. Test failed.");
		}
	}

}
