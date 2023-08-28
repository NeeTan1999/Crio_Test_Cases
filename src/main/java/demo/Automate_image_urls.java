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

public class Automate_image_urls {
    WebDriver driver;
    public Automate_image_urls()
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

    public void imageUrl()throws InterruptedException{
        //Navigate to https://in.bookmyshow.com/explore/home/chennai  
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // Locate all the images corresponding to the Recomended Movies Section Using Locator "XPath" //*[text()='Recommended Movies']/../../../following-sibling::div//img
        // Put all the elements located in a list   
        List<WebElement> list = driver.findElements(By.xpath("//*[text()='Recommended Movies']/../../../following-sibling::div//img"));
        // Iterate the Elements in the list using for-each loop and print the getAttribute("src") 
        for (WebElement image : list) {
           System.out.println(image.getAttribute("src"));
        }  
        // To get the name use getText() on the element found Using Locator "XPath" //*[text()='Premieres']/../../../following-sibling::div/div/div/div[2]/a/div/div[3]/div[1]
        Thread.sleep(4000);
        WebElement name = driver.findElement(By.xpath("//*[text()='Premieres']/../../../../div[2]//a[2]/div/div[3]/div[1]"));
        // Print the value  
        System.out.println(name);
        // To get the language use getText() on the element found Using Locator "XPath" //*[text()='Premieres']/../../../following-sibling::div/div/div/div[2]/a/div/div[3]/div[2]
        WebElement language = driver.findElement(By.xpath("//*[text()='Premieres']/../../../../div[2]//a[2]/div/div[3]/div[2]"));
        // Print the value  
        System.out.println(language);

    }
}
