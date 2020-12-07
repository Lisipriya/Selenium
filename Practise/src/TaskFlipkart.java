import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class TaskFlipkart {

	public static void main(String[] args) throws Exception {	
		// TODO Auto-generated method stub
		Random rand = new Random();
		int firstRandom = rand.nextInt(10);
		int secondRandom = firstRandom + rand.nextInt(15);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		OpenFlipkart(driver);
		HomeTheatersearch(driver, "HomeTheaters");
		Thread.sleep(5000L);
		CountComparision(driver);
		HighToLow(driver);
		Sorting(driver);
		HoverAddToCompare(driver, firstRandom);
		HoverAddToCompare(driver, secondRandom);
		ClickCompare(driver);
		
		//driver.quit();

	}
	public static void OpenFlipkart(WebDriver driver){
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//html/body/div[2]/div/div/button")).click();
	}
	
	public static void HomeTheatersearch(WebDriver driver, String search) {
		driver.findElement(By.cssSelector("input[title*='Search for products']")).sendKeys(Keys.chord(search, Keys.ENTER));
	}
	
	public static Integer CountValue(WebDriver driver){
		String totalcount = driver.findElement(By.xpath("//div[@class='W_R1IA']/span")).getText();
		String[] value=totalcount.split("of");
		String[] convertedValue= value[1].split(" ");
		String finalcount = convertedValue[1].replace(",", "");
		return Integer.parseInt(finalcount);	
	}
	
	public static void CountComparision(WebDriver driver) throws InterruptedException {
		Integer totalProducts = CountValue(driver);
		driver.findElement(By.xpath("//*[@id='container']/div/div[3]/div[2]/div[1]/div[1]/div[2]/div/div/section[6]/div[2]/div/div[1]")).click();
		Thread.sleep(5000L);
		Integer fourStarredProducts = CountValue(driver);
		if(totalProducts > fourStarredProducts)
		{
			System.out.println("The count is reduced");
		}
	}
	
	public static void HighToLow(WebDriver driver) throws InterruptedException {
		String BLUECOLORHEXVALUE = "2874f0";
		driver.findElement(By.xpath("//div[@class='W_R1IA']/div[2]/div[4]")).click();
		Thread.sleep(4000L);
		String bckgclr = driver.findElement(By.xpath("//div[@class='W_R1IA']/div[2]/div[4]")).getCssValue("color");
		String hexColorValue = Color.fromString(bckgclr).asHex();
		String fontWeight  = driver.findElement(By.xpath("//div[@class='W_R1IA']/div[2]/div[4]")).getCssValue("font-weight");
		boolean isBold = "bold".equals(fontWeight) || "bolder".equals(fontWeight) || Integer.parseInt(fontWeight) >= 500;
		if(hexColorValue.contains(BLUECOLORHEXVALUE) && isBold == true)
		{
			System.out.println("The price high to low label is Bold and Blue upon clicking");
		}
		
	}
	public static void Sorting(WebDriver driver) throws Exception {
		List<WebElement> values=driver.findElements(By.cssSelector("div[class*='30jeq3']"));
		int maxnumber = 0; 
		for(int i=0;i<values.size();i++)
		{
			
			String value=values.get(i).getText().replace(",", "").substring(1);
			Integer itemPrice = Integer.parseInt(value);
			if (itemPrice <= maxnumber || i==0) {
				maxnumber = itemPrice;
			}
			else {
				throw new Exception("Prices are not sorted correctly");
			}
		}
		System.out.println("The prices are sorted from high to low");		
	}
	public static void HoverAddToCompare(WebDriver driver, Integer randomvalue){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		Actions action = new Actions(driver);		
		List<WebElement> cursor = driver.findElements(By.cssSelector("div[class*='30jeq3']"));
		action.moveToElement(cursor.get(randomvalue));
		List<WebElement> cursor2 = driver.findElements(By.xpath("//span[text()='Add to Compare']"));
		action.moveToElement(cursor2.get(randomvalue));
		action.click().build().perform();
		driver.findElement(By.xpath("//span[text()='Add to Compare']"));
	}
	public static void ClickCompare(WebDriver driver) throws InterruptedException{

		driver.findElement(By.xpath("//span[text()='COMPARE']")).click();
		Thread.sleep(4000L);
		String items= driver.findElement(By.xpath("//span[text()='2 items']")).getText();
		String[] comparedItems = items.split(" ");
		int count = Integer.parseInt(comparedItems[0].trim());
		System.out.println("The Number of items displayed for comparision is "+count);
	}

}
