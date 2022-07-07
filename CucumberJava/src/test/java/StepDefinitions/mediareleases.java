package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.*;


public class mediareleases {

	WebDriver driver = null;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	@Given("user is on nsw government media releases page")
	public void user_is_on_nsw_government_media_releases_page() throws InterruptedException {
	   
		
		
	    String prjctPath = System.getProperty("user.dir");
	    System.setProperty("webdriver.edge.driver", prjctPath+"/src/test/resources/Drivers/msedgedriver.exe");
	    System.out.println(prjctPath);
	    //System.setProperty("webdriver.chrome.driver", prjctPath+"/src/test/resources/Drivers/chromedriver.exe");
	    driver = new EdgeDriver();
	    driver.navigate().to("https://www.nsw.gov.au/media-releases");
	    // driver.manage().window().maximize();
	    Thread.sleep(2000);
	}

	@When("user expands Filter by Minister")
	public void user_expands_filter_by_minister() throws InterruptedException {
	    System.out.println("user filter by Minister");
	   // driver.findElement(By.name("Filter by Minister")).click();
	    //Actions a = new Actions(driver);
	    //WebElement we = driver.findElement(By.className("search-filter__toggle"));
	    //WebElement we = driver.findElement(By.name("Filter by Minister"));
	   // a.scrollToElement(we).click();
	    //  a.moveToElement(we).click();
	     // a.perform();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,600)", "");
	    Thread.sleep(2000);
	   // driver.findElement(By.className("search-filter__toggle")).click();
	    driver.findElement(By.xpath("//*[@id='edit-fieldset-type']/div[1]/button")).click();
	    System.out.println("test scroll");
	    Thread.sleep(2000);
	}

	@And("^select a (.*) checkbox from the list$")
	public void select_a_the_premier_checkbox_from_the_list(String minister) throws InterruptedException {
		System.out.println("test minister");
		System.out.println("select Premier checkbox"+minister);
	    
	   //  driver.findElement(By.id("edit-field-ministers-target-id-464")).click();
	     driver.findElement(By.xpath("//*[@id=\'edit-fieldset-type\']/div[2]/div/div[1]/div/label")).click();
	     Thread.sleep(2000);
	    
	}

	@And("click on search button")
	public void click_on_search_button() throws InterruptedException {
	    System.out.println("click search");
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,1100)", "");
	    Thread.sleep(2000);
	    driver.findElement(By.id("edit-submit-media-release")).click();
	    
	}

	@Then("matching item cards displayed")
	public void matching_item_cards_displayed() throws InterruptedException {
	    System.out.println("item cards displayed");
	  //  if(driver.getPageSource().contains("The Premier"))
	  
	    Thread.sleep(2000);
	    WebElement text = driver.findElement(By.xpath("//*[@id=\'block-content\']/article/section[2]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div[1]"));
	    if(text.toString().contains("The Premier"))
	    {
	    	System.out.println("Relevant cards are displayed" +text);
	    }
	    Thread.sleep(2000);
	    driver.close();
		driver.quit();
		
	}
	@And("click on reset button")
	public void click_on_reset_button() throws InterruptedException {
		Thread.sleep(2000);
		 driver.findElement(By.name("op")).click();
	}

	@Then("all media releases are displayed")
	public void all_media_releases_are_displayed() {
	  boolean isDisplayed = driver.findElement(By.xpath("//*[@id=\'block-content\']/article/section[2]/div/div/div/div/div/div/div/aside/div/small")).isDisplayed();
	  Assert.isTrue(isDisplayed, "test");
	  driver.close();
	  driver.quit();
	}


}
