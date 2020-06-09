package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BuyBuyBabyTestCases {
	
	public WebDriver driver;
	
	@BeforeSuite(alwaysRun = true)
	public void setup(){
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/main/java/driver/chromedriver78.exe");
		driver = new ChromeDriver();
		driver.get("https://www.buybuybaby.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().refresh();
		
	}
	
	@Test(groups = "Regression")
	public void CheckPageTitle(){
		String PageTitle = driver.getTitle();
		Assert.assertEquals(PageTitle, "Baby Registry, High Chairs, Strollers, Car Seats, Nursery Room Decor & More | buybuy BABY");
	}
	
	@Test(groups = "Smoke Test")
	public void CheckSearchBox(){
				
		WebElement SearchBox = driver.findElement(By.xpath("//input[@id='searchInput']"));
		SearchBox.sendKeys("Shoes");
		WebElement SearchBoxClick = driver.findElement(By.xpath("//div[@class='SearchInput-inline_38DWwE SearchInput-inline_1gvLGf']//child::button[2]"));
		SearchBoxClick.click();
		WebElement CheckName = driver.findElement(By.xpath("//header[@class='SearchHeader_2UXZ7h flex content-margin-top px2 flex-column items-center justify-center']//child::h1"));
		Assert.assertEquals(CheckName.getText(), "“shoes”");
	}
 
  
	@AfterSuite(alwaysRun = true )

	public void closeBrowser() {
		 driver.close();
		 driver.quit();
	}
}
