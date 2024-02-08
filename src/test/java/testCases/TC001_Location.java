package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LocationPage;
import testBase.BaseClass;


public class TC001_Location extends BaseClass{
	
	@Test(priority=1,groups= {"sanity","master"})
	public void locationCountry() throws InterruptedException, IOException {
		HomePage hp = new HomePage(driver);
		hp.roamingClick();
		String title_act=hp.IndiaClick();
		Assert.assertEquals(title_act, p.getProperty("title"));
		Thread.sleep(3000);
		logger.info("--//Country chosen and title verified//--");
	}
	
	
	@Test(priority=2,groups= {"sanity","master"})
	public void locationCity() throws InterruptedException, IOException {
		LocationPage lp = new LocationPage(driver);
	
		lp.clickBangalore();
		logger.info("--//City chosen//--");
		Thread.sleep(3000);

	}

}
