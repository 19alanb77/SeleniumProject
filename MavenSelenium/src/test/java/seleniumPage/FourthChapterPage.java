package seleniumPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import junit.framework.Assert;

/**
 * Class representing "Chapter 4" page.
 * 
 * @author Alan Buda
 */
public class FourthChapterPage extends Page{

	public FourthChapterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "/html/body/div[2]/div[3]/p[1]" )
	private WebElement textArea;
	
	@FindBy(xpath = "//*[@id=\"dateInput\"]" )
	private WebElement inputText;

	@FindBy(xpath = "//*[@id=\"selecttype\"]" )
	private WebElement listbox;
	
	@FindBy(xpath = "//*[@id=\"blurry\"]" )
	private WebElement inputAlert;
	
	@FindBy(xpath = "//*[@id=\"selectLoad\"]" )
	private WebElement loadButton;
	
	@FindBy(xpath = "//*[@id=\"hoverOver\"]" )
	private WebElement mouseOver;
	
	
	/**
	 * Copies and moves text from one textarea to another.
	 * 
	 * @return FourthChapterPage object itself
	 */
	public FourthChapterPage sendText() {
		inputText.sendKeys(textArea.getText());
		return this;
	}
	
	/**
	 * Picks value from listbox.
	 * 
	 * @return FourthChapterPage object itself
	 */
	public FourthChapterPage pickFromListBox() {
		Select list = new Select(listbox);
		list.selectByVisibleText("Selenium Core");
		return this;
	}
	
	/**
	 * Checks text in the alert window.
	 * 
	 * @return FourthChapterPage object itself
	 */
	public FourthChapterPage assertText() {
		inputAlert.sendKeys("Example text");
		loadButton.click();
		Alert alert = driver.switchTo().alert();		   
        String alertMessage= driver.switchTo().alert().getText();			
        System.out.println(alertMessage);	        			
        alert.accept();		
		return this;
	}
	
	/**
	 * Mouseover event on the page.
	 * 
	 * @return FourthChapterPage object itself
	 */
	public FourthChapterPage mouseOver() {
		Actions builder = new Actions(driver);
		builder.moveToElement(mouseOver).perform();
		Alert alert = driver.switchTo().alert();				   
        String alertMessage= driver.switchTo().alert().getText();			
        Assert.assertEquals(true, alertMessage.contains("on MouseOver worked"));        			
        alert.accept();	
		return this;
	}
}
