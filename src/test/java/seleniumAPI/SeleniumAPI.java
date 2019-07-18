package seleniumAPI;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import seleniumConfig.ConfigKeys;
import seleniumPage.FifthChapterPage;
import seleniumPage.FirstChapterPage;
import seleniumPage.FourthChapterPage;
import seleniumPage.HomePage;
import seleniumPage.SecondChapterPage;
import seleniumPage.ThirdChapterPage;

/**
 * Class that allows creating methods between "Page" type classes and scenario class.
 * 
 * @author Alan Buda
 */
public class SeleniumAPI {
	
	public static WebDriver driver;
	
	/**
	 * Sets ChromeDriver's path as environment property.
	 * 
	 * @param driver_path
	 *            Path of ChromeDriver 
	 */
	public static void setDriverProperty() {
		System.setProperty("webdriver.chrome.driver", ConfigKeys.getConfigKey("driver_path"));		
	}
	
	/**
	 * Method creates and sets the WebDriver with specified properties.
	 * 
	 * @param driver
	 *            An object implementing WebDriver interface
	 * @param time
	 *            The amount of time to wait
	 * @param unit
	 *            The unit of measure for time.
	 */
	public static void setDriver(long time, TimeUnit unit) {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(time, unit);
	}
	
	/**
	 * Close all driver's windows.
	 */
	public static void closeDriver() {
		driver.quit();
	}

	/**
	 * Goes to the specified page.
	 * 
	 * @param url
	 *            Url of the page.
	 */
	public static void goToPage(String url) {
		driver.get(url);		
	}

	/**
	 * Checks title of the page.
	 * 
	 * @param title
	 *            Title of the page.
	 */
	public static void checkTitle(String title) {
		String pageTitle = driver.getTitle();				 
		Assert.assertTrue(pageTitle.contains(title)); 	
	}

	/**
	 * Goes to the home page.
	 * 
	 */
	public static void goToHomePage() {
		goToPage(ConfigKeys.getConfigKey("home_page"));
	}

	/**
	 * Chooses first chapter page.
	 * 
	 */
	public static void chooseChapter1() {
		new HomePage(driver)
		.clickChapter1();		
	}
	
	/**
	 * Chooses second chapter page.
	 * 
	 */
	public static void chooseChapter2() {
		goToHomePage();
		new HomePage(driver)
		.clickChapter2();
	}
	
	/**
	 * Chooses third chapter page.
	 * 
	 */
	public static void chooseChapter3() {
		goToHomePage();
		new HomePage(driver)
		.clickChapter3();	
	}

	/**
	 * Chooses fourth chapter page.
	 * 
	 */
	public static void chooseChapter4() {
		goToHomePage();
		new HomePage(driver)
		.clickChapter4();		
	}

	/**
	 * Chooses fifth chapter page.
	 * 
	 */
	public static void chooseChapter5() {
		goToHomePage();
		new HomePage(driver)
		.clickChapter5();		
	}

	/**
	 * Executes all exercises from first chapter.
	 * 
	 */
	public static void chapterOneExercises() {
		new FirstChapterPage(driver)
		.clickRadioButton()
		.clickCheckBox()
		.pickFromListBox()
		.assertText()
		.closeWindow()
		.loadAjax()
		.loadText()
		.verifyText()
		.verifyButton()
		.enterText();
	}

	/**
	 * Executes all exercises from second chapter.
	 * 
	 */
	public static void chapterTwoExercises() {
		new SecondChapterPage(driver)
		.verifyText()
		.clickSiblingButton()
		.getButtonID();		
	}

	/**
	 * Executes all exercises from third chapter.
	 * 
	 */
	public static void chapterThreeExercises() {
		new ThirdChapterPage(driver)
		.verifyYear();	
	}

	/**
	 * Executes all exercises from fourth chapter.
	 * 
	 */
	public static void chapterFourExercises() {
		new FourthChapterPage(driver)
		.sendText()
		.pickFromListBox()
		.assertText()
		.mouseOver();		
	}

	/**
	 * Executes all exercises from fifth chapter.
	 * 
	 */
	public static void chapterFiveExercises() {
		new FifthChapterPage(driver)
		.checkCookies();		
	}

}
