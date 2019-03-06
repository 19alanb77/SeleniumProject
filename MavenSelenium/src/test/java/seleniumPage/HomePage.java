package seleniumPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class representing home page.
 * 
 * @author Alan Buda
 */
public class HomePage extends Page{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "/html/body/div[2]/ul/li[1]/a" )
	private WebElement firstChapterButton;
	
	@FindBy(xpath = "/html/body/div[2]/ul/li[2]/a" )
	private WebElement secondChapterButton;
	
	@FindBy(xpath = "/html/body/div[2]/ul/li[3]/a" )
	private WebElement thirdChapterButton;
	
	@FindBy(xpath = "/html/body/div[2]/ul/li[4]/a" )
	private WebElement fourthChapterButton;
	
	@FindBy(xpath = "/html/body/div[2]/ul/li[5]/a" )
	private WebElement fifthChapterButton;
	
	/**
	 * Selects Chapter 1 page.
	 * 
	 * @return FirstChapterPage being the next page on the website.
	 */
	public FirstChapterPage clickChapter1() {
		firstChapterButton.click();		
		return new FirstChapterPage(driver);
	}

	/**
	 * Selects Chapter 2 page.
	 * 
	 * @return SecondChapterPage being the next page on the website.
	 */
	public SecondChapterPage clickChapter2() {
		secondChapterButton.click();	
		return new SecondChapterPage(driver);
	}

	/**
	 * Selects Chapter 3 page.
	 * 
	 * @return ThirdChapterPage being the next page on the website.
	 */
	public ThirdChapterPage clickChapter3() {
		thirdChapterButton.click();	
		return new ThirdChapterPage(driver);
	}

	/**
	 * Selects Chapter 4 page.
	 * 
	 * @return FourthChapterPage being the next page on the website.
	 */
	public FourthChapterPage clickChapter4() {
		fourthChapterButton.click();	
		return new FourthChapterPage(driver);
	}

	/**
	 * Selects Chapter 5 page.
	 * 
	 * @return FifthChapterPage being the next page on the website.
	 */
	public FifthChapterPage clickChapter5() {
		fifthChapterButton.click();	
		return new FifthChapterPage(driver);
	}

}
