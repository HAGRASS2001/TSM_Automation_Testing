package Gateways;

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

public class CreateNewGatewayNG {
	public WebDriver driver;
  @Test
  public void CreateNewGatewayNG() {
	  LoginNG login = new LoginNG(driver);
		//click on Gateways  in left nav bar
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div/div[4]/a")).click();
		//click on add gateway
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/button[2]")).click();
		//click on IP on input
		driver.findElement(By.xpath("//*[@id=\"gateways-ip\"]")).click();
		//enter the Ip value
		driver.findElement(By.xpath("//*[@id=\"gateways-ip\"]")).sendKeys("198.66.10.111");
		
		//click on Secondary IP on input
		driver.findElement(By.xpath("//*[@id=\"gateways-secondary_ip\"]")).click();
		//enter the Secondary ip value
		driver.findElement(By.xpath("//*[@id=\"gateways-secondary_ip\"]")).sendKeys("192.66.200.220");
		
		//click on Name on input
		driver.findElement(By.xpath("//*[@id=\"gateways-name\"]")).click();
		//enter the Secondary ip value
		driver.findElement(By.xpath("//*[@id=\"gateways-name\"]")).sendKeys("NPA");

		//click on Location on input
		driver.findElement(By.xpath("//*[@id=\"gateways-location\"]")).click();
		//enter the Location value
		driver.findElement(By.xpath("//*[@id=\"gateways-location\"]")).sendKeys("USA");
		
		//click on Capacity on input
		driver.findElement(By.xpath("//*[@id=\"gateways-capacity\"]")).click();
		//enter the Capacity value
		driver.findElement(By.xpath("//*[@id=\"gateways-capacity\"]")).sendKeys("4");
		
		//click on Remarks on input
		driver.findElement(By.xpath("//*[@id=\"gateways-remarks\"]")).click();
		//enter the Remarks value
		driver.findElement(By.xpath("//*[@id=\"gateways-remarks\"]")).sendKeys("rr");
		
		//click on Country on dropdown
		driver.findElement(By.xpath("//*[@id=\"gateways-country\"]")).click();
		//choose from list
		driver.findElement(By.xpath("//*[@id=\"1\"]")).click();
		
		
		//click on save
		driver.findElement(By.xpath("//*[@id=\"gateways-save_tms_entity\"]")).click();
		//click on ok popup
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
		//get IP
		String IP = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[2]")).getText();
		//get Secondary IP 
		String SecondaryIP = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[3]")).getText();

		if(IP.equals("198.66.10.111") & SecondaryIP.equals("192.66.200.220")) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
			throw new AssertionError("Condition not true. Test failed.");
		}
  }

}
