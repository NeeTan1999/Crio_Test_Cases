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

public class Automate_post_onLinkedin {
    WebDriver driver;

    public Automate_post_onLinkedin(){
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

    public void linkedinPost()throws InterruptedException{
        // Navigate to www.Linkedin.com  
        driver.get("https://www.linkedin.com/");
        Thread.sleep(4000);
        // Login using email and password and click on sign in
        driver.findElement(By.id("session_key")).sendKeys("1trulifee@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("Qwerty@123$");
        driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']")).click();
        // get the count of Who's viewed your profile Using function getText() Using Locator "XPath" //*[@id="ember603"]/div/div[2]/span
        // WebElement profileviews = driver.findElement(By.xpath("//*[@id='ember603']/div/div[2]/span"));
        // // Get the count of Impressions of your post Using function getText() Using Locator "XPath" //*[@id="ember605"]/div/div[2]/span/strong
        // WebElement impressions = driver.findElement(By.xpath("//*[@id='ember605']/div/div[2]/span/strong"));
        // System.out.println("Profile views count : "+profileviews.getText());
        // System.out.println("Impressions count : "+impressions.getText());
        // // Click the 'Start post' Input field Using Locator "ID" //*[@id="ember605"]/div/div[2]/span/strong
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[2]/div/div/main/div[2]/div[2]/div[2]/button")).click();
        
        // Click on "post to anyone' button Using Locator "ID" id='ember1052'
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/h2/button/div/div[2]/div[2]")).click();
        // Choose the 'connections only' radio button Using Locator "Class" Name 
        driver.findElement(By.xpath("//*[@id='CONNECTIONS_ONLY']/span[3]")).click();

        Thread.sleep(2000);
        // Click on Done button Using Locator "ID" id = 'ember1089'
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/button[2]/span")).click();
        Thread.sleep(2000);
        // Send Posts text using sendKeys() function Using Locator "XPath" //div[@class = 'editor-container relative']
        WebElement post = driver.findElement(By.xpath("//div[@class = 'editor-container relative']//p"));
        post.click();
        post.sendKeys("My first automated post");
        Thread.sleep(2000);
        // Click on Post Button Using Locator "ID" id = 'ember1122'
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/button")).click();
        Thread.sleep(2000);
        //Verify if post is posted
        boolean posted = driver.findElement(By.xpath("//*[contains(text(), 'My first automated post')]")).isDisplayed();
        System.out.println("Your post is posted : "+ posted);
    }

}
