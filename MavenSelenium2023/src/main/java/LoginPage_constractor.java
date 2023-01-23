import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_constractor {
    // 1- ba3raf web driver
        WebDriver driver ;

        //2- create constractor take input webdriver
    public LoginPage_constractor (WebDriver driver){
        //3- call driver that created to be equal driver from open browser
        this.driver = driver;

        // 1-create page factory
        PageFactory.initElements(driver,this);

    }

    //2- using page factory
    @FindBy (id="username")
    WebElement usernamePF;


    public WebElement UserNamePom ()
    {
        By UserName = By.id("username");
        WebElement UserNameEle = driver.findElement(UserName);
        return UserNameEle;

    }

    public WebElement PasswordPom ()
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

    public void LoginSteps (String UserName, String Password){
        usernamePF.sendKeys(UserName);
        PasswordPom().sendKeys(Password);
        PasswordPom().sendKeys(Keys.ENTER);
    }

}
