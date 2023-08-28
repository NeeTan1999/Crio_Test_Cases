package demo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
import java.util.*;  

public class Automate_imdb_ratings {
    WebDriver driver;
    public Automate_imdb_ratings()
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

    public void imdbRatings()throws InterruptedException{
        //Navigate to https://www.imdb.com/chart/top/  Using driver.get()
        driver.get("https://www.imdb.com/chart/top/");
        // Locate the highest ratings movie on IMDb  Using Locator "XPath" //ul/li[1]/div[2]//h3
        WebElement highRating = driver.findElement(By.xpath("//ul/li[1]/div[2]//h3"));
        // Print it using getText()  
        System.out.println("highest rated movie on imdb is : "+ highRating.getText());
        // Locate the all top movies present in this table on IMDB Using Locator "XPath" 
        
        // Put it into a list and get lists size   
        List<WebElement> allmovies = driver.findElements(By.xpath("//ul/li/div[2]//h3"));
        // Print the Size/ Total no. of movies   Using list.size()
        System.out.println("Total no. of movies on table : "+ allmovies.size());
        // Locate all the years in which movies are released  Using Locator "XPath" //ul/li/div[2]/div/div/div[2]/span[1]
        List<WebElement> ele = driver.findElements(By.xpath("//ul/li/div[2]/div/div/div[2]/span[1]"));
        // using make a new list and cpoy all the years of release of all movies in the new list  
        List<Integer> years = new ArrayList<Integer>();
        for (WebElement y : ele) {
            int i = Integer.parseInt(y.getText());
            years.add(i);
        }
        // Get the minimum year out of it   Using collections.min(list)
        int oldestMovieReleasedYear = Collections.min(years);
        // again run a loop and compare each year with the min. year  
        int min_year_index = 0;
        for(int i = 0; i < years.size(); i++){

            if(oldestMovieReleasedYear == years.get(i)){
                min_year_index = i+1;
                break;
            }
        }
        // If matches locate the movie name from that block Using Locator "XPath" "//ul/li["+i+"]/div[2]//h3".     [i = no. of the movie on table]
        WebElement oldestmovie = driver.findElement(By.xpath("//ul/li["+min_year_index+"]/div[2]//h3"));
        // Print the movie name using getText()  
        System.out.println("oldest movie on the list is : "+oldestmovie.getText());
        // Make object of select class Using Locator "XPath" //select[@id ='sort-by-selector']
        Select a = new Select(driver.findElement(By.xpath("//select[@id ='sort-by-selector']")));
        
        // select the option with value "Release date"  
        a.selectByValue("RELEASE_DATE");
        // Locate the most recent movie on the list Using Locator "XPath" //ul/li[1]/div[2]//h3
        WebElement recentMovie = driver.findElement(By.xpath("//ul/li[1]/div[2]//h3"));
        // Print it using getText()  
        System.out.println("Most recent movie : "+ recentMovie.getText());
        // select the option with value "USER_RATING_COUNT"  
        a.selectByValue("USER_RATING_COUNT");
        // Locate the most user rated movie which is on the top of table  Using Locator "XPath" //ul/li[1]/div[2]//h3
        WebElement mostUserRated = driver.findElement(By.xpath("//ul/li[1]/div[2]//h3"));
        // Print it using getText()  
        System.out.println("Most rated movie : "+ mostUserRated.getText());

    }

}
