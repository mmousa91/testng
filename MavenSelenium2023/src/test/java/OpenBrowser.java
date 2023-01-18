import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
    public static void main(String[] args) throws InterruptedException {

        String ChromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", ChromePath);

        //     System.setProperty("webdriver.chrome.driver", "C:\\Users\\MMousa\\IntelliJIDEAProjects\\MavenSelenium2023\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver  = new ChromeDriver() ;


        //xpath with parent
        driver.findElement(By.xpath("//form[@id=\"login\"]//button[@type=\"submit\"]")).click();

// css selector with parent
        //  driver.findElement(By.cssSelector("form > button[type=\"submit\"]")).click();

        //css selector
        // driver.findElement(By.cssSelector("button[type=\"submit\"]"));

        // driver.findElement(By.linkText("Elemental Selenium")).click();
        // driver.findElement(By.partialLinkText("Selenium")).click();
        Thread.sleep(3000);

        //driver.close();
        driver.quit();


    }
}
