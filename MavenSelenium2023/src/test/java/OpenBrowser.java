import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenBrowser {

    WebDriver driver  = null ;


    @BeforeTest
    public void OpenBrowser(){

        String ChromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", ChromePath);
         driver  = new ChromeDriver() ;


        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
    }

    @Test
    public void ValidData (){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);

    }
    @Test
    public void InvalidData (){


    }
    @AfterTest
    public void CloseBrowser(){

        driver.quit();


    }
}
