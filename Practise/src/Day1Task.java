import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Day1Task {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//*[@id='searchDropdownBox']/option[18]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='searchDropdownBox']/option[18]")).getText(), "Furniture");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Chairs for computer table");
		driver.findElement(By.xpath("//*[@value='Go']")).click();
		List<WebElement> myChair=driver.findElements(By.className("a-price-whole"));
	    List<Integer> all_chair=new ArrayList<>();
	    HashMap<Integer, String> hmap = new HashMap<Integer, String>();
	    for(int i=0; i<myChair.size(); i++){
	    	String strChairPrice = myChair.get(i).getText();
	    	int intChairPrice = Integer.parseInt(strChairPrice.replace(",", ""));
	    	hmap.put(intChairPrice, strChairPrice);
	    	all_chair.add(Integer.parseInt(myChair.get(i).getText().replace(",", "")));	       
	    }
	    for (int i=0; i<myChair.size(); i++) {
	    	String strChairPrice = myChair.get(i).getText();
	    	if(strChairPrice.contains(hmap.get(Collections.max(all_chair))))
			{
	    		driver.findElements(By.className("a-price-whole")).get(i).click();
			}
	    }
	    Thread.sleep(5000L);
	    Set<String> tab = driver.getWindowHandles();
	    Iterator<String> page = tab.iterator();
	    while(page.hasNext())
	    {
	    	driver.switchTo().window(page.next());			
	    }	    
	    System.out.println("The Highest Priced Chair Name in Page1: "+driver.findElement(By.xpath("//*[@id='productTitle']")).getText().trim());
	    driver.findElement(By.cssSelector("[class*='5star']")).click();
	    System.out.println("Number of 5 Start Rating & Reviews: "+driver.findElement(By.xpath("//*[@id='filter-info-section']/div[2]/span")).getText().trim());
	    
}
}
