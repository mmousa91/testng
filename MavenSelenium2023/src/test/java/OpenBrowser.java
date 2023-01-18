import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
    public static void main(String[] args) throws InterruptedException {

        String ChromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", ChromePath);

        //     System.setProperty("webdriver.chrome.driver", "C:\\Users\\MMousa\\IntelliJIDEAProjects\\MavenSelenium2023\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver  = new ChromeDriver() ;

        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        //driver.close();
        driver.quit();


    }
}
