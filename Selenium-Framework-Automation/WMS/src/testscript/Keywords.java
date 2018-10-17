package testscript;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Keywords {
	
	static WebDriver driver;
	static Properties prop;
	static FileInputStream file;
	
	
	
	public void openbrowser() throws Exception{
		
		
		file = new FileInputStream("/home/techl333t/eclipse-workspace/WMS/src/objectrepository/objectrepository.properties");
		prop = new Properties();
		prop.load(file);
						
		System.setProperty("webdriver.chrome.driver", "/home/techl333t/FrameWork/chromedriver");
		driver = new ChromeDriver();
			
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}


	public void navigate(String testdata) throws InterruptedException{
		driver.get(testdata);
		Thread.sleep(1000);
	}


	public void input(String testdata, String objectName, String objectType) throws Exception{
		driver.findElement(this.getObject(objectName,objectType)).sendKeys(testdata);
		
				
	}
	
	public void ninput(Integer testdata, String objectName, String objectType) throws Exception{
		driver.findElement(this.getObject(objectName,objectType)).sendKeys(Integer.toString(testdata));
		
				
	}
	
	public void click(String objectName, String objectType) throws Exception {
		driver.findElement(this.getObject(objectName,objectType)).click();
		Thread.sleep(6000);
		
		String originalHandle = driver.getWindowHandle();

	    //Do something to open new tabs

	    for(String handle : driver.getWindowHandles()) {
	        if (!handle.equals(originalHandle)) {
	            driver.switchTo().window(handle);
	            driver.close();
	        }
	    }

	    driver.switchTo().window(originalHandle);

	}

	public void select(String testdata, String objectName, String objectType) throws Exception {
				
		Select select = new Select(driver.findElement(this.getObject(objectName,objectType)));
		select.selectByValue(testdata);
		
	}
	
	public void select1(String testdata, String objectName, String objectType) throws Exception {
		
		Select select1 = new Select(driver.findElement(this.getObject(objectName,objectType)));
		select1.selectByIndex(1);
		
	}
	
public void select2(String testdata, String objectName, String objectType) throws Exception {
		
		Select select2 = new Select(driver.findElement(this.getObject(objectName,objectType)));
		select2.selectByIndex(2);
		
	}

public void select3(String testdata, String objectName, String objectType) throws Exception {
	
	Select select3 = new Select(driver.findElement(this.getObject(objectName,objectType)));
	select3.selectByIndex(3);
	
}

public void chat (String testdata, String objectName, String objectType) throws Exception {
driver.findElement(this.getObject(objectName,objectType)).sendKeys(testdata);
Robot robochat = new Robot();
robochat.keyPress(KeyEvent.VK_ENTER);
robochat.keyRelease(KeyEvent.VK_ENTER);
}

public void oneslider (String objectName, String objectType) throws Exception {
	WebElement slider1 = driver.findElement(this.getObject(objectName,objectType));
	Actions move1 = new Actions(driver);
	Action action1 = (Action) move1.dragAndDropBy(slider1, 30, 0).build();
	action1.perform();
}

public static void HoverAndClick(String testdata, String objectName, String objectType) {
	Actions action = new Actions(driver);
	action.moveToElement(objectName).click().build().perform();
}

public void upload (String testdata, String objectName, String objectType) throws Exception {
	driver.findElement(this.getObject(objectName,objectType)).click();
	StringSelection stringSelection = new StringSelection(testdata);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(1000);
}


	public void check(String objectName, String objectType) throws Exception {
		List<WebElement>  checkbox = driver.findElements(this.getObject(objectName,objectType));
		 boolean bValue = false;
		 bValue = checkbox.get(0).isSelected();
		 if(bValue = true){
		 checkbox.get(1).click();
		 }else{
		 checkbox.get(0).click();
		 
		 }}
		 
		 
		 public void autosuggest(String testdata, String objectName, String objectType) throws Exception {
				
			WebElement listbox = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(this.getObject(objectName,objectType)));
			listbox.sendKeys(testdata);
			Thread.sleep(5000);
			listbox.sendKeys(Keys.DOWN);
			listbox.sendKeys(Keys.ENTER);		
		 }
	
	
	public void mousehover (String objectName, String objectType) throws Exception {
		Actions action = new Actions(driver);
		WebElement mainMenu = driver.findElement(this.getObject(objectName,objectType));
		action.moveToElement(mainMenu).moveToElement(driver.findElement(By.xpath("//i[@class=\"fa fa-eye\"]"))).build().perform();
	}
	
	public void scanner(String objectName, String objectType) throws Exception {

		Scanner scan1 = new Scanner(System.in);
		System.out.println("Enter the OTP");
		String otp1 = scan1.nextLine();
		driver.findElement(this.getObject(objectName,objectType)).sendKeys(otp1);
		
	}
	
	 
	
	private By getObject(String objectName, String objectType) throws Exception{
        
		//Find by xpath
        if(objectType.equalsIgnoreCase("XPATH")){
            
            return By.xpath(prop.getProperty(objectName));
        }
        //find by class
        else if(objectType.equalsIgnoreCase("CLASSNAME")){
            
            return By.className(prop.getProperty(objectName));
            
        }
        //find by name
        else if(objectType.equalsIgnoreCase("NAME")){
            
            return By.name(prop.getProperty(objectName));
            
        }
        //Find by id
        else if(objectType.equalsIgnoreCase("ID")){
            
            return By.id(prop.getProperty(objectName));
            
        }
        //find by link
        else if(objectType.equalsIgnoreCase("LINK")){
            
            return By.linkText(prop.getProperty(objectName));
            
        }
      //find by csselector
        else if(objectType.equalsIgnoreCase("CSS")){
            
            return By.cssSelector(prop.getProperty(objectName));
            
        }
        //find by partial link
        else if(objectType.equalsIgnoreCase("PARTIALLINK")){
            
            return By.partialLinkText(prop.getProperty(objectName));
            
        }else
        {
            throw new Exception("Wrong object type");
        }
    }


	public void numberinput(int testdata, String objectName, String objectType) throws Exception {
		driver.findElement(this.getObject(objectName,objectType)).sendKeys("testdata");
		
	}
	

}
