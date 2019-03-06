package seleniumPage;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import junit.framework.Assert;

/**
 * Class representing "Chapter 1" page.
 * 
 * @author Alan Buda
 */
public class FirstChapterPage extends Page{

	public FirstChapterPage(WebDriver driver) {
		super(driver);
	}
	
	private WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@FindBy(xpath = "//*[@id=\"radiobutton\"]" )
	private WebElement radioButton;
	
	@FindBy(xpath = "/html/body/div[2]/p[3]/input" )
	private WebElement checkboxButton;
	
	@FindBy(xpath = "//*[@id=\"selecttype\"]" )
	private WebElement listboxButton;
	
	@FindBy(xpath = "//*[@id=\"divontheleft\"]" )
	private WebElement assertText;
	
	@FindBy(xpath = "//*[@id=\"multiplewindow\"]" )
	private WebElement newWindow;
	
	@FindBy(xpath = "//*[@id=\"closepopup\"]" )
	private WebElement closePopUp;
		
	@FindBy(xpath = "//*[@id=\"loadajax\"]" )
	private WebElement loadAjax;
		
	@FindBy(xpath = "/html/body/div[9]/p" )
	private WebElement textAjax;
	
	@FindBy(xpath = "//*[@id=\"storeinput\"]" )
	private WebElement textArea;
	
	@FindBy(xpath = "//*[@id=\"secondajaxbutton\"]" )
	private WebElement loadTextButton;
	
	@FindBy(xpath = "//*[@id=\"html5div\"]" )
	private WebElement yellowFrameWindow;
	

	/**
	 * Clicks radio button on the page.
	 * 
	 * @return FirstChapterPage object itself
	 */
	public FirstChapterPage clickRadioButton() {
		radioButton.click();
		Assert.assertEquals(true, radioButton.isSelected());
		return this;
	}
	
	/**
	 * Clicks checkbox button on the page.
	 * 
	 * @return FirstChapterPage object itself
	 */
	public FirstChapterPage clickCheckBox() {
		checkboxButton.click();
		Assert.assertEquals(true, checkboxButton.isSelected());		
		return this;
	}
	
	/**
	 * Picks element from listbox.
	 * 
	 * @return FirstChapterPage object itself
	 */
	public FirstChapterPage pickFromListBox() {
		Select listbox = new Select(listboxButton);
		listbox.selectByVisibleText("Selenium RC");
		return this;
	}
	
	/**
	 * Checks text on the page.
	 * 
	 * @return FirstChapterPage object itself
	 */
	public FirstChapterPage assertText() {
		Assert.assertEquals("Assert that this text is on the page", assertText.getText());
		return this;
	}
	
	/**
	 * Opens new pop up window and close it. 
	 * 
	 * @return FirstChapterPage object itself
	 */
	public FirstChapterPage closeWindow() {
		
		String parentWindow = driver.getWindowHandle();
		newWindow.click();
		
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> iterator =windows.iterator();
        
        while (iterator.hasNext()) {
            String popupWindow=iterator.next().toString();
            if(!popupWindow.contains(parentWindow))
            {
            driver.switchTo().window(popupWindow);
            closePopUp.click();
            driver.switchTo().window(parentWindow);
            }
        }

		return this;
	}
	
	/**
	 * Clicks on the text and loads AJAX. 
	 * 
	 * @return FirstChapterPage object itself
	 */
	public FirstChapterPage loadAjax() {
		loadAjax.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[9]/p")));
		Assert.assertEquals(true, textAjax.getText().contains("The following text"));
		return this;
	}
	
	/**
	 * Loads text on the page. 
	 * 
	 * @return FirstChapterPage object itself
	 */
	public FirstChapterPage loadText() {
		loadTextButton.click();
		return this;
	}
	
	/**
	 * Verifies text on the page. 
	 * 
	 * @return FirstChapterPage object itself
	 */
	public FirstChapterPage verifyText() {
		Assert.assertEquals(true, yellowFrameWindow.getText().contains("I have been added"));
		return this;
	}
	
	/**
	 * Verifies that button is clickable on the page. 
	 * 
	 * @return FirstChapterPage object itself
	 */
	public FirstChapterPage verifyButton() { 
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"secondajax\"]")));
		element.click();		
		return this;
	}
	
	/**
	 * Inserts text to the input. 
	 * 
	 * @return FirstChapterPage object itself
	 */
	public FirstChapterPage enterText() {
		textArea.sendKeys("Example text");
		return this;
	}
	
}
