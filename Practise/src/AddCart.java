import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String[] vegetables = {"Cauliflower","Carrot","Mushroom","Strawberry"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000L);
		List<WebElement> items=driver.findElements(By.cssSelector("h4.product-name"));
		int x=0;
		for(int i=0;i<items.size();i++)
		{
			String[] value=items.get(i).getText().split("-");
			String convertedValue= value[0].trim();
			List veggies = Arrays.asList(vegetables);
			//array list count code eg:int count = veggies.size();
			if(veggies.contains(convertedValue))
			{
				x++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(x==vegetables.length) {
					break;
				}
					
			}
				
		}
		
		
	}

}
