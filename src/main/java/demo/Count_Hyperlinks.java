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

public class Count_Hyperlinks {
    WebDriver driver;

    public Count_Hyperlinks() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void hyperlinksCount(){
        //Navigate to Bookmyshow URL  
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
       // Search for hyperlinks  Using Locator "XPath" //a
       // Put all the elements with hyperlink in a list  
       List<WebElement> links = driver.findElements(By.xpath("//a"));
        //Find the size of list using List.size() function  
        System.out.println("Total no. of hyperlinks present on site page are : "+ links.size());
    }
}
