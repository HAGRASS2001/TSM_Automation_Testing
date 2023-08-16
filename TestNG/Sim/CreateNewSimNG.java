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

public class CreateNewSimNG {
	public WebDriver driver;

	@Test
	public void CreateNewSimNG() throws InterruptedException {
		LoginNG login = new LoginNG(driver);

		// click on sim in left nav bar
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div/div[1]/a")).click();
		// click on add sim
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/button[2]"))
				.click();
		// select IMSI input
		driver.findElement(By.xpath("//*[@id=\"sims-imsi\"]")).click();
		// enter the IMSI value
		driver.findElement(By.xpath("//*[@id=\"sims-imsi\"]")).sendKeys("90807110000");
		// select IMEI input
		driver.findElement(By.xpath("//*[@id=\"sims-imei\"]")).click();
		// enter the IMEI value
		driver.findElement(By.xpath("//*[@id=\"sims-imei\"]")).sendKeys("90807110000");
		// select Subscriber num input
		driver.findElement(By.xpath("//*[@id=\"sims-subscriber_num\"]")).click();
		// enter the Subscriber num value
		driver.findElement(By.xpath("//*[@id=\"sims-subscriber_num\"]")).sendKeys("90807110000");
		// state admin checkbox (note: to click the checkbox i should click it twice for
		// unknown reason)
		driver.findElement(By.xpath("//*[@id=\"sims-state_admin\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"sims-state_admin\"]")).click();
		// Calls enabled checkbox
		driver.findElement(By.xpath("//*[@id=\"sims-call_enabled\"]")).click();
		// uncheck no push to gateway
		driver.findElement(By.xpath("//*[@id=\"sims-noPushToGateway\"]")).click();
		// open dropdown list
		driver.findElement(By.xpath("//*[@id=\"sims-carrier\"]")).click();
		// choose the Carrier
		driver.findElement(By.xpath("//*[@id=\"c1\"]")).click();
		// click on Minutes remaining
		driver.findElement(By.xpath("//*[@id=\"sims-minutes_remaining\"]")).click();
		// enter the Minutes remaining num value
		driver.findElement(By.xpath("//*[@id=\"sims-minutes_remaining\"]")).sendKeys("500");
		// click on Bundle minutes remaining
		driver.findElement(By.xpath("//*[@id=\"sims-bundle_minutes_remaining\"]")).click();
		// enter Bundle minutes remaining num value
		driver.findElement(By.xpath("//*[@id=\"sims-bundle_minutes_remaining\"]")).sendKeys("800");

		// click on Registration time
		driver.findElement(By.xpath("//*[@id=\"sims-registration_time\"]")).click();
		// enter Registration time num value
		driver.findElement(By.xpath("//*[@id=\"sims-registration_time\"]")).sendKeys("20");

		// click on Call attempts total
		driver.findElement(By.xpath("//*[@id=\"sims-call_attempts_total\"]")).click();
		// enter Call attempts total num value
		driver.findElement(By.xpath("//*[@id=\"sims-call_attempts_total\"]")).sendKeys("50");

		// click on Call attempts connected
		driver.findElement(By.xpath("//*[@id=\"sims-call_attempts_connected\"]")).click();
		// enter Call attempts connected num value
		driver.findElement(By.xpath("//*[@id=\"sims-call_attempts_connected\"]")).sendKeys("50");

		// click on IQSIM host
		driver.findElement(By.xpath("//*[@id=\"sims-IQSIM_Host\"]")).click();
		// choose ip on IQSIM host
		driver.findElement(By.xpath("//*[@id=\"1\"]")).click();

		// click on Rack Position
		driver.findElement(By.xpath("//*[@id=\"sims-IQSIM_Value\"]")).click();
		// enter Rack Position num value
		driver.findElement(By.xpath("//*[@id=\"sims-IQSIM_Value\"]")).sendKeys("90807110000");

		// click on Sim plan
		driver.findElement(By.xpath("//*[@id=\"sims-sim_plan\"]")).click();
		// choose Sim plan
		driver.findElement(By.xpath("//*[@id=\"99\"]")).click();

		// click on Gateway
		driver.findElement(By.xpath("//*[@id=\"sims-gateway\"]")).click();
		// choose Gateway
		driver.findElement(By.xpath("//*[@id=\"1193\"]")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// click on save
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[3]/div/button[2]"))
				.click();

		// wait 3 sec
		Thread.sleep(10000);

		// click on ok from popup
		driver.findElement(By.xpath("/html/body/div[4]/div/div[4]/div/button")).click();

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
		options.setHeadless(true);
		driver = new FirefoxDriver(options);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void afterMethod() {
		//get IMEI from table
		String IMEI = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[13]")).getText();
		//get IMSI from table
		String IMSI = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[15]")).getText();

		System.out.println(IMEI);
		System.out.println(IMSI);
		
		//check if the IMEI and IMSI same as the input
		if(IMEI.equals("90807110000") & IMSI.equals("90807110000")) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
			throw new AssertionError("Condition not true. Test failed create.");
		}
	}

}
