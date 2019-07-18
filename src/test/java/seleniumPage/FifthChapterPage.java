package seleniumPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Class representing "Chapter 5" page.
 * 
 * @author Alan Buda
 */
public class FifthChapterPage extends Page{

	public FifthChapterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"secondCookie\"]" )
	private WebElement cookieButton;
	
	/**
	 * Checks added cookies.
	 * 
	 * @return FifthChapterPage object itself
	 */
	public FifthChapterPage checkCookies() {
		cookieButton.click();
        Set<Cookie> cookies = driver.manage().getCookies();
        List<Cookie> cookieList = new ArrayList<Cookie>(cookies); 

        for (int i=0; i<cookieList.size(); i++) {
            System.out.println("Cookie " + (i+1) + " : " + cookieList.get(i).getName() +
                    " value: " + cookieList.get(i).getValue());
        }

        Assert.assertEquals(true, cookieList.get(0).getName().equals("secondcookie"));
        System.out.println("Value of visitors counter: " + driver.manage().getCookieNamed("visitorCount").getValue());
		return this;
	}
}
