import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginClass {
    @FindBy(xpath="//input[@type='email']") private WebElement id;
    @FindBy(xpath="//span[text()='Next']") private WebElement next1;
    @FindBy(xpath="//input[@name='password']") private WebElement password;
    @FindBy(xpath="//span[text()='Next']") private WebElement next2;

    public LoginClass(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void Login() throws InvalidFormatException, IOException, InterruptedException
    {
        id.sendKeys(UtilityClass.getTD(0, 0));
        next1.click();
        password.sendKeys(UtilityClass.getTD(0,1));
        Thread.sleep(3000);
        next2.click();

    }


}
