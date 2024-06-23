package stepDefinationsFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Teststep2  {
	static WebDriver driver;
	String homePage = "https://rahulshettyacademy.com/client/dashboard/dash";
	
	
	@Given("I launch Chrome")
	public void I_launch_Chrome() {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
	}
	@Given("I navigate to the login page")
		public void I_navigate_to_the_login_page() {
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		}
	
	@When("I enter {string} and {string}")
	public void i_enter(String Username,String password) {
		WebElement el = driver.findElement(By.id("userEmail"));
		el.sendKeys(Username);
		WebElement el1 = driver.findElement(By.id("userPassword"));
		el1.sendKeys(password);
		driver.findElement(By.id("login")).click();
	}
	@Then("I should be navigated to the home page")
	public void i_should_be_navigated_to_the_home_page() throws InterruptedException {
		Thread.sleep(1000);
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(homePage,currentURL);
		driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[4]")).click();
	}

}
