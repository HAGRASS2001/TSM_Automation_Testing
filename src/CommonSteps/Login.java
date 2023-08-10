package CommonSteps;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.Proxy;
//import org.openqa.selenium.Proxy.ProxyType;

public class Login {
	
	WebDriver driver;
	
	public Login(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login() throws InterruptedException {
		
		//System.setProperty("webdriver.gecko.driver","D:\\geckodriver-v0.33.0-win64\\geckodriver.exe");    
        
		//FirefoxOptions options = new FirefoxOptions();
		
		//options.setBinary("C:\\Users\\manah\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		//Proxy proxy = new Proxy();
		//proxy.setProxyType(ProxyType.MANUAL);
		//proxy.setSocksProxy("127.0.0.1:8080");
		//proxy.setSocksVersion(5);
		//options.setProxy(proxy);
		
        //WebDriver driver=new FirefoxDriver(options);  
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Launch Website
		driver.navigate().to("http://172.16.50.158/app/dashboard");

		//Maximize the Browser
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/form/div[3]/input")).click();
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/form/div[3]/input")).sendKeys("tmsv4");
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/form/div[4]/input")).click();
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/form/div[4]/input")).sendKeys("Tmsv4@123");
		
		driver.findElement(By.xpath("//*[@id=\"kt_sign_in_submit\"]")).click();
		
		//boolean isdisplayed = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/a/img")).isDisplayed();
		
		/*if(isdisplayed){
			driver.close();
			driver.quit();
		}*/
	}
	
}
