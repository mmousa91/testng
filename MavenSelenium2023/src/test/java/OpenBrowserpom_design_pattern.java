import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenBrowserpom_design_pattern {

    WebDriver driver  = null ;

    // pom-design-pattern
    public WebElement UserNameEle (){

        By UserName = By.id("username");
        WebElement UserNameEle = driver.findElement(UserName);
        return UserNameEle;
    }

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

        //object from class loginPage
       LoginPage Loginpom = new LoginPage();
        Loginpom.UserNamePom(driver).sendKeys("tomsmith");

        // using UserElem method in same class
      //  UserNameEle().sendKeys("tomsmith");

        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        // first assertion
        System.out.println("first assert");
        String ExpectedResult = "You logged into a secure area!";
        String ActualResult = driver.findElement(By.id("flash")).getText();

        Assert.assertTrue(ActualResult.contains(ExpectedResult));

        // second assertion
        System.out.println("second assert");
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href=\"/logout\"]")).isDisplayed());

       //third assertion
        System.out.println("third assert");
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");




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
