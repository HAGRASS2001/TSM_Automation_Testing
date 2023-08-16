package Sim;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import CommonStepsNG.LoginNG;
import CommonStepsNG.StrapiLoginNG;
import CommonStepsNG.UpdatePlan123NG;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class AddBundleCreditCheckNG {
	private WebDriver driver;
	private ObjectMapper objectMapper = new ObjectMapper();
	private ObjectMapper objectMapper2 = new ObjectMapper();
	private String jobname = "";
	private String BundleBalanceFromJson = "";
	private String json = "";
	private String json2 = "";
	private String BalanceFromJson = "";
	private String Balance = "";
	private String BundleBalance = "";
	private String jobID = "";
	private String jobID2 = "";
	private String jobtype = "";
	private String jobStatus = "";
	private String JobRunningMode = "";
	private String jobtype2 = "";
	private String jobStatus2 = "";
	private String JobRunningMode2 = "";
	private String jobid = "";
	private String jobid2 = "";

	@Test
	public void AddBundleCreditCheckNG() throws InterruptedException, JsonMappingException, JsonProcessingException {
		LoginNG login = new LoginNG(driver);

		// update balance and bundle in sim plan 123
		UpdatePlan123NG UpdatePlan123 = new UpdatePlan123NG(driver, 400, 300);
		UpdatePlan123.UpdatePlan123();

		Thread.sleep(2000);

		// click on sim in left nav bar
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div/div[1]/a")).click();
		// click on tableview
		driver.findElement(By.xpath("//*[@id=\"dropdown-button-dark-example1\"]")).click();
		// choose customview2
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/form/div[4]/div[1]/div/div/a[5]"))
				.click();
		// click on action DropDown on specific record
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[20]/div/div/div/div/select"))
				.click();

		// select update action
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[20]/div/div/div/div/select/option[11]"))
				.click();
		// click on sim plan dropwodn list
		driver.findElement(By.xpath("//*[@id=\"sims-sim_plan\"]")).click();
		// choose plan123
		driver.findElement(By.cssSelector("#sims-sim_plan > option:nth-child(3)")).click();
		// click on gateway dropdown list
		driver.findElement(By.xpath("//*[@id=\"sims-gateway\"]")).click();
		// choose TR-us-test 3
		driver.findElement(By.xpath("//*[@id=\"1592\"]")).click();
		// click save button
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/button"))
				.click();
		// click ok from popup
		driver.findElement(By.xpath("/html/body/div[4]/div/div[4]/div/button")).click();
		// click on back button
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/a")).click();
		// choose customview2
		driver.findElement(By.xpath("//*[@id=\"dropdown-button-dark-example1\"]")).click();
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/form/div[4]/div[1]/div/div/a[5]"))
				.click();

		// click on action DropDown on specific record
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[11]/td[20]/div/div/div/div/select"))
				.click();
		// select Add Bundle only + credit check action
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[20]/div/div/div/div/select/option[6]"))
				.click();

		Thread.sleep(5000);

		// click on ok popup (there is an error here)
		driver.findElement(By.xpath("/html/body/div[4]/div/div[4]/div/button")).click();

		// wait 1 min to see the record in sim logs
		Thread.sleep(180000);

		// click on sim logs
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div/div[6]/a")).click();
		// click on entry drop down
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[3]/label/select"))
				.click();
		// choose 100
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[3]/label/select/option[2]"))
				.click();

		// get job name
		jobname = driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[20]/td[2]"))
				.getText();

		// click on show data
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[2]/td[5]/button"))
				.click();

		// get json for bundle balance from simlog
		json = driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[2]/td[5]/div/div/div/div[2]"))
				.findElement(By.tagName("textarea")).getAttribute("value");

		JsonNode rootNode = objectMapper.readTree(json);
		JsonNode simAfter = rootNode.get("simAfter");
		BundleBalanceFromJson = simAfter.get("bundle_balance").asText();
		try {
			// click on close data
			driver.findElement(By.xpath(
					"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[2]/td[5]/div/div/div/div[1]/button"))
					.click();
			driver.findElement(By.xpath(
					"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[2]/td[5]/div/div/div/div[1]/button"))
					.click();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[8]/td[5]/button"))
				.click();
		// get json for balance from simlog
		json2 = driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[8]/td[5]/div/div/div/div[2]"))
				.findElement(By.tagName("textarea")).getAttribute("value");

		JsonNode rootNode2 = objectMapper2.readTree(json2);
		JsonNode simAfter2 = rootNode2.get("simAfter");
		BalanceFromJson = simAfter2.get("balance").asText();

		// click on close data
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[8]/td[5]/div/div/div/div[1]/button"))
				.click();
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[8]/td[5]/div/div/div/div[1]/button"))
				.click();
		// driver.findElement(By.cssSelector("#dataModel-59549148 .btn")).click();
		Thread.sleep(5000);
		// click on sim in left nav bar
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div/div[1]/a")).click();
		// click on tableview
		driver.findElement(By.xpath("//*[@id=\"dropdown-button-dark-example1\"]")).click();
		// choose customview2
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/form/div[4]/div[1]/div/div/a[5]"))
				.click();
		// get bundle balance from table
		BundleBalance = driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[10]"))
				.getText();
		// get balance from table
		Balance = driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[12]"))
				.getText();

		Thread.sleep(2000);
		
		// job monitor
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div/div[9]/a")).click();
		// click on completed
		try {
			driver.findElement(By.linkText("Jobs Monitor")).click();
			driver.switchTo().frame(0);
			driver.findElement(By.cssSelector(".MuiButtonBase-root:nth-child(3) > .MuiChip-label")).click();
			{
				WebElement element = driver.findElement(By.id("jobs-filters_order"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).clickAndHold().perform();
			}
			{
				WebElement element = driver.findElement(By.cssSelector(".MuiBackdrop-root"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).release().perform();
			}
			driver.findElement(By.cssSelector("body")).click();
			driver.findElement(By.cssSelector(".MuiMenuItem-root:nth-child(1)")).click();
			driver.findElement(By.cssSelector(".MuiTableRow-root:nth-child(2) .jss28")).getText();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@id=\"jobs-filters_order\"]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[1]")).click();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		// get the json for first job
		String jobMonitorJson = driver
				.findElement(By.xpath("/html/body/div/div/main/div[4]/div[2]/table/tbody/tr[2]/td/div/pre")).getText();
		JsonNode rootNode3 = objectMapper.readTree(jobMonitorJson);
		jobID = rootNode3.get("jobId").asText();

		// get the json for first job
		String jobMonitorJson2 = driver
				.findElement(By.xpath("/html/body/div/div/main/div[4]/div[2]/table/tbody/tr[4]/td/div/pre")).getText();
		JsonNode rootNode4 = objectMapper.readTree(jobMonitorJson2);
		jobID2 = rootNode4.get("jobId").asText();

		// login to strapi
		StrapiLoginNG loginST = new StrapiLoginNG(driver);

		// click on content manager
		driver.findElement(By.xpath("/html/body/div/div[2]/div/nav/div[1]/ul/li[1]/a")).click();
		// click in jobs
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/nav/div[2]/ol/li[1]/div/ol/li[4]/a")).click();
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[2]/div/div/div/div/main/div[3]/div[1]/div/div/table/thead/tr/th[2]/div/span[1]/button"))
				.click();
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[2]/div/div/div/div/main/div[3]/div[1]/div/div/table/thead/tr/th[2]/div/span[2]/span/button"))
				.click();

		jobid = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/main/div[3]/div[1]/div/div/table/tbody/tr[1]/td[2]"))
				.getText().replaceAll(",", "");
		if (jobid.equals(jobID)) {
			jobtype = driver.findElement(By.xpath(
					"/html/body/div[1]/div[2]/div/div/div/div/main/div[3]/div[1]/div/div/table/tbody/tr[1]/td[3]"))
					.getText();
			jobStatus = driver.findElement(By.xpath(
					"/html/body/div[1]/div[2]/div/div/div/div/main/div[3]/div[1]/div/div/table/tbody/tr[1]/td[4]"))
					.getText();
			JobRunningMode = driver.findElement(By.xpath(
					"/html/body/div[1]/div[2]/div/div/div/div/main/div[3]/div[1]/div/div/table/tbody/tr[1]/td[5]"))
					.getText();
		}

		jobid2 = driver.findElement(By.xpath(
				"/html/body/div[1]/div[2]/div/div/div/div/main/div[3]/div[1]/div/div/table/tbody/tr[2]/td[2]/span"))
				.getText().replaceAll(",", "");
		if (jobid2.equals(jobID2)) {
			jobtype2 = driver.findElement(By.xpath(
					"/html/body/div[1]/div[2]/div/div/div/div/main/div[3]/div[1]/div/div/table/tbody/tr[2]/td[3]"))
					.getText();
			jobStatus2 = driver.findElement(By.xpath(
					"/html/body/div[1]/div[2]/div/div/div/div/main/div[3]/div[1]/div/div/table/tbody/tr[2]/td[4]"))
					.getText();
			JobRunningMode2 = driver.findElement(By.xpath(
					"/html/body/div[1]/div[2]/div/div/div/div/main/div[3]/div[1]/div/div/table/tbody/tr[2]/td[5]"))
					.getText();
		}

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
		System.out.println( "add B C C" + jobname + " " + BundleBalance + " " + Balance + " " + BalanceFromJson + " " + BundleBalanceFromJson + " \n " 
						 + jobtype + " " + jobStatus + " " + JobRunningMode + " " + jobid + " " + jobID + " \n " + 
				           jobtype2 + " " + jobStatus2 + " " + JobRunningMode2 + " " + jobid2 + " " + jobID2);

		if (BundleBalance.equals("300") & Balance.equals("400") & BalanceFromJson.equals("400")
				& BundleBalanceFromJson.equals("300")
				& (jobtype.equals("1") & jobStatus.equals("3") & JobRunningMode.equals("2"))
				& (jobtype2.equals("12") & jobStatus2.equals("3") & JobRunningMode2.equals("2"))) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
			throw new AssertionError("Condition not true. Test failed.");
		}
	}

}
