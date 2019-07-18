package seleniumPage;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Class representing "Chapter 3" page.
 * 
 * @author Alan Buda
 */
public class ThirdChapterPage extends Page{

	public ThirdChapterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"centerdiv\"]" )
	private WebElement centerText;
	
	/**
	 * Verifies that text on the page includes current year.
	 * 
	 * @return ThirdChapterPage object itself
	 */
	public ThirdChapterPage verifyYear() {
		String napis = centerText.getText();
		String[] tab = new String[napis.length()];
		tab = napis.split(" ");
		Assert.assertEquals(true, tab[tab.length - 1].equals(new SimpleDateFormat("yyyy").format(new Date())));
		return this;
	}

}
