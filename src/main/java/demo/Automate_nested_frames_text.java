package demo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import org.openqa.selenium.Keys;
//import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

public class Automate_nested_frames_text {
    WebDriver driver;
    public Automate_nested_frames_text()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void nestedFrames()throws InterruptedException{
        // Navigate to https://the-internet.herokuapp.com/nested_frames  
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        Thread.sleep(4000);
        // Switch to the top frame  Driver.switchTo.frame(1)
        driver.switchTo().frame(0);
        // Switch to left frame inside the top frame  Driver.switchTo.frame(1)
        driver.switchTo().frame(0);
        // Locate the text to be printed  Using Locator "Tag Name" Driver.switchTo.frame(1)
        String left = driver.findElement(By.tagName("body")).getText();
        // Print the text using getText() 
        System.out.println("left value : "+ left); 
        // Come out of the left frame   Driver.switchTo.parentFrame()
        driver.switchTo().parentFrame();
        // Switch to middle frame inside the top frame  Driver.switchTo.frame(2)
        driver.switchTo().frame(1);
        // Locate the text to be printed  Using Locator "ID" "content"
        String middle = driver.findElement(By.id("content")).getText();
        // Print the text using getText()  
        System.out.println("middle value : "+ middle); 
        // Come out of the middle frame   Driver.switchTo.parentFrame()
        driver.switchTo().parentFrame();
        // Switch to Right frame inside the top frame  Driver.switchTo.frame(3)
        driver.switchTo().frame(2);
        // Locate the text to be printed  Using Locator "XPath" //body
        String right = driver.findElement(By.xpath("//body")).getText();
        // Print the text using getText()  
        System.out.println("right value : "+ right); 
        // Come out of the Right frame and go to default site to be able to go to bottom frame  Driver.switchTo.defaultContent()
        driver.switchTo().defaultContent();
        // Switch to bottom frame Using  Driver.switchTo.frame(2)
        driver.switchTo().frame(1);
        // Locate the text to be printed  Using Locator "XPath" //body
        String bottom = driver.findElement(By.xpath("//body")).getText();
        // Print the text using getText()  
        System.out.println("bottom value : "+ bottom); 
        // Come out of the bottom frame   Driver.switchTo.parentFrame()
        driver.switchTo().parentFrame();

    }

}
