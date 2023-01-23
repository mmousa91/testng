import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenBrowserpom_constr {

    WebDriver driver  = null ;
    LoginPage_constractor Loginpom ;




    @BeforeTest
    public void OpenBrowser()  {

        String ChromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", ChromePath);
         driver  = new ChromeDriver() ;

        driver.manage().window().maximize();
        // create object
        Loginpom = new LoginPage_constractor(driver);

    }


    @Test (priority = 1)
    public void ValidData () throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/login");

        Loginpom.LoginSteps("tomsmith","SuperSecretPassword!");

        Thread.sleep(3000);

        // first assertion
        System.out.println("first assert");
        String ExpectedResult = "You logged into a secure area!";
        String ActualResult = driver.findElement(Loginpom.FlashPom()).getText();

        Assert.assertTrue(ActualResult.contains(ExpectedResult));

        // second assertion
        System.out.println("second assert");
        Assert.assertTrue(driver.findElement(Loginpom.CssPom()).isDisplayed());

       //third assertion
        System.out.println("third assert");
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");




    }
    @Test (priority = 2)
    public void InvalidData (){
        driver.navigate().to("https://the-internet.herokuapp.com/login");

        Loginpom.LoginSteps("to","hello");


        String ExpectedResult = "Your username is invalid!";
        String ActualResult = driver.findElement(Loginpom.FlashPom()).getText();

        Assert.assertTrue(ActualResult.contains(ExpectedResult));


    }


    @AfterTest
    public void CloseBrowser(){

        driver.quit();


    }
}
