package stepDefinationsFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Teststep1 {

	static WebDriver driver;
	@Given("I am on the login page of the website")
	public void i_am_on_the_login_page_of_the_website() {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
	}
	@When("I fills username and password")
	public void when_i_fills_username_and_password() {
		WebElement el = driver.findElement(By.xpath("//input[@id='username']"));
		el.sendKeys("rahulshettyacademy");
		WebElement el1 = driver.findElement(By.xpath("//input[@id='password']"));
		el1.sendKeys("learning");
	}
	@When("I selects radio button and accept popup alert")
	public void i_selects_radio_button_and_accept_popup_alert() throws InterruptedException {
		driver.findElement(By.xpath("(//span[@class='checkmark'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#okayBtn")).click();
	}
	@When("I select option from dropdon")
	public void i_select_option_from_dropdon() {
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select s = new Select(dropdown);
		s.selectByVisibleText("Student");
	}
	@Then("I click on SignIn button after selecting checkbox")
	public void i_click_on_sign_in_button_after_selecting_checkbox() {
		driver.findElement(By.cssSelector("#terms")).click();
		WebElement button = driver.findElement(By.cssSelector("#signInBtn"));
		button.click();
	}
	//Another Scenario practice for iframe
 //-------------------------------------------------

	@Given("I am on the login page of demo website")
	public void i_am_on_the_login_page_of_demo_website() throws InterruptedException {
	
		Thread.sleep(2000);	driver.get("https://demo.automationtesting.in/");
	}

	@When("I logs into application")
	public void i_logs_into_application() throws InterruptedException {
		driver.findElement(By.cssSelector("#email")).sendKeys("Shirish123@gmail.com");
		driver.findElement(By.id("enterimg")).click();
	}

	@When("I hover on {string} name")
	public void i_hover_on_name(String string) {
		Actions ac = new Actions(driver);
		WebElement hh  = driver.findElement(By.xpath("//a[text()='"+string+"']"));
		ac.moveToElement(hh).build().perform();
	}

	@When("I click on {string} option")
	public void i_click_on_option(String string) throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='"+string+"']")).click();
		Thread.sleep(3000);
	}

	@When("I click on iframe button")
	public void i_click_on_iframe_button() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		Thread.sleep(3000);
	}

	@When("I enter {string} into input field")
	public void i_enter_into_input_field(String string) {
		int framesCount = driver.findElements(By.tagName("iframe")).size();
		System.out.println(framesCount);
		WebElement ll = driver.findElement(By.cssSelector("iframe[src='MultipleFrames.html']"));
		driver.switchTo().frame(ll);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@class='row']/div/input[1]")).sendKeys(string);
	}

	@Then("I should be navigated back to the default frame")
	public void i_should_be_navigated_back_to_the_default_frame() {
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Home']")).click();

	}


}
