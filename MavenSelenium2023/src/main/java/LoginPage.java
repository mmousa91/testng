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
}
