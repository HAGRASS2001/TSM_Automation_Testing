	package SimPlan;

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

public class CreateNewSimPlan {
	public WebDriver driver;
  @Test
  public void CreateNewSimPlan() {
		LoginNG login = new LoginNG(driver);
		
		//click on sim plans in left nav bar
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div/div[2]/a")).click();
		//click on add sim plan
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/button[2]")).click();
		//select name input
		driver.findElement(By.xpath("//*[@id=\"sim_plan-Name\"]")).click();
		//enter the name value
		driver.findElement(By.xpath("//*[@id=\"sim_plan-Name\"]")).sendKeys("vodatest2220");
		//click on Credit check type radio button
		driver.findElement(By.xpath("//*[@id=\"sim_plan-CreditCheckType\"]")).click();
		//click on Credit check running mode dropdown list
		driver.findElement(By.xpath("//*[@id=\"sim_plan-CreditCheckRunningMode\"]")).click();
		//choose Credit check running mode from dropdown list
		driver.findElement(By.xpath("//*[@id=\"1\"]")).click();
		//click on Random credit check start time (HH) input
		driver.findElement(By.xpath("//*[@id=\"sim_plan-random_credit_check_start_time\"]")).click();
		//clear the input to enter the new value
		driver.findElement(By.xpath("//*[@id=\"sim_plan-random_credit_check_start_time\"]")).clear();
		//enter Random credit check start time (HH) value
		driver.findElement(By.xpath("//*[@id=\"sim_plan-random_credit_check_start_time\"]")).sendKeys("4");
		//click on Random credit check end time (HH) input
		driver.findElement(By.xpath("//*[@id=\"sim_plan-random_credit_check_end_time\"]")).click();
		//clear the old value to enter the new value
		driver.findElement(By.xpath("//*[@id=\"sim_plan-random_credit_check_end_time\"]")).clear();
		//enter Random credit check end time (HH) value
		driver.findElement(By.xpath("//*[@id=\"sim_plan-random_credit_check_end_time\"]")).sendKeys("20");
		//click on Random credit check days input
		driver.findElement(By.xpath("//*[@id=\"sim_plan-random_credit_check_days\"]")).click();
		//enter Random credit check days value
		driver.findElement(By.xpath("//*[@id=\"sim_plan-random_credit_check_days\"]")).sendKeys("4");
		//click on credit checks per credit check interval input
		driver.findElement(By.xpath("//*[@id=\"sim_plan-credit_checks_per_credit_check_interval\"]")).click();
		//enter credit checks per credit check interval value
		driver.findElement(By.xpath("//*[@id=\"sim_plan-credit_checks_per_credit_check_interval\"]")).sendKeys("50");
		//click on Every X hours input
		driver.findElement(By.xpath("//*[@id=\"sim_plan-credit_check_hours_interval\"]")).click();
		//enter Every X hours value
		driver.findElement(By.xpath("//*[@id=\"sim_plan-credit_check_hours_interval\"]")).sendKeys("90");
		//click on Credit check command input
		driver.findElement(By.xpath("//*[@id=\"sim_plan-CreditCheckCommand\"]")).click();
		//enter Credit check command value
		driver.findElement(By.xpath("//*[@id=\"sim_plan-CreditCheckCommand\"]")).sendKeys("your credit is $100 and, your bundle is 340 mins");
		//click USSD balance response syntax input
		driver.findElement(By.xpath("//*[@id=\"sim_plan-USSD_BalanceResponseSyntax\"]")).click();
		//enter USSD balance response syntax value
		driver.findElement(By.xpath("//*[@id=\"sim_plan-USSD_BalanceResponseSyntax\"]")).sendKeys("credit is ([0-9]+[.][0-9]+|[0-9]+)");
		//click on credit_check_retry checkbox
		driver.findElement(By.xpath("//*[@id=\"sim_plan-credit_check_retry\"]")).click();
		//click Interval between retries(seconds) input
		driver.findElement(By.xpath("//*[@id=\"sim_plan-credit_check_interval_between_retries\"]")).click();
		//enter Interval between retries(seconds) value
		driver.findElement(By.xpath("//*[@id=\"sim_plan-credit_check_interval_between_retries\"]")).sendKeys("30");
		//click USSD attempt credit before failing input
		driver.findElement(By.xpath("//*[@id=\"sim_plan-USSD_AttemptCreditBeforeFailing\"]")).click();
		//enter USSD attempt credit before failing value
		driver.findElement(By.xpath("//*[@id=\"sim_plan-USSD_AttemptCreditBeforeFailing\"]")).sendKeys("10");
		//click UUSSD maximum credit checks per day input
		driver.findElement(By.xpath("//*[@id=\"sim_plan-USSD_MaximumCreditChecksPerDay\"]")).click();
		//enter USSD maximum credit checks per day value
		driver.findElement(By.xpath("//*[@id=\"sim_plan-USSD_MaximumCreditChecksPerDay\"]")).sendKeys("5");
		//click on Using Bundles checkbox
		driver.findElement(By.xpath("//*[@id=\"sim_plan-credit_check_using_bundles\"]")).click();
		//click on Set Bundle Value To 0 If Omitted From USSD Response check box
		driver.findElement(By.xpath("//*[@id=\"sim_plan-set_bundle_default_value\"]")).click();
		//click USSD bundle balance response syntax input
		driver.findElement(By.xpath("//*[@id=\"sim_plan-USSD_BundleBalanceResponseSyntax\"]")).click();
		//enter USSD bundle balance response syntax value
		driver.findElement(By.xpath("//*[@id=\"sim_plan-USSD_BundleBalanceResponseSyntax\"]")).sendKeys("bundle is ([0-9]+|[0-9]+.[0-9]+) mins");
		//click on save button
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/button")).click();
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
		//get sim plan name
		String SimPlanName = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[2]")).getText();
		
		if(SimPlanName.equals("vodatest2220")) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
			throw new AssertionError("Condition not true. Test failed.");
		}
  }

}
