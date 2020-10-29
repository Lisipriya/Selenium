import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.id("divpaxinfo")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Thread.sleep(1000L);//waits for 1 second
		Select s= new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		s.selectByValue("5");

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		
		
		Select x= new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		x.selectByValue("AED");
		x.selectByIndex(3);
		x.selectByVisibleText("USD");
		driver.close();
	}
}
