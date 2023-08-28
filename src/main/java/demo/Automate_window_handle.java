package demo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;
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
import java.util.Iterator;

public class Automate_window_handle {
    WebDriver driver;
    public Automate_window_handle()
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

    public void windowHandle()throws InterruptedException{
        // Navigate to https://www.w3schools.com/jsref/tryit.aspfilename=tryjsref_win_open  
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        Thread.sleep(10000);
        // Locate button"Try it" and click on it Using Locator "XPath" //button[text()= 'Try it']
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("//button[text()= 'Try it']")).click();
        // Store current window handle in parent variable  String parent = driver.getWindowHandle()
        String parent = driver.getWindowHandle();
        // String parent = driver.getWindowHandle()
        // Store all the open windows in set  Set<String> set = driver.getWindowHandles()
        Set<String> set = driver.getWindowHandles();
        Iterator<String> iterator = set.iterator();
        // Now Iterate using for loop  for(!parent.equals(set.get[i])){driver.switchTo.window(set.get(i)}
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
                if (!parent.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                
                System.out.println("Title of new window opened is : "+ driver.getTitle());
                System.out.println("CurrentUrl of new window opened is : "+ driver.getCurrentUrl());
                driver.close();
            }
        }
        // get title and url of the page  and print these  getTitle(), getCurrentUrl()
        // Take screentshoot of the page and close the window  driver.close()
        // Switch back to original window using  driver.switchTo.window(parent)
        driver.switchTo().window(parent);
    }

}
