package SimPlan;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import CommonSteps.Login;

public class UpdateSimPlan {
	public static void main(String[] args) throws InterruptedException {
			
		System.setProperty("webdriver.gecko.driver","D:\\geckodriver-v0.33.0-win64\\geckodriver.exe");    
	       
		FirefoxOptions options = new FirefoxOptions();
			
		options.setBinary("C:\\Users\\manah\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		Proxy proxy = new Proxy();
		proxy.setProxyType(ProxyType.MANUAL);
		proxy.setSocksProxy("127.0.0.1:8080");
		proxy.setSocksVersion(5);
		options.setProxy(proxy);
			
	    WebDriver driver=new FirefoxDriver(options);  
			
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Login login = new Login(driver);
		login.login();
			
		//click on sim plans in left nav bar
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div/div[2]/a")).click();
		//click on action DropDown on specific record
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[20]/div/div/div/div/select")).click();
		//select update action
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[20]/div/div/div/div/select/option[2]")).click();
		
		//click on name input
		driver.findElement(By.xpath("//*[@id=\"sim_plan-Name\"]")).click();
		//clear the input
		driver.findElement(By.xpath("//*[@id=\"sim_plan-Name\"]")).clear();
		//Enter name value
		driver.findElement(By.xpath("//*[@id=\"sim_plan-Name\"]")).sendKeys("VodaTest");

		//click on save
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/button")).click();
		//click on back
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/a")).click();
		
		//get sim plan name
		String SimPlanName = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[5]/div[2]/table/tbody/tr[1]/td[2]")).getText();
		
		if(SimPlanName.equals("VodaTest")) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
			throw new AssertionError("Condition not true. Test failed.");
		}
	}
}