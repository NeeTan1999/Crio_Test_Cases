package demo;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
///

public class Search_Amazon {
    WebDriver driver;
    public Search_Amazon(){
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

    public void AmazonSearch(){
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Amazon");
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
        // Thread.sleep(2000);
        boolean result = driver.findElement(By.xpath("//span[contains(text(),'Amazon.in')]")).isDisplayed();
        System.out.println("the result is displaying :"+ result);

    }
    
}
