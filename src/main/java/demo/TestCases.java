package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class TestCases {
    ChromeDriver driver;
    public TestCases()
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

    
    public  void testCase01() throws InterruptedException{

// Navigate to URL  https://www.imdb.com/chart/top
driver.get( "https://www.imdb.com/chart/top");

// use list to store all movies Using Locator "XPath" //div[@class='sc-14dd939d-0 fBusXE cli-children']
List<WebElement> movies= driver.findElements(By.xpath("//div[@class='sc-14dd939d-0 fBusXE cli-children']"));
System.out.println("List of movies contains : "+ movies.size() +" " + "movies");
// use get size method of list to get the first ranked movie-get text contains number 1 in it Using Locator "XPath" //div[@class='sc-14dd939d-0 fBusXE cli-children']//child::div//child::a//child::h3

List<WebElement> ranks=driver.findElements(By.xpath("//div[@class='sc-14dd939d-0 fBusXE cli-children']//child::div//child::a//child::h3"));

System.out.println("1st Ranked movie is : "+ ranks.get(0).getText());

// print last movie name by using size()-1  
System.out.println("lowest Ranked movie is : "+ ranks.get(ranks.size()-1).getText());

}


}
