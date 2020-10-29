

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


public class CarWale {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.carwale.com/");
		driver.findElement(By.xpath("//div[contains(@class,'bCRRBE')]/div/div[1]")).click();
		driver.findElement(By.cssSelector("input[placeholder*='select car name']")).sendKeys("Toyota Urban Cruiser");
		Thread.sleep(3000L);//waits for 1 second
		driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div[1]/div/div[2]/div/div/div[2]/div/ul/li[1]/ul/li[1]")).click();
		
	}

}
