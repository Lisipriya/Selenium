import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators {

	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("login")).click();		
		driver.findElement(By.xpath("//*[@id='error_box']/div[2]/a")).click();
		driver.findElement(By.cssSelector("#u_0_1a > div > input[type=radio]")).click();
		driver.quit();
	}
	public static void main2(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","C:\\Program Files\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("pw")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getText());
		driver.quit();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/");
		
		//code using regular expression
		driver.findElement(By.cssSelector("input[type*='email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//div[contains(@class,'VfPpkd')]")).click();
		driver.get("https://google.com/");
		
		// Code using parent branch navigation
		driver.findElement(By.xpath("//div[contains(@class,'FPdoLc')]/center/input[2]")).click();
		driver.quit();
	}
	
}