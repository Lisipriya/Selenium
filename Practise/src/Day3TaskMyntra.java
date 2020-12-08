import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class Day3TaskMyntra {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		printChromeDimension(driver);
		OpenMyntra(driver);
		SearchSunglasses(driver, "Sunglasses");
		Thread.sleep(3000L);
		ClickPolaroid(driver);
		Thread.sleep(4000L);
		PrintProductSize(driver);
		MouseoverSimilarItems(driver);
		PrintSimilarItems(driver);
	}
	public static void printChromeDimension(WebDriver driver){
	   System.out.println("Chrome Dimension before maximize: "+driver.manage().window().getSize()); 
	    driver.manage().window().maximize();
		System.out.println("Chrome Dimension after maximize: "+driver.manage().window().getSize());
	}
	public static void OpenMyntra(WebDriver driver){
		driver.get("http://www.myntra.com/");
	}
	public static void SearchSunglasses(WebDriver driver, String search) {
		driver.findElement(By.cssSelector("input[class*='desktop-searchBar']")).sendKeys(Keys.chord(search, Keys.ENTER));	
	}
	public static void ClickPolaroid(WebDriver driver) throws InterruptedException {
		driver.findElement(By.cssSelector("div[class*='brand-more']")).click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//*[@id='mountRoot']/div/div[1]/main/div[3]/div[1]/section/div/div[4]/div[3]/div[2]/ul/li[77]/label/div")).click();	
	}
	public static void PrintProductSize(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='desktopSearchResults']/div[1]/section/div[1]/div[2]/ul/li[8]/div/span")).click();
		driver.findElement(By.xpath("//*[@id='desktopSearchResults']/div[1]/section/div[1]/div[2]/ul/li[9]/label/span")).click();
		driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[1]/section/div[1]/div[2]/div/ul/li[7]/label/div")).click();
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//*[@id='mountRoot']/div/div[1]/main/div[3]/div[1]/section/div/div[2]/ul/li[1]/label")).click();
		Thread.sleep(3000L);
		System.out.println("The product size of “Men Rectangle Sunglasses "+driver.findElement(By.cssSelector("span[class*='title-count']")).getText());
	}
	public static void MouseoverSimilarItems(WebDriver driver) throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)");
		Actions action = new Actions(driver);		
		List<WebElement> cursor = driver.findElements(By.cssSelector("span[class*='discountedPrice']"));
		action.moveToElement(cursor.get(0));
		List<WebElement> cursor2 = driver.findElements(By.xpath("//span[text()='VIEW SIMILAR']"));
		action.moveToElement(cursor2.get(0));
		Thread.sleep(5000L);
		action.click().build().perform();
	}
	public static void PrintSimilarItems(WebDriver driver) throws InterruptedException{
		Thread.sleep(5000L);
		List<WebElement> similar = driver.findElements(By.cssSelector("li[class*='product-base']"));
		System.out.println("The number of similar items: "+similar.size());
	}


}
