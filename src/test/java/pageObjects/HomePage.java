package pageObjects;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;
import utilityFiles.ScreenShots;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	//WebElements
//	@FindBy(xpath = "//div[@id=\\\"pushengage-subscription-overlay-close-button\\\"]") WebElement popup;
	@FindBy(xpath = "(//button[@type='button' and text()='Nevermind! I am in a roaming mode.'])[1]") WebElement locationButton;
	@FindBy(xpath = "(//div[@class='col-xs-12 col-sm-6 col-md-4 col-lg-4'])[1]") WebElement IndiaTile;
//	
	@FindBy(xpath = "//div[@id='pushengage-subscription-overlay-close-button']") WebElement popup;
	public void closePopup() throws InterruptedException {
		try {
		if(popup.isDisplayed()) {
		Thread.sleep(2000);
		popup.click();
		Thread.sleep(1000);
	}
	}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	//Methods
//	public void closePopup() throws InterruptedException {
//		Thread.sleep(2000);
//		popup.click();
//		Thread.sleep(1000);
//	}
	
	public void roamingClick() throws InterruptedException {
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		closePopup();
		highlightElement(locationButton);
		explicitWait(locationButton,10);
		js.executeScript("arguments[0].click();", locationButton);
//		locationButton.click();
		
	}
	
	public String IndiaClick() throws InterruptedException, IOException {
        ScreenShots ss = new ScreenShots(driver);
        
        String title_act=driver.getTitle();
        
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)","");
		explicitWait(IndiaTile,10);
		Thread.sleep(2000);
		ss.screenshot("Country");
		highlightElement(IndiaTile);
		IndiaTile.click();
//		Thread.sleep(2000);
		return title_act;
	}
	

}
