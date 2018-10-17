package testscript;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Keywords {

	
		static WebDriver driver;
		static Properties prop;
		static FileInputStream file;
		
		
		
		public void openbrowser() throws Exception{
			
			
			file = new FileInputStream("/home/techl333t/eclipse-workspace/Ribbn/src/objectrepository/objectrepository.properties");
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
					
			        //WebDriverWait waits = new WebDriverWait(driver, 5000);
			        //waitst.until(ExpectedConditions.visibilityOfElementLocated(By.name("sourceTitle")));

			        WebElement sourceTitle = driver.findElement(this.getObject(objectName,objectType));
			        sourceTitle.sendKeys(testdata);
			        WebElement first = driver.findElement(By.xpath("html/body/div[2]/div[1]/section[2]/div/div/div/div/div/form/div/div[4]/div[1]/p/ul/li/a/strong"));
	                first.click();		
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