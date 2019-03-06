package seleniumTest;		

import seleniumAPI.SeleniumAPI;
import java.io.IOException;
import java.util.concurrent.TimeUnit;	
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;	

/**
 * Test class for example scenario.
 * 
 * @author Alan Buda
 */
public class TestScenario {	
	
	@BeforeTest(description = "Init ChromeDriver with specified properties")
	public void init() throws IOException {
		SeleniumAPI.setDriverProperty();
		SeleniumAPI.setDriver(120, TimeUnit.SECONDS);
	}
	
	@Test(description = "Go to home page and choose first chapter")				
	public void firstChapter() {
		SeleniumAPI.goToHomePage();
		SeleniumAPI.checkTitle("Selenium: Beginners Guide");	
		SeleniumAPI.chooseChapter1();
	}
	
	@Test(description = "Do an exercises from chapter one", dependsOnMethods = "firstChapter")				
	public void firstChapterExercises() {	
		SeleniumAPI.chapterOneExercises();
	}
	
	@Test(description = "Go to home page and choose second chapter", dependsOnMethods = "firstChapterExercises")				
	public void secondChapter() {
		SeleniumAPI.chooseChapter2();
	}
	
	@Test(description = "Do an exercises from chapter two", dependsOnMethods = "secondChapter")				
	public void secondChapterExercises() {	
		SeleniumAPI.chapterTwoExercises();
	}
	
	@Test(description = "Go to home page and choose third chapter", dependsOnMethods = "secondChapterExercises")				
	public void thirdChapter() {
		SeleniumAPI.chooseChapter3();
	}
	
	@Test(description = "Do an exercises from chapter three", dependsOnMethods = "thirdChapter")				
	public void thirdChapterExercises() {	
		SeleniumAPI.chapterThreeExercises();
	}
	
	@Test(description = "Go to home page and choose fourth chapter", dependsOnMethods = "thirdChapterExercises")				
	public void fourthChapter() {
		SeleniumAPI.chooseChapter4();
	}
	
	@Test(description = "Do an exercises from chapter four", dependsOnMethods = "fourthChapter")				
	public void fourthChapterExercises() {	
		SeleniumAPI.chapterFourExercises();
	}
	
	@Test(description = "Go to home page and choose fifth chapter", dependsOnMethods = "fourthChapterExercises")				
	public void fifthChapter() {
		SeleniumAPI.chooseChapter5();
	}
	
	@Test(description = "Do an exercises from chapter five", dependsOnMethods = "fifthChapter")				
	public void fifthChapterExercises() {	
		SeleniumAPI.chapterFiveExercises();
	}
	
	@AfterTest(description = "Close all browser windows and safely end the session")
	public void afterTest() {
		SeleniumAPI.closeDriver();		
	}		
}	