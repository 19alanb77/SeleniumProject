package seleniumPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class representing "Chapter 2" page.
 * 
 * @author Alan Buda
 */
public class SecondChapterPage extends Page{

	public SecondChapterPage(WebDriver driver) {
		super(driver);
	}
	
	private WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@FindBy(xpath = "/html/body/div[2]/div[5]/input[1]" )
	private WebElement verifyButton;
	
	@FindBy(xpath = "/html/body/div[2]/div[3]/input[2]" )
	private WebElement siblingButton;
		
	/**
	 * Verifies that button is clickable.
	 * 
	 * @return SecondChapterPage object itself
	 */
	public SecondChapterPage verifyText() {
		wait.until(ExpectedConditions.elementToBeClickable(verifyButton));
		verifyButton.click();
		return this;
	}
	
	/**
	 * Clicks sibling button on the page.
	 * 
	 * @return SecondChapterPage object itself
	 */
	public SecondChapterPage clickSiblingButton() {
		siblingButton.click();
		return this;
	}
	
	/**
	 * Locates element and gets button ID.
	 * 
	 * @return SecondChapterPage object itself
	 */
	public SecondChapterPage getButtonID() {
		WebElement element = driver.findElement(By.xpath("//*[contains(text(), 'This element has a ID')]"));
		String result = element.getAttribute("id");
		System.out.println("ID of the element: " + result);
		return this;
	}

}