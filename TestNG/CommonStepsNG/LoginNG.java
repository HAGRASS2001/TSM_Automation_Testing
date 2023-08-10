package CommonStepsNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class LoginNG {

  WebDriver driver;
	
  public LoginNG(WebDriver driver) {
	this.driver = driver;
	this.beforeMethod();
	this.login();
	this.afterMethod();
  }
  @Test
  public void login() {
		
	driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/form/div[3]/input")).click();
		
	driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/form/div[3]/input")).sendKeys("tmsv4");
		
	driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/form/div[4]/input")).click();
		
	driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/form/div[4]/input")).sendKeys("Tmsv4@123");
		
	driver.findElement(By.xpath("//*[@id=\"kt_sign_in_submit\"]")).click();
  }
  @BeforeMethod
  public void beforeMethod() {
	//Launch Website
	driver.navigate().to("http://172.16.50.158/app/dashboard");

	//Maximize the Browser
	driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  
  }

}
