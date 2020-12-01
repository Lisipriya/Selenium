import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Day2TaskRedbus {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		printChromeVersion(driver);
		OpenRedbus(driver);
		EnterDestination(driver, "Chennai (All Locations)");
		EnterSourceAndShiftT(driver, "Bangalore (All Locations)");
		EnterDate(driver, "Jan 2021");
		
		
		//driver.findElement(By.id("dest")).click();
		//driver.findElement(By.id("onward_cal")).click();
		System.out.println("Number of Buses available: "+driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div[1]/span[1]/span")).getText().trim());
		//driver.findElement(By.cssSelector("button[class*='button']")).click();
	}
	
	public static void printChromeVersion(WebDriver driver){
		Capabilities cap = ((ChromeDriver) driver).getCapabilities();
		System.out.println("Chrome Version: "+cap.getVersion());
	}
	
	public static void OpenRedbus(WebDriver driver) {
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
	}
	
	public static void EnterDestination(WebDriver driver, String destination) {
		driver.findElement(By.id("dest")).sendKeys(destination);
	}
	
	public static void EnterSourceAndShiftT(WebDriver driver, String source) {
		driver.findElement(By.id("dest")).sendKeys(Keys.chord(Keys.SHIFT, Keys.TAB, source ));
	}
	public static void EnterDate(WebDriver driver, String MonthYr) {
		driver.findElement(By.id("onward_cal")).click();;
		
		while(!driver.findElement(By.cssSelector("[class='rb-calendar'] [class='monthTitle']")).getText().contains(MonthYr))
		{
		driver.findElement(By.cssSelector("[class='rb-calendar'] td[class='next']")).click();
		}
		LocalDate localDate = LocalDate.of(2021, 1, 1);
		for (int i=0; i<localDate.lengthOfMonth(); i++) {
			if ("Monday".equalsIgnoreCase(localDate.getDayOfWeek().toString())) {
				break;
			}
			localDate = localDate.plusDays(1);
		}
		String FirstMonday = Integer.toString(localDate.getDayOfMonth());
		
		int count=driver.findElements(By.cssSelector("td[class*='day']")).size();

		for(int i=0;i<count;i++)
		{
		String text=driver.findElements(By.cssSelector("td[class*='day']")).get(i).getText();
		if(text.equalsIgnoreCase(FirstMonday))
		{
		driver.findElements(By.cssSelector("td[class*='day']")).get(i).click();
		
		driver.findElement(By.id("onward_cal")).sendKeys(Keys.chord(Keys.TAB));		
		
		driver.findElement(By.id("onward_cal")).sendKeys(Keys.chord(Keys.ENTER));		
		}
		}

	}

}
