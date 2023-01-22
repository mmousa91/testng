import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebElement UserNamePom (WebDriver driver)
    {
        By UserName = By.id("username");
        WebElement UserNameEle = driver.findElement(UserName);
        return UserNameEle;

    }

    public WebElement PasswordPom (WebDriver driver)
    {
        return driver.findElement(By.id("password"));
    }

    public By FlashPom ()
    {
        return By.id("flash");
    }

    public By CssPom (){

        return By.cssSelector("a[href=\"/logout\"]");
    }
}
