import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OpenBrowserSoftassert {

    WebDriver driver  = null ;


    @BeforeTest
    public void OpenBrowser()  {

        String ChromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", ChromePath);
         driver  = new ChromeDriver() ;

        driver.manage().window().maximize();

    }

    @Test (priority = 1)
    public void ValidData () throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        SoftAssert soft = new SoftAssert();
        // first assertion
        String ExpectedResult = "You logged into a secure area!";
        String ActualResult = driver.findElement(By.id("flash")).getText();

        soft.assertTrue(ActualResult.contains(ExpectedResult),"first assert");

        // second assertion
        soft.assertTrue(driver.findElement(By.cssSelector("a[href=\"/logout\"]")).isDisplayed(),"second assert");

       //third assertion
        soft.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure","third assert");


        soft.assertAll();

    }
    @Test (priority = 2)
    public void InvalidData (){
        driver.navigate().to("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("to");
        driver.findElement(By.id("password")).sendKeys("hello");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);

        String ExpectedResult = "Your username is invalid!";
        String ActualResult = driver.findElement(By.id("flash")).getText();

        Assert.assertTrue(ActualResult.contains(ExpectedResult));


    }


    @AfterTest
    public void CloseBrowser(){

        driver.quit();


    }
}
