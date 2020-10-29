import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2ETicketBooking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.cssSelector("input[value='OneWay']")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='COK']")).click();
		Thread.sleep(1000L);//waits for 1 second
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GOI']")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		driver.findElement(By.id("divpaxinfo")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Thread.sleep(1000L);//waits for 1 second
		Select s= new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		s.selectByValue("5");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Select x= new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		x.selectByValue("INR");
		System.out.println(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[value='Search']")).click();
		//driver.close();
	}

}
