import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenBrowser {

//    public static void main(String[] args) throws InterruptedException {
//        String ChromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver", ChromePath);
//
//        WebDriver driver = new ChromeDriver();
//
//
//        // 2-new object of webdriver
//        driver.navigate().to("https://the-internet.herokuapp.com/login");
//        driver.manage().window().maximize();
//        Thread.sleep(3000);
//
//        driver.findElement(By.id("username")).clear();
//      driver.findElement(By.id("username")).sendKeys("tomsmith");
//      driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//      driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
//
//        driver.close();
//    }
//    WebDriver driver = null;
    WebDriver driver = null ;

    @BeforeTest
    public void OpenBrowser() throws InterruptedException {
        String ChromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", ChromePath);

        driver = new ChromeDriver();


        // 2-new object of webdriver
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        System.out.println("open browser succes");
    }

    @Test
    public void ValidData()
    {
      driver.findElement(By.id("username")).clear();
      driver.findElement(By.id("username")).sendKeys("tomsmith");
      driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
      driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
     System.out.println("first case run");
    }

    @Test
    public void InvalidData()
    {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("to");
        driver.findElement(By.id("password")).sendKeys("Super");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
    }

   @AfterTest
    public void CloseDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();


    }
}
