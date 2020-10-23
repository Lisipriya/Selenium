import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Traversing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com/");
		driver.findElement(By.xpath("//div[contains(@class,'FPdoLc')]/center/input[1]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'FPdoLc')]/center/input[1]/parent::center")).click();
		driver.findElement(By.xpath("//div[contains(@class,'FPdoLc')]/center/input[1]/following-sibling::input[2]")).click();
	}

}
