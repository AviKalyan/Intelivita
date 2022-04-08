package StepDefinitions;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class intelivitaTest {

	public static WebDriver driver = null;
	public static SoftAssert soft = new SoftAssert();

	@Given("^Open the browser$")
	public void open_the_browser() throws Throwable {

		System.setProperty("webdriver.driver.chrome", "H:\\Testing Projects\\Maven\\Intelivita\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@When("^Launch the a URL$")
	public void launch_the_a_url() throws Throwable {

		driver.get("https://www.intelivita.co.uk/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Then("^User should be displayed Home Page$")
	public void user_should_be_displayed_home_page() throws Throwable {

		// Validate Home Page Title.
		String homePageTitle = driver.getTitle();
		soft.assertEquals("Mobile App Development Company in UK | The Best App Developers UK", homePageTitle);

		// Validate application logo on Home Page.
		WebElement logo = driver.findElement(By.xpath("//div[@class='navbar-header']//a//img"));
		soft.assertTrue(logo.isDisplayed(), "Logo is not displayed");
		
		Thread.sleep(4000L);
		// Chat Box.
		driver.findElement(By.xpath("//div[@class='drift-widget-controller drift-widget-controller--align-right circle']"));
		
		WebElement chatBox = driver.findElement(By.xpath("//textarea[@class='drift-widget-input js-focus-visible--controlled']"));
		chatBox.sendKeys("Hello");
		
		//Click on chat box setting button.
		driver.findElement(By.xpath("//button[@aria-label='open composer settings']")).click();
		
		//Select new line radio button.
		driver.findElement(By.id("newLine")).click();
		soft.assertAll();
	}

	@When("^User goes to Company link$")
	public void user_goes_to_company_link() throws Throwable {

		// Mouse hover to Company.
		Actions action = new Actions(driver);
		WebElement company = driver.findElement(By.xpath("//a[text()='Company ']"));
		action.moveToElement(company).build().perform();

	}

	@Then("^User should be displayed all the company information options$")
	public void user_should_be_displayed_all_the_company_information_options() throws Throwable {

		Thread.sleep(2000);
		List<WebElement> linksCompany = driver
				.findElements(By.xpath("//ul[@class='sub-menu-normal accessible-megamenu-panel']//a"));
		System.out.println("Number of Sub Menus/Links of Company information: " + linksCompany.size());

	}

	@Given("^User is on HomePgae Company link$")
	public void user_is_on_homepgae_company_link() throws Throwable {

	}

	@When("^User click on Who We Are link$")
	public void user_click_on_who_we_are_link() throws Throwable {

		// Click on Who We Are link.
		WebElement whoWeAre = driver.findElement(By.xpath(
				"//ul[@class='sub-menu-normal accessible-megamenu-panel']//a[@href='https://www.intelivita.co.uk/about-us.php']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", whoWeAre);
		
	}

	@Then("^User should be displayed the Who We Are Page$")
	public void user_should_be_displayed_the_who_we_are_page() throws Throwable {

		// Validate the heading on Who We Are Page.
		WebElement heading = driver.findElement(By.xpath("//div[@class='tenc-intro-main__wrapper']//h1//span"));
		soft.assertEquals("We are Intelivita", heading.getText());

		WebElement subHeading = driver.findElement(By.xpath("//div[@class='tenc-intro-main__wrapper']//h1"));
		soft.assertEquals(" We Deliver the Code, Your Project Delivers the Change", subHeading.getText());

		// Validate Meet The Team Section.
		WebElement meetTeamSection = driver.findElement(By.xpath("//div[@class='meet-the-team-content']"));

		// Scroll to Meet The Team Content section.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", meetTeamSection);

		WebElement headingMeetTeam = driver.findElement(with(By.tagName("h2")).below(meetTeamSection));
		soft.assertEquals("Meet the Team", heading.getText());

		WebElement talksExpert = driver.findElement(with(By.tagName("a")).below(meetTeamSection));
		soft.assertEquals("Talk to Our Expert Now", talksExpert.getText());

		// Schedule a Call Now Functionality.
		// Title Validation.
		WebElement headingScheduleCall = driver.findElement(By.xpath("//h2[text()='Schedule a Call Now']"));
		soft.assertEquals("Schedule a Call Now", headingScheduleCall.getText());

		// Scroll to Schedule a Call Now section.
		js.executeScript("arguments[0].scrollIntoView();", headingScheduleCall);
		Thread.sleep(2000);

		// Enter name.
		WebElement name = driver
				.findElement(By.xpath("//div[@class='col-12 col-sm-12 col-lg-7']//input[@name='name']"));
		name.sendKeys("abc");

		// Enter email.
		WebElement email = driver
				.findElement(By.xpath("//div[@class='col-12 col-sm-12 col-lg-7']//input[@name='email']"));
		name.sendKeys("abc@gmail.com");

		// Select country code.
		WebElement countryList = driver
				.findElement(By.xpath("//div[@class='col-12 col-sm-12 col-lg-7']//div[@class='iti__flag-container']"));
		List<WebElement> countryNames = countryList.findElements(By.xpath("//li[@role='option']"));

		for (WebElement country : countryNames) {

			String nameCountry = country.getText();

			if (nameCountry.equalsIgnoreCase("India (भारत)")) {

				country.click();
			}
		}

		// Enter contact no.
		WebElement phone = driver
				.findElement(By.xpath("//div[@class='col-12 col-sm-12 col-lg-7']//input[@name='phone']"));
		name.sendKeys("1234567890");

		// Enter company name.
		WebElement companyName = driver
				.findElement(By.xpath("//div[@class='col-12 col-sm-12 col-lg-7']//input[@name='company_name']"));
		name.sendKeys("XYZ Ltd");

		// Select budget.
		WebElement budget = driver
				.findElement(By.xpath("//div[@class='col-12 col-sm-12 col-lg-7']//select[@name='budget']"));
		Select budgetDrop = new Select(budget);
		budgetDrop.selectByIndex(2);

		// Select region.
		WebElement region = driver
				.findElement(By.xpath("//div[@class='col-12 col-sm-12 col-lg-7']//select[@name='region']"));
		Select regionDrop = new Select(region);
		regionDrop.selectByValue("Asia");

		// Select region.
		WebElement services = driver
				.findElement(By.xpath("//div[@class='col-12 col-sm-12 col-lg-7']//select[@name='service']"));
		Select servicesDrop = new Select(services);
		servicesDrop.selectByValue("Web Development");

		// Select reference.
		WebElement reference = driver
				.findElement(By.xpath("//div[@class='col-12 col-sm-12 col-lg-7']//select[@name='reference']"));
		Select referenceDrop = new Select(reference);
		referenceDrop.selectByVisibleText("GoodFirms");

		// Message.
		WebElement msg = driver
				.findElement(By.xpath("//div[@class='col-12 col-sm-12 col-lg-7']//textarea[@name='message']"));
		msg.sendKeys("We want to build a Ecommerce web application.");

		// Captch check box.
		WebElement frmaeEle = driver
				.findElement(By.xpath("//div[@id='intelGrecaptchaScheduleCall']//iframe[@title='reCAPTCHA']"));
		driver.switchTo().frame(frmaeEle);

		driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();

		// Send Message button.
		WebElement sendMessage = driver.findElement(By.xpath(
				"//div[@class='col-12 col-sm-12 col-lg-7']//button[@class='btn-custome btn waves-effect waves-light contact-custome-btn']"));
		// sendMessage.click();
		
		soft.assertAll();

	}

	@Given("^User is on Who We Are Page$")
	public void user_is_on_who_we_are_page() throws Throwable {
	}

	@And("^User click on How We Work link$")
	public void user_click_on_how_we_work_link() throws Throwable {

		// Click on How We Work link.
		WebElement howWe = driver.findElement(By.xpath(
				"//ul[@class='sub-menu-normal accessible-megamenu-panel']https://www.intelivita.co.uk/process.php']"));
		Thread.sleep(1500L);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", howWe);
	}

	@Then("^User should be displayed the How We Work Page$")
	public void user_should_be_displayed_the_how_we_work_page() throws Throwable {

		// Validate heading of How We Work page.
		WebElement heading = driver
				.findElement(By.xpath("//div[@class='col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12']//h1"));
		soft.assertEquals("How Intelivita delivers value to your business", heading.getText());

		// Our Process.
		WebElement titleOurProcess = driver.findElement(By
				.xpath("//section[@class='padding-60-00 bg-light our-work-process-section']//div[@class='title']//h2"));
		soft.assertEquals("From discovery until deployment and beyond - the process in action",
				titleOurProcess.getText());

		soft.assertAll();
	}
}
