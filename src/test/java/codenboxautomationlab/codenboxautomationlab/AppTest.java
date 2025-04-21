package codenboxautomationlab.codenboxautomationlab;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {
	
    WebDriver driver = new EdgeDriver();
	
	@BeforeTest
	public void mySetup() {
		driver.get("https://codenboxautomationlab.com/practice/");
		driver.manage().window().maximize();
		
		
	}
	
	@Test(priority=1, enabled = false)
	
	public void RadioButton() {
		
		List<WebElement> AllRadioButton =driver.findElements(By.className("radioButton"));
		
		int totalRadioButtons = driver.findElements(By.className("radioButton")).size();
		
		//int RandomRadioButtonIndex = rand.nextInt(totalRadioButtons);
		
	//	AllRadioButton.get(RandomRadioButtonIndex).click();
		
	}
	
	
	@Test(priority=2)
	public void Dynamic_Dropdown() throws InterruptedException {
		String[] countryPrefixes = {"Un","Ca","Ge","Fr","It","Sp","In","Br","Ch","Au"};
		
		WebElement InputField = driver.findElement(By.id("autocomplete"));
		InputField.sendKeys(countryPrefixes[5]);
		Thread.sleep(2000);
		InputField.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));
	}
	
	@Test(priority = 3)
	public void Static_Dropdown() {
		// Locate the dropdown element
		WebElement dropdownElement = driver.findElement(By.id("dropdown-class-example"));

		// Create Select object
		Select dropdown = new Select(dropdownElement);

		// Get all options
		List<WebElement> options = dropdown.getOptions();

		// Generate random index (start from 1 to avoid selecting "Select" option)
		Random random = new Random();
		int randomIndex = random.nextInt(options.size() - 1) + 1;

		// Select random option
		dropdown.selectByIndex(randomIndex);

		// Print selected option text
		System.out.println("Selected Option: " + options.get(randomIndex).getText());
	}


}
